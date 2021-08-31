package vvyzen.genesismod.world.level.grower;

import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import vvyzen.genesismod.init.FeatureRegistry;

import javax.annotation.Nullable;
import java.util.Random;

public class AshTreeGrower extends AbstractTreeGrower {
    public AshTreeGrower() {
    }

    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random p_60038_, boolean p_60039_) {
            return p_60039_ ? FeatureRegistry.ASHWOOD : FeatureRegistry.ASHWOOD;

        }
    }
