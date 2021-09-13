package vvyzen.genesismod.client.renderer.sky;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class TethysSkyRenderer implements ISkyRenderHandler{
    private static final ResourceLocation SUN_LOCATION = new ResourceLocation("ssvrfi", "textures/environment/tethys_star.png");
    private Minecraft minecraft;
    @Nullable
    private VertexBuffer skyBuffer;
    @Nullable
    private VertexBuffer darkBuffer;

    public TethysSkyRenderer() {
        this.minecraft = Minecraft.getInstance();
        createLightSky();
        createDarkSky();
    }

    private void createDarkSky() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        if (this.darkBuffer != null) {
            this.darkBuffer.close();
        }

        this.darkBuffer = new VertexBuffer();
        buildSkyDisc(bufferbuilder, -16.0F);
        this.darkBuffer.upload(bufferbuilder);
    }

    private void createLightSky() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        if (this.skyBuffer != null) {
            this.skyBuffer.close();
        }

        this.skyBuffer = new VertexBuffer();
        buildSkyDisc(bufferbuilder, 16.0F);
        this.skyBuffer.upload(bufferbuilder);
    }
    private static void buildSkyDisc(BufferBuilder p_172948_, float p_172949_) {
        float f = Math.signum(p_172949_) * 512.0F;
        float f1 = 512.0F;
        RenderSystem.setShader(GameRenderer::getPositionShader);
        p_172948_.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
        p_172948_.vertex(0.0D, (double)p_172949_, 0.0D).endVertex();

        for(int i = -180; i <= 180; i += 45) {
            p_172948_.vertex((double)(f * Mth.cos((float)i * ((float)Math.PI / 180F))), (double)p_172949_, (double)(512.0F * Mth.sin((float)i * ((float)Math.PI / 180F)))).endVertex();
        }

        p_172948_.end();
    }
    @Override
    public void render(int ticks, float partialTicks, PoseStack matrixStack, ClientLevel world, Minecraft mc) {
            RenderSystem.disableTexture();
            Vec3 vec3 = world.getSkyColor(this.minecraft.gameRenderer.getMainCamera().getPosition(), partialTicks);
            float f = (float) vec3.x;
            float f1 = (float) vec3.y;
            float f2 = (float) vec3.z;
            FogRenderer.levelFogColor();
            BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(f, f1, f2, 1.0F);
            ShaderInstance shaderinstance = RenderSystem.getShader();
            this.skyBuffer.drawWithShader(matrixStack.last().pose(), matrixStack.last().pose()  , shaderinstance);


            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            float[] afloat = world.effects().getSunriseColor(world.getTimeOfDay(ticks), partialTicks);
            if (afloat != null) {
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                RenderSystem.disableTexture();
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                matrixStack.pushPose();
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                float f3 = Mth.sin(world.getSunAngle(partialTicks)) < 0.0F ? 180.0F : 0.0F;
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(f3));
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                float f4 = afloat[0];
                float f5 = afloat[1];
                float f6 = afloat[2];
                Matrix4f matrix4f = matrixStack.last().pose();
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
                matrixStack.popPose();
            }

            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            matrixStack.pushPose();
            float f11 = 1.0F - world.getRainLevel(partialTicks) * 0.5F;
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f11);
            matrixStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360.0F));
            Matrix4f matrix4f1 = matrixStack.last().pose();
            float f12 = 16.0F;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, SUN_LOCATION);
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
            bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
            bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
            bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
            bufferbuilder.end();
            BufferUploader.end(bufferbuilder);
            //RenderSystem.disableTexture();
            float f10 = (world.getStarBrightness(partialTicks) * f11) + 0.1F;
            if (f10 > 0.0F) {
                FogRenderer.setupNoFog();
                StarRenderer.RenderStars(matrixStack, 3000, new Random(32592L), world, partialTicks, 0.8F, 0.2F, false, true);
                }

            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableBlend();
            matrixStack.popPose();
            RenderSystem.disableTexture();
            RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);
            double d0 = this.minecraft.player.getEyePosition(partialTicks).y - world.getLevelData().getHorizonHeight(world);
            if (d0 < 0.0D) {
                matrixStack.pushPose();
                matrixStack.translate(0.0D, 12.0D, 0.0D);
                this.darkBuffer.drawWithShader(matrixStack.last().pose(), matrixStack.last().pose(), shaderinstance);
                matrixStack.popPose();
            }

            if (world.effects().hasGround()) {
                RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
            } else {
                RenderSystem.setShaderColor(f, f1, f2, 1.0F);
            }

            RenderSystem.enableTexture();
            RenderSystem.depthMask(true);

    }


}
