package vvyzen.genesismod.client.renderer;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import vvyzen.genesismod.client.renderer.sky.EdenSkyRenderer;
import vvyzen.genesismod.client.renderer.sky.OtherworldSkyRenderer;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class EdenRenderInfo extends DimensionSpecialEffects {
    private ISkyRenderHandler skyRenderer;

    public EdenRenderInfo() {
        super(-640, false, SkyType.NORMAL, false, false);
    }

    public Vec3 getBrightnessDependentFogColor(Vec3 p_108908_, float p_108909_) {
        return p_108908_.multiply(p_108909_ * 0.94F + 0.06F, p_108909_ * 0.94F + 0.06F, p_108909_ * 0.91F + 0.09F);
    }

    public boolean isFoggyAt(int p_108905_, int p_108906_) {
        return false;
    }

    @Nullable
    public net.minecraftforge.client.ICloudRenderHandler getCloudRenderHandler() {
        return null;
    }
    @Nullable
    public ISkyRenderHandler getSkyRenderHandler() {
        if (this.skyRenderer == null)
            this.skyRenderer = new EdenSkyRenderer();
        return this.skyRenderer;
    }
}
