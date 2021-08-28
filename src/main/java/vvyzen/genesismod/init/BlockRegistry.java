package vvyzen.genesismod.init;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vvyzen.genesismod.GenesisMod;

public class BlockRegistry {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GenesisMod.MODID);

    public static final RegistryObject<LiquidBlock> BLOOD = BLOCKS.register("blood", () -> new LiquidBlock(FluidRegistry.BLOOD_SOURCE, BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_RED).noCollission().strength(100.0F).noDrops()));

    public static final RegistryObject<Block> MOONSTONE = BLOCKS.register("moonstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORIA = BLOCKS.register("scoria", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SLATE = BLOCKS.register("slate", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BRIMSTONE = BLOCKS.register("brimstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(50.0F, 1200.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORE_BEDROCK = BLOCKS.register("core_bedrock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(100000.0F, 3600000.0F).noDrops()));
    public static final RegistryObject<Block> SULPHURIC_SOIL = BLOCKS.register("sulphuric_soil", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.5f)));
    public static final RegistryObject<Block> SULPHURIC_GRASS = BLOCKS.register("sulphuric_grass", () -> new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS).randomTicks().sound(SoundType.GRASS).strength(0.6f)));
    public static final RegistryObject<SandBlock> ASH = BLOCKS.register("ash", () -> new SandBlock(11903907, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_LIGHT_GRAY).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<SandBlock> SOOT = BLOCKS.register("soot", () -> new SandBlock(1907740, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> RED_MOSS = BLOCKS.register("red_moss", () -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_RED).sound(SoundType.GRASS).strength(0.5f)));
    public static final RegistryObject<Block> MOSSY_SKYSTONE = BLOCKS.register("mossy_skystone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SKYSTONE = BLOCKS.register("skystone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_MOONSTONE = BLOCKS.register("mossy_moonstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<RotatedPillarBlock> ASHWOOD_LOG = BLOCKS.register("ashwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistryObject<LeavesBlock> ASHWOOD_LEAVES = BLOCKS.register("ashwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    //public static final RegistryObject<SaplingBlock> ASHWOOD_SAPLING = BLOCKS.register("ashwood_sapling", () -> new SaplingBlock(new AshTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<OreBlock> PYRITE_ORE = BLOCKS.register("pyrite_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.0F, 3.0F)));
    public static final RegistryObject<OreBlock> IRIDIUM_ORE = BLOCKS.register("iridium_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.0F, 3.0F)));
    public static final RegistryObject<OreBlock> BLACK_DIAMOND_ORE = BLOCKS.register("black_diamond_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.0F, 3.0F), UniformInt.of(3, 7)));
    public static final RegistryObject<OreBlock> ABYSSALITE_ORE = BLOCKS.register("abyssalite_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(6.0F, 3.0F), UniformInt.of(3, 7)));

}
