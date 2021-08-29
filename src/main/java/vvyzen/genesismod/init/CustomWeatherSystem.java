package vvyzen.genesismod.init;

import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import vvyzen.genesismod.weather.AcidRain;
import vvyzen.genesismod.weather.Weather;

import java.util.HashMap;
import java.util.List;

public class CustomWeatherSystem {
    public static final ResourceLocation ACID_RAIN = new ResourceLocation("ssvrfi","acid_rain");
    public static final ResourceLocation CLEAR = new ResourceLocation("ssvrfi","clear");


    public static HashMap<ResourceLocation, Double> WEATHER_EVENT_CONTROLLER = new HashMap<>();
    public static HashMap<ResourceLocation, Weather> WEATHER_EVENTS = new HashMap<>();
    public static final ObjectOpenHashSet<Weather> WEATHER_EVENTPOINT = new ObjectOpenHashSet();

    public static void weatherEventShitThatIDontUnderstand(){
        for (ObjectIterator<Weather> objectIterator = WEATHER_EVENTPOINT.iterator(); objectIterator.hasNext();) {
            Weather weatherEvent = objectIterator.next();
            WEATHER_EVENTS.put(weatherEvent.getID(), weatherEvent);
            WEATHER_EVENT_CONTROLLER.put(weatherEvent.getID(), Double.valueOf(weatherEvent.getDefaultChance()));
        }
    }
    public static void addWeather(){
        WEATHER_EVENTPOINT.add(new AcidRain());
    }

    private static ResourceLocation cachedEvent = ACID_RAIN;

    public static void weatherEventUpdate(ServerLevel world, List<ServerPlayer> players, boolean justJoined){

    }
}
