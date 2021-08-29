package vvyzen.genesismod.weather;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class Weather {
    private final ResourceLocation name;
    private final double defaultChance;

    public Weather(ResourceLocation name, double defaultChance){
        this.name = name;
        this.defaultChance = defaultChance;
    }
    public final ResourceLocation getID(){
        return this.name;
    }
    public final double getDefaultChance(){
        return this.defaultChance;
    }

    public void livingEntityUpdate(Entity entity){}

    public float modifyFogDensity(){
        return 0.0f;
    }
    public boolean refreshPlayerHandler(){
        return false;
    }
    @OnlyIn(Dist.CLIENT)
    public void onCommandWeatherChange(){}
}
