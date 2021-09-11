package vvyzen.genesismod.client.renderer;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import vvyzen.genesismod.client.renderer.sky.OtherworldSkyRenderer;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class OtherworldRenderInfo extends DimensionSpecialEffects {
    private ISkyRenderHandler skyRenderer;

    public OtherworldRenderInfo() {
        super(192.0F, true, DimensionSpecialEffects.SkyType.NORMAL, false, false);
    }

    public Vec3 getBrightnessDependentFogColor(Vec3 p_108908_, float p_108909_) {
        return p_108908_.multiply(p_108909_ * 0.94F + 0.06F, p_108909_ * 0.94F + 0.06F, p_108909_ * 0.91F + 0.09F);
    }

    public boolean isFoggyAt(int p_108905_, int p_108906_) {
        return false;
    }

    @Nullable
    public ISkyRenderHandler getSkyRenderHandler() {
        if (this.skyRenderer == null)
            this.skyRenderer = new OtherworldSkyRenderer();
        return this.skyRenderer;
    }
}
