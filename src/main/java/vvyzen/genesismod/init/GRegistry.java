package vvyzen.genesismod.init;

import com.google.common.collect.Maps;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.Map;
import java.util.function.Supplier;

public class GRegistry {
    private static final Map<ResourceLocation, Supplier<?>> LOADERS = Maps.newLinkedHashMap();
    protected static final WritableRegistry<WritableRegistry<?>> WRITABLE_REGISTRY = new MappedRegistry<>(createRegistryKey("root"), Lifecycle.experimental());


    public static final ResourceKey<net.minecraft.core.Registry<TrunkPlacerType<?>>> TRUNK_PLACER_REGISTRY = createRegistryKey("worldgen/trunk_placer_type");

    public static final net.minecraft.core.Registry<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = registerSimple(TRUNK_PLACER_REGISTRY, () -> {
        return TrunkPlacerType.STRAIGHT_TRUNK_PLACER;
    });
    private static <T> ResourceKey<net.minecraft.core.Registry<T>> createRegistryKey(String p_122979_) {
        return ResourceKey.createRegistryKey(new ResourceLocation(p_122979_));
    }

    private static <T> net.minecraft.core.Registry<T> registerSimple(ResourceKey<? extends net.minecraft.core.Registry<T>> p_123000_, Supplier<T> p_123001_) {
        return registerSimple(p_123000_, Lifecycle.experimental(), p_123001_);
    }

    private static <T> net.minecraft.core.Registry<T> registerSimple(ResourceKey<? extends net.minecraft.core.Registry<T>> p_122982_, Lifecycle p_122983_, Supplier<T> p_122984_) {
        return internalRegister(p_122982_, new MappedRegistry<>(p_122982_, p_122983_), p_122984_, p_122983_);
    }
    public static <T> T register(Registry<? super T> p_122962_, ResourceLocation p_122963_, T p_122964_) {
        return register(p_122962_, p_122963_, p_122964_);
    }
    private static <T, R extends WritableRegistry<T>> R internalRegister(ResourceKey<? extends net.minecraft.core.Registry<T>> p_122986_, R p_122987_, Supplier<T> p_122988_, Lifecycle p_122989_) {
        ResourceLocation resourcelocation = p_122986_.location();
        LOADERS.put(resourcelocation, p_122988_);
        WritableRegistry<R> writableregistry = (WritableRegistry<R>)WRITABLE_REGISTRY;
        return (R)writableregistry.register((ResourceKey)p_122986_, p_122987_, p_122989_);
    }

}
