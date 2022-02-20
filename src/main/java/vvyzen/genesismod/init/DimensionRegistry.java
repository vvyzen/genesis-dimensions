package vvyzen.genesismod.init;
import com.legacy.structure_gel.api.dimension.DimensionAccessHelper;
import com.legacy.structure_gel.api.dimension.DimensionTypeBuilder;
import com.legacy.structure_gel.api.registry.registrar.DimensionRegistrar;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.CubicSpline;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import vvyzen.genesismod.world.data.SurfaceRuleData;

import java.util.function.Supplier;

public class DimensionRegistry {

    private static DimensionRegistrar OTHERWORLD;
    private static DimensionRegistrar UNDERWORLD;
    private static DimensionRegistrar EDEN;


    public static BiomeSource biomesource = new FixedBiomeSource((Supplier<Biome>) Biomes.PLAINS);

    //why god

    private static final StructureSettings OWO_STRUCTURESETTINGS = new StructureSettings(false);

    public static void init() {



        NoiseSettings OWO_NOISE = NoiseSettings.create(-64, 384, new NoiseSamplingSettings(0.9999999814507745,0.9999999814507745,80,150),new NoiseSlider(-8,3,0),new NoiseSlider(10,3,0),2,1,false,false,false,new TerrainShaper(CubicSpline.constant(-0.16875F),CubicSpline.constant(1),CubicSpline.constant(0.2F)));

        NoiseGeneratorSettings otherworldSettings = DimensionAccessHelper.newDimensionSettings(OWO_STRUCTURESETTINGS, OWO_NOISE, BlockRegistry.MOONSTONE.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), SurfaceRuleData.OWO_SURFACE(),55,false);



        DimensionType owoDimensionType = DimensionTypeBuilder.of().minY(-64).bedWorks(true).height(384).natural(true).effects(new ResourceLocation("ssvrfi","otherworld")).build();
        //OTHERWORLD = new DimensionRegistrar(new ResourceLocation("ssvrfi","otherworld"),owoDimensionType, otherworldSettings,new NoiseBasedChunkGenerator(RegistryAccess.builtin().registryOrThrow(G_NOISE_REGISTRY),biomesource, 16364361L, otherworldSettings));
    }

}
