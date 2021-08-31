package vvyzen.genesismod.client.renderer.sky;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.Util;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Option;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.BlockDestructionProgress;
import net.minecraft.util.Mth;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.SortedSet;

public class OtherworldSkyRenderer implements ISkyRenderHandler{
    private static final ResourceLocation SUN_LOCATION = new ResourceLocation("ssvrfi", "textures/environment/theia_sun.png");
    private static final ResourceLocation MOON_LOCATION = new ResourceLocation("ssvrfi","textures/environment/accursed_moon.png");
    private ClientLevel level;
    private int ticks;
    private Minecraft minecraft;
    private RenderBuffers renderBuffers;
    private TextureManager textureManager;
    @Nullable
    private VertexBuffer starBuffer;
    @Nullable
    private VertexBuffer skyBuffer;
    @Nullable
    private VertexBuffer darkBuffer;


    public void OtherworldSkyRenderer(PoseStack p_181410_, Matrix4f p_181411_, float p_181412_, Minecraft p_181413_) {
        p_181413_.run();
        net.minecraftforge.client.ISkyRenderHandler renderHandler = level.effects().getSkyRenderHandler();
        if (renderHandler != null) {
            renderHandler.render(ticks, p_181412_, p_181410_, level, minecraft);
            return;
        }
            if (this.minecraft.level.effects().skyType() == DimensionSpecialEffects.SkyType.NORMAL) {
                RenderSystem.disableTexture();
                Vec3 vec3 = this.level.getSkyColor(this.minecraft.gameRenderer.getMainCamera().getPosition(), p_181412_);
                float f = (float) vec3.x;
                float f1 = (float) vec3.y;
                float f2 = (float) vec3.z;
                FogRenderer.levelFogColor();
                BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
                RenderSystem.depthMask(false);
                RenderSystem.setShaderColor(f, f1, f2, 1.0F);
                ShaderInstance shaderinstance = RenderSystem.getShader();
                this.skyBuffer.drawWithShader(p_181410_.last().pose(), p_181411_, shaderinstance);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                float[] afloat = this.level.effects().getSunriseColor(this.level.getTimeOfDay(ticks), p_181412_);
                if (afloat != null) {
                    RenderSystem.setShader(GameRenderer::getPositionColorShader);
                    RenderSystem.disableTexture();
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    p_181410_.pushPose();
                    p_181410_.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                    float f3 = Mth.sin(this.level.getSunAngle(p_181412_)) < 0.0F ? 180.0F : 0.0F;
                    p_181410_.mulPose(Vector3f.ZP.rotationDegrees(f3));
                    p_181410_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                    float f4 = afloat[0];
                    float f5 = afloat[1];
                    float f6 = afloat[2];
                    Matrix4f matrix4f = p_181410_.last().pose();
                    bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
                    bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3]).endVertex();
                    int i = 16;

                    for (int j = 0; j <= 16; ++j) {
                        float f7 = (float) j * ((float) Math.PI * 2F) / 16.0F;
                        float f8 = Mth.sin(f7);
                        float f9 = Mth.cos(f7);
                        bufferbuilder.vertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
                    }

                    bufferbuilder.end();
                    BufferUploader.end(bufferbuilder);
                    p_181410_.popPose();
                }

                RenderSystem.enableTexture();
                RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                p_181410_.pushPose();
                float f11 = 1.0F - this.level.getRainLevel(p_181412_);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f11);
                p_181410_.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
                p_181410_.mulPose(Vector3f.XP.rotationDegrees(this.level.getTimeOfDay(p_181412_) * 360.0F));
                Matrix4f matrix4f1 = p_181410_.last().pose();
                float f12 = 30.0F;
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderTexture(0, SUN_LOCATION);
                bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
                bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
                bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
                bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
                bufferbuilder.end();
                BufferUploader.end(bufferbuilder);
                f12 = 20.0F;
                RenderSystem.setShaderTexture(0, MOON_LOCATION);
                int k = this.level.getMoonPhase();
                int l = k % 4;
                int i1 = k / 4 % 2;
                float f13 = (float) (l + 0) / 4.0F;
                float f14 = (float) (i1 + 0) / 2.0F;
                float f15 = (float) (l + 1) / 4.0F;
                float f16 = (float) (i1 + 1) / 2.0F;
                bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
                bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
                bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
                bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
                bufferbuilder.end();
                BufferUploader.end(bufferbuilder);
                RenderSystem.disableTexture();
                float f10 = this.level.getStarBrightness(p_181412_) * f11;
                if (f10 > 0.0F) {
                    RenderSystem.setShaderColor(f10, f10, f10, f10);
                    FogRenderer.setupNoFog();
                    this.starBuffer.drawWithShader(p_181410_.last().pose(), p_181411_, GameRenderer.getPositionShader());
                    minecraft.run();
                }

                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.disableBlend();
                p_181410_.popPose();
                RenderSystem.disableTexture();
                RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);
                double d0 = this.minecraft.player.getEyePosition(p_181412_).y - this.level.getLevelData().getHorizonHeight(this.level);
                if (d0 < 0.0D) {
                    p_181410_.pushPose();
                    p_181410_.translate(0.0D, 12.0D, 0.0D);
                    this.darkBuffer.drawWithShader(p_181410_.last().pose(), p_181411_, shaderinstance);
                    p_181410_.popPose();
                }

                if (this.level.effects().hasGround()) {
                    RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
                } else {
                    RenderSystem.setShaderColor(f, f1, f2, 1.0F);
                }

                RenderSystem.enableTexture();
                RenderSystem.depthMask(true);
            }
        }


    @Override
    public void render(int ticks, float partialTicks, PoseStack matrixStack, ClientLevel world, Minecraft mc) {

    }
}
