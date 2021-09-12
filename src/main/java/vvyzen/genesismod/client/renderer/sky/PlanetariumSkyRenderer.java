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
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;
import vvyzen.genesismod.util.GenesisUtils;
import vvyzen.genesismod.util.ClinkerMathUtils;

import javax.annotation.Nullable;
import java.util.Random;

public class PlanetariumSkyRenderer implements ISkyRenderHandler{
    private Minecraft minecraft;
    private VertexBuffer starBuffer;
    @Nullable
    private VertexBuffer skyBuffer;
    @Nullable
    private VertexBuffer darkBuffer;

    public PlanetariumSkyRenderer() {
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

    private void drawStars(BufferBuilder p_109555_) {
        Random random = new Random(10842L);
        p_109555_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

        for(int i = 0; i < 1500; ++i) {
            double d0 = (double)(random.nextFloat() * 2.0F - 1.0F);
            double d1 = (double)(random.nextFloat() * 2.0F - 1.0F);
            double d2 = (double)(random.nextFloat() * 2.0F - 1.0F);
            double d3 = (double)(0.15F + random.nextFloat() * 0.1F);
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d4 < 1.0D && d4 > 0.01D) {
                d4 = 1.0D / Math.sqrt(d4);
                d0 = d0 * d4;
                d1 = d1 * d4;
                d2 = d2 * d4;
                double d5 = d0 * 100.0D;
                double d6 = d1 * 100.0D;
                double d7 = d2 * 100.0D;
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = random.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for(int j = 0; j < 4; ++j) {
                    double d17 = 0.0D;
                    double d18 = (double)((j & 2) - 1) * d3;
                    double d19 = (double)((j + 1 & 2) - 1) * d3;
                    double d20 = 0.0D;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    p_109555_.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }
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
            this.skyBuffer.drawWithShader(matrixStack.last().pose(), matrixStack.last().pose(), shaderinstance);

            renderStars(matrixStack);

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
            float f12 = 60.0F;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            /*RenderSystem.setShaderTexture(0, SUN_LOCATION);
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
            bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
            bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
            bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
            bufferbuilder.end();
            BufferUploader.end(bufferbuilder);*/
            //RenderSystem.disableTexture();
            float f10 = world.getStarBrightness(partialTicks) * f11;
            /*if (f10 > 0.0F) {
                FogRenderer.setupNoFog();
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                this.starBuffer.drawWithShader(matrixStack.last().pose(), matrixStack.last().pose(), GameRenderer.getPositionShader());
            }*/

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

    /*private void renderStars(PoseStack matrixStackIn, float skyRadius, Random rand, int ticksIn, float partialTicks){
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionShader);
        matrixStackIn.pushPose();
        float ticks = ticksIn + partialTicks;

        int starCount = 500;
        double starRadius = (skyRadius / 3.0F - 2.0F);
        for(int i = 0; i < starCount; i++){
            double starX = (rand.nextFloat() * 2.0F - 1.0F);
            double starY = rand.nextFloat();
            double starZ = (rand.nextFloat() * 2.0F - 1.0F);
            double starSize = (0.01F + rand.nextFloat() * 0.017F);
            double starDistance = starRadius * (0.65F + Math.random() * (1.0F - 0.65F));



        }
    }*/

    private void renderStars(PoseStack matrixStackIn) {
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionShader);
        Matrix4f matrix4f = matrixStackIn.last().pose();
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        Random random = new Random(73526L);
        matrixStackIn.pushPose();

        int skyRadius = 50;
        int starCount = 10000;
        double starRadius = (skyRadius / 3.0F - 2.0F);

        for(int i = 0; i < starCount; ++i) {

            double starX = (double)(random.nextFloat() * 2.0F - 1.0F);
            double starY = (double)(random.nextFloat() * 2.0F - 1.0F);
            double starZ = (double)(random.nextFloat() * 2.0F - 1.0F);
            double starSize = (double)(0.004F + random.nextFloat() * 0.05F);
            double starDistance = starRadius * ClinkerMathUtils.getRandomFloatBetween(random, 0.65F, 1.0F);

            double d4 = starX * starX + starY * starY + starZ * starZ;
            if (d4 < 1.0D && d4 > 0.01D) {
                d4 = 1.0D / Math.sqrt(d4);
                starX = starX * d4;
                starY = starY * d4;
                starZ = starZ * d4;
                double d5 = starX * starDistance;
                double d6 = starY * starDistance;
                double d7 = starZ * starDistance;
                double d8 = Math.atan2(starX, starZ);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(starX * starX + starZ * starZ), starY);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = random.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
                for(int j = 0; j < 4; ++j) {
                    double d17 = 0.0D;
                    double d18 = (double)((j & 2) - 1) * starSize;
                    double d19 = (double)((j + 1 & 2) - 1) * starSize;
                    double d20 = 0.0D;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;

                    //float r = (MathUtils.getRandomFloatBetween(random,230.0F, 245.0F)/255.0F);
                    //float g = (MathUtils.getRandomFloatBetween(random,190.0F, 245.0F)/255.0F);
                    //float b = (MathUtils.getRandomFloatBetween(random,210.0F, 245.0F)/255.0F);
                    float[] rgb = GenesisUtils.BlackbodyRGBGenerator(random,1.0F, 0.4F, 10, 0.6F);

                    float r = rgb[0];
                    float g = rgb[1];
                    float b = rgb[2];

                    float starHeight = Math.abs((ClinkerMathUtils.mapRange(0.0F, (float)starDistance, 0.05F, 1.0F, ((float)(d6 + d23)))));
                    float starBrightness = ClinkerMathUtils.getRandomFloatBetween(random, 0.8F, 1.2F);

                    float red = (r*starHeight)*starBrightness;
                    float green = (g*starHeight)*starBrightness;
                    float blue = (b*starHeight)*starBrightness;

                    RenderSystem.setShaderColor(red,green,blue, 1.0F);
                    bufferbuilder.vertex(matrix4f,(float)(d5 + d25), (float)(d6 + d23), (float)(d7 + d26)).endVertex();
                }
                tesselator.end();
            }
        }
        matrixStackIn.popPose();

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();

    }

}
