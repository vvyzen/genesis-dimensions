package vvyzen.genesismod.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
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
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vvyzen.genesismod.GenesisMod;

public class FeatureRegistry {
    public static final ConfiguredFeature<TreeConfiguration, ?> ASHWOOD;


    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String p_127056_, ConfiguredFeature<FC, ?> p_127057_) {
        return (ConfiguredFeature)Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, p_127056_, p_127057_);
    }

    static{

        ASHWOOD = register("ashwood", Feature.TREE.configured((
                new TreeConfiguration.TreeConfigurationBuilder(
                        new SimpleStateProvider(BlockRegistry.ASHWOOD_LOG.get().defaultBlockState()),
                        new StraightTrunkPlacer(5, 4, 0),
                        new SimpleStateProvider(BlockRegistry.ASHWOOD_LEAVES.get().defaultBlockState()),
                        new SimpleStateProvider(BlockRegistry.ASHWOOD_SAPLING.get().defaultBlockState()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));


    }







    /*public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, GenesisMod.MODID);

    public static final RegistryObject<Feature<TreeConfiguration>> ASHWOOD_TREE = FEATURES.register("oak", () ->
            new TreeFeature((Codec<TreeConfiguration>) (
            new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(BlockRegistry.ASHWOOD_LOG.get().defaultBlockState()),
                    new StraightTrunkPlacer(4, 2, 0),
                    new SimpleStateProvider(BlockRegistry.ASHWOOD_LEAVES.get().defaultBlockState()),
                    new SimpleStateProvider(BlockRegistry.ASHWOOD_SAPLING.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));


    public static final class ConfiguredFeatures{
        //public static final ConfiguredFeature ASHWOOD_TREE = ((Feature)FeatureRegistry.ASHWOOD_TREE.get()).configured(TreeConfiguration.TreeConfigurationBuilder);
    }


    /*

    public static final RegistryObject<Feature<TreeConfiguration>> ASHWOOD_TREE = FEATURES.register("ashwood_tree", new TreeConfiguration.TreeConfigurationBuilder
            (new SimpleStateProvider(BlockRegistry.ASHWOOD_LOG.get().defaultBlockState()),
                    new StraightTrunkPlacer(6,3,0),
                    new SimpleStateProvider(BlockRegistry.ASHWOOD_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2),ConstantInt.of(0),3),
                    new TwoLayersFeatureSize(1,0,1)).ignoreVines().build());


    //public static final RegistryObject<Feature<TreeConfiguration>> ASHWOOD_TREE = FEATURES.register("ashwood_tree", new TreeConfiguration()
                    ((Codec<TreeConfiguration>) new TreeConfiguration.TreeConfigurationBuilder
                    (new SimpleStateProvider(BlockRegistry.ASHWOOD_LOG.get().defaultBlockState()),
                            new StraightTrunkPlacer(6, 3, 0),
                            new SimpleStateProvider(BlockRegistry.ASHWOOD_LEAVES.get().defaultBlockState()),
                            new SimpleStateProvider(BlockRegistry.ASHWOOD_SAPLING.get().defaultBlockState()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));*/

}
