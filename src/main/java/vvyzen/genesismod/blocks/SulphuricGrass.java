package vvyzen.genesismod.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class SulphuricGrass extends RedundantGrassBlock {
    public SulphuricGrass() {
        super(Properties.of(Material.GRASS)
                .sound(SoundType.GRASS)
                .strength(0.6f)
                .randomTicks());

    }
}
