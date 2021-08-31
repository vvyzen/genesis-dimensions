/*package vvyzen.genesismod.blocks;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MaterialColor;
import vvyzen.genesismod.init.BlockRegistry;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class BlockColorRegister {
    private final java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Block>, BlockColor> blockColors = new java.util.HashMap<>();
    private final Map<Block, Set<Property<?>>> coloringStates = Maps.newHashMap();

    public static BlockColors createDefault() {
        BlockColors blockcolors = new BlockColors();
        blockcolors.register((p_92641_, p_92642_, p_92643_, p_92644_) -> {
            return p_92642_ != null && p_92643_ != null ? BiomeColors.getAverageGrassColor(p_92642_, p_92643_) : GrassColor.get(0.5D, 1.0D);
        }, BlockRegistry.SULPHURIC_GRASS.get());
        blockcolors.register((p_92636_, p_92637_, p_92638_, p_92639_) -> {
            return FoliageColor.getEvergreenColor();
        }, BlockRegistry.ASHWOOD_LEAVES.get());
        blockcolors.register((p_92631_, p_92632_, p_92633_, p_92634_) -> {
            return FoliageColor.getBirchColor();
        });
        net.minecraftforge.client.ForgeHooksClient.onBlockColorsInit(blockcolors);
        return blockcolors;
    }
    public int getColor(BlockState p_92583_, Level p_92584_, BlockPos p_92585_) {
        BlockColor blockcolor = this.blockColors.get(p_92583_.getBlock().delegate);
        if (blockcolor != null) {
            return blockcolor.getColor(p_92583_, (BlockAndTintGetter)null, (BlockPos)null, 0);
        } else {
            MaterialColor materialcolor = p_92583_.getMapColor(p_92584_, p_92585_);
            return materialcolor != null ? materialcolor.col : -1;
        }
    }

    public int getColor(BlockState p_92578_, @Nullable BlockAndTintGetter p_92579_, @Nullable BlockPos p_92580_, int p_92581_) {
        BlockColor blockcolor = this.blockColors.get(p_92578_.getBlock().delegate);
        return blockcolor == null ? -1 : blockcolor.getColor(p_92578_, p_92579_, p_92580_, p_92581_);
    }

    public void register(BlockColor p_92590_, Block... p_92591_) {
        for(Block block : p_92591_) {
            this.blockColors.put(block.delegate, p_92590_);
        }

    }

    private void addModdedColoringStates(Set<Property<?>> p_92593_, Block... p_92594_) {
        for(Block block : p_92594_) {
            this.coloringStates.put(block, p_92593_);
        }

    }

    private void addModdedColoringState(Property<?> p_92587_, Block... p_92588_) {
        this.addModdedColoringStates(ImmutableSet.of(p_92587_), p_92588_);
    }

    public Set<Property<?>> getColoringProperties(Block p_92576_) {
        return this.coloringStates.getOrDefault(p_92576_, ImmutableSet.of());
    }
}
*/