package vvyzen.genesismod.client.renderer.sky;

import ca.weblite.objc.Client;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import vvyzen.genesismod.util.ClinkerMathUtils;
import vvyzen.genesismod.util.GenesisUtils;

import java.util.Random;

public class StarRenderer {

    private final Minecraft minecraft = Minecraft.getInstance();



    public static void RenderStars(PoseStack matrixStackIn, float starCount, Random random, ClientLevel world, float partialTicks) {
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionShader);
        //Matrix4f matrix4f = matrixStackIn.last().pose();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        matrixStackIn.pushPose();

        int skyRadius = 50;
        double starRadius = (skyRadius / 3.0F - 2.0F);

        for(int i = 0; i < starCount; ++i) {

            //matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
            //matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360.0F));


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

                //matrix4f.multiply(Vector3f.YP.rotationDegrees(-90.0F));
                //matrix4f.multiply(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360.0F));

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

                    float[] rgb = GenesisUtils.BlackbodyRGBGenerator(random,1.0F, 0.4F, 10, 0.6F);

                    float r = rgb[0];
                    float g = rgb[1];
                    float b = rgb[2];

                    float starHeight = Math.abs((ClinkerMathUtils.mapRange(0.0F, (float)starDistance, 0.1F, 1.0F, ((float)(d6 + d23)))));
                    float starValue = ClinkerMathUtils.getRandomFloatBetween(random, 0.8F, 1.2F);
                    //float starBrightness = ClinkerMathUtils.mapRange(0.0F, world.getTimeOfDay(partialTicks), 0.0F, 1.0F, world.getTimeOfDay(partialTicks));
                    float starBrightness = world.getStarBrightness(partialTicks);

                    float red = (r)*starValue;
                    float green = (g)*starValue;
                    float blue = (b)*starValue;

                    RenderSystem.setShaderColor(red,green,blue, starBrightness*starHeight);
                    //matrixStackIn.pushPose();
                    //matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
                    //matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360.0F));
                    Matrix4f matrix4f = matrixStackIn.last().pose();
                    bufferbuilder.vertex(matrix4f,(float)(d5 + d25), (float)(d6 + d23), (float)(d7 + d26)).endVertex();
                }
                tesselator.end();
            }
        }
        RenderSystem.disableBlend();
        matrixStackIn.popPose();

    }
}
