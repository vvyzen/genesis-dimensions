package vvyzen.genesismod.client.renderer.sky;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.RandomSource;
import net.minecraft.world.level.levelgen.SimpleRandomSource;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;
import java.util.Collections;

public class OtherworldSkyRenderer implements ISkyRenderHandler {
    private static final ResourceLocation SUN_LOCATION = new ResourceLocation("ssvrfi","textures/environment/theia_sun.png");

    @Nullable
    private VertexBuffer darkBuffer;
    public static final PerlinNoise perlinNoiseGenerator = new PerlinNoise((RandomSource)new SimpleRandomSource(8544L), Collections.singletonList(Integer.valueOf(-4)));

    public OtherworldSkyRenderer(){
    }

    @Override
    public void render(int ticks, float partialTicks, PoseStack matrixStack, ClientLevel world, Minecraft mc) {

    }
}
