package vvyzen.genesismod.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vvyzen.genesismod.GenesisMod;

public class FeatureRegistry {
    /*public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, GenesisMod.MODID);

    public static final RegistryObject<Feature<TreeConfiguration>> ASHWOOD_TREE = FEATURES.register("ashwood_tree",
            () -> new TreeFeature((Codec<TreeConfiguration>) new TreeConfiguration.TreeConfigurationBuilder
                    (new SimpleStateProvider(BlockRegistry.ASHWOOD_LOG.get().defaultBlockState()),
                            new StraightTrunkPlacer(6, 3, 0),
                            new SimpleStateProvider(BlockRegistry.ASHWOOD_LEAVES.get().defaultBlockState()),
                            new SimpleStateProvider(BlockRegistry.ASHWOOD_SAPLING.get().defaultBlockState()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
*/
}
