package vvyzen.genesismod.world.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;
import vvyzen.genesismod.init.CustomWeatherSystem;
import vvyzen.genesismod.weather.Weather;

public class WeatherData extends SavedData {
    public static String DATA_NAME = "ssvrfi:weather_data";
    private static final WeatherData CLIENT_CACHE = new WeatherData();
    private ResourceLocation event = CustomWeatherSystem.CLEAR;

    private boolean isWeatherForced;
    private boolean modified;
    private int rainTime;
    private int clearWeatherTime;
    public static Weather currentWeather;

    /*public static WeatherData get(LevelAccessor world){
        if (!(world instanceof ServerLevel))
            return CLIENT_CACHE;
        ServerLevel frostWorld = ((ServerLevel)world).m_6018_().m_142572_().m_129880_(FrostDimensions.frostrealm);
        DimensionDataStorage data = frostWorld.m_8895_();
        WeatherData weatherData = (WeatherData)data.m_164861_(WeatherData::load, WeatherData::new, DATA_NAME);
    }*/



    @Override
    public CompoundTag save(CompoundTag p_77763_) {
        return null;
    }
}
