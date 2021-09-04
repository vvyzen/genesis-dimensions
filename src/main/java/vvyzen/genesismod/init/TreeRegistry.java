package vvyzen.genesismod.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import vvyzen.genesismod.world.level.feature.trunkplacers.EternalTrunkPlacer;

import static net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType.register;

public class TreeRegistry<P extends TrunkPlacer> {
    public static final TrunkPlacerType<EternalTrunkPlacer> ETERNAL_TRUNK_PLACER = registerTree(new ResourceLocation("ssvrfi", "eternal_trunk_placer"), EternalTrunkPlacer.CODEC);

    private final Codec<P> codec;
    public TreeRegistry(Codec<P> p_70324_) {
        this.codec = p_70324_;
    }

    public Codec<P> codec() {
        return this.codec;
    }

    public static <P extends TrunkPlacer> TrunkPlacerType<P> registerTree(ResourceLocation p_70327_, Codec<P> p_70328_) {
        return GRegistry.register(GRegistry.TRUNK_PLACER_TYPES, p_70327_, new TrunkPlacerType<>(p_70328_));
    }


}
