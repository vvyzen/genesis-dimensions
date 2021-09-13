package vvyzen.genesismod.client.renderer.sky;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import vvyzen.genesismod.util.ClinkerMathUtils;
import vvyzen.genesismod.util.GenesisUtils;

import java.util.Random;

public class StarRenderer {

    public static void RenderStars(PoseStack matrixStackIn, float starCount, Random random, ClientLevel world, float partialTicks, float flatStarBrightness, float starHeightMin, boolean renderHalf, boolean sunPresent) {
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionShader);

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        matrixStackIn.pushPose();

        int skyRadius = 50;
        double starRadius = (skyRadius / 3.0F - 2.0F);

        for(int i = 0; i < starCount; ++i) {

            double starX = (double)(random.nextFloat() * 2.0F - 1.0F);
            double starY = (double)(random.nextFloat() * 2.0F - 1.0F);
            double starZ = (double)(random.nextFloat() * 2.0F - 1.0F);
            double starSize = (double)(0.008F + random.nextFloat() * 0.05F);
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

                    float[] rgb = GenesisUtils.BlackbodyRGBGenerator(random,1.0F, 0.4F, 10, 0.6F);

                    float r = rgb[0];
                    float g = rgb[1];
                    float b = rgb[2];

                    float starHeight = ((ClinkerMathUtils.mapRange(0.0F, (float)starDistance, starHeightMin, 1.0F, ((float)(d6 + d23)))));
                    float starHeight2 = 0.0F;

                    if(sunPresent){
                        starHeight2 = Mth.clamp((float) Math.pow((starHeight), 10.0F)-0.4F, 0.0F, 1.0F);
                    }

                    float starValue = ClinkerMathUtils.getRandomFloatBetween(random, 0.8F, 1.2F);
                    float starBrightness = Mth.clamp((world.getStarBrightness(partialTicks))+(flatStarBrightness-starHeight2), 0.0F, 1.0F);

                    float red = (r)*starValue;
                    float green = (g)*starValue;
                    float blue = (b)*starValue;

                    RenderSystem.setShaderColor(red,green,blue, (starBrightness*Math.abs(starHeight))-Math.abs(starHeight2));
                    Matrix4f matrix4f = matrixStackIn.last().pose();
                    if(starHeight > 0.0F || !renderHalf) {
                        bufferbuilder.vertex(matrix4f, (float) (d5 + d25), (float) (d6 + d23), (float) (d7 + d26)).endVertex();
                    }
                }
                tesselator.end();
            }
        }
        RenderSystem.disableBlend();
        matrixStackIn.popPose();

    }
}
