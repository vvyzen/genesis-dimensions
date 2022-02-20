package vvyzen.genesismod.world;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.function.Supplier;

public class GenesisChunkGenerator extends NoiseBasedChunkGenerator {
    public GenesisChunkGenerator(Registry<NormalNoise.NoiseParameters> noiseParameters, BiomeSource biomeSource, long seed, Supplier<NoiseGeneratorSettings> settings) {
        super(noiseParameters, biomeSource, seed, settings);
    }
}
