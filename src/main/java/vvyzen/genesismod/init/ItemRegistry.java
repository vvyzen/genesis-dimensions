package vvyzen.genesismod.init;

import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vvyzen.genesismod.GenesisMod;
import vvyzen.genesismod.item.EmptySigil;
import vvyzen.genesismod.item.IvoryApple;
import vvyzen.genesismod.item.BlockItemBase;
import vvyzen.genesismod.util.tooltiers.*;

public class ItemRegistry {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GenesisMod.MODID);

    //MISC MATERIALS
    public static final RegistryObject<Item> IVORY = ITEMS.register("ivory", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> SOUL_TEAR = ITEMS.register("soul_tear", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> SUN_SHARD = ITEMS.register("sun_shard", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> SUN_STONE = ITEMS.register("sun_stone", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> ABYSSAL_FRAGMENT = ITEMS.register("abyssal_fragment", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> ARCANE_POWDER = ITEMS.register("arcane_powder", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    //METALS
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> PYRITE_INGOT = ITEMS.register("pyrite_ingot", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> BLACK_DIAMOND = ITEMS.register("black_diamond", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> ABYSSALITE = ITEMS.register("abyssalite", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    public static final RegistryObject<Item> RAW_PYRITE = ITEMS.register("raw_pyrite", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> RAW_IRIDIUM = ITEMS.register("raw_iridium", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    //ESSENCE
    public static final RegistryObject<Item> END_ESSENCE = ITEMS.register("end_essence", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> OVERWORLD_ESSENCE = ITEMS.register("overworld_essence", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> NETHER_ESSENCE = ITEMS.register("nether_essence", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> EDEN_ESSENCE = ITEMS.register("eden_essence", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> OTHERWORLD_ESSENCE = ITEMS.register("otherworld_essence", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> ABYSSAL_ESSENCE = ITEMS.register("abyssal_essence", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    //MISC
    public static final RegistryObject<IvoryApple> IVORY_APPLE = ITEMS.register("ivory_apple", () -> new IvoryApple(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).rarity(Rarity.UNCOMMON)));


    //TOOLS
    public static final RegistryObject<PickaxeItem> WORLD_SHATTERER = ITEMS.register("world_shatterer", () -> new PickaxeItem(new EssenceToolTier(), 1, -2.8F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant()));
    public static final RegistryObject<ShovelItem> WORLD_SHATTERER_SHOVEL = ITEMS.register("world_shatterer_shovel", () -> new ShovelItem(new EssenceToolTier(), 0, -2.8F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant()));

    public static final RegistryObject<SwordItem> PYRITE_SWORD = ITEMS.register("pyrite_sword",() -> new SwordItem(new PyriteToolTier(),3, -2.4F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<PickaxeItem> PYRITE_PICKAXE = ITEMS.register("pyrite_pickaxe", () -> new PickaxeItem(new PyriteToolTier(),1, -2.8F,new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<ShovelItem> PYRITE_SHOVEL = ITEMS.register("pyrite_shovel",() -> new ShovelItem(new PyriteToolTier(),1.5F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<AxeItem> PYRITE_AXE = ITEMS.register("pyrite_axe",() -> new AxeItem(new PyriteToolTier(),5.0F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<HoeItem> PYRITE_HOE = ITEMS.register("pyrite_hoe",() -> new HoeItem(new PyriteToolTier(),-4, 0.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    public static final RegistryObject<SwordItem> IRIDIUM_SWORD = ITEMS.register("iridium_sword",() -> new SwordItem(new IridiumToolTier(),3, -2.4F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<PickaxeItem> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe", () -> new PickaxeItem(new IridiumToolTier(),1, -2.8F,new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<ShovelItem> IRIDIUM_SHOVEL = ITEMS.register("iridium_shovel",() -> new ShovelItem(new IridiumToolTier(),1.5F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<AxeItem> IRIDIUM_AXE = ITEMS.register("iridium_axe",() -> new AxeItem(new IridiumToolTier(),5.0F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<HoeItem> IRIDIUM_HOE = ITEMS.register("iridium_hoe",() -> new HoeItem(new IridiumToolTier(),-4, 0.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    public static final RegistryObject<SwordItem> BLACK_DIAMOND_SWORD = ITEMS.register("black_diamond_sword",() -> new SwordItem(new BlackDiamondToolTier(),3, -2.4F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<PickaxeItem> BLACK_DIAMOND_PICKAXE = ITEMS.register("black_diamond_pickaxe", () -> new PickaxeItem(new BlackDiamondToolTier(),1, -2.8F,new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<ShovelItem> BLACK_DIAMOND_SHOVEL = ITEMS.register("black_diamond_shovel",() -> new ShovelItem(new BlackDiamondToolTier(),1.5F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<AxeItem> BLACK_DIAMOND_AXE = ITEMS.register("black_diamond_axe",() -> new AxeItem(new BlackDiamondToolTier(),5.0F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<HoeItem> BLACK_DIAMOND_HOE = ITEMS.register("black_diamond_hoe",() -> new HoeItem(new BlackDiamondToolTier(),-4, 0.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    public static final RegistryObject<SwordItem> ABYSSALITE_SWORD = ITEMS.register("abyssalite_sword",() -> new SwordItem(new AbyssaliteToolTier(),3, -2.4F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<PickaxeItem> ABYSSALITE_PICKAXE = ITEMS.register("abyssalite_pickaxe", () -> new PickaxeItem(new AbyssaliteToolTier(),1, -2.8F,new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<ShovelItem> ABYSSALITE_SHOVEL = ITEMS.register("abyssalite_shovel",() -> new ShovelItem(new AbyssaliteToolTier(),1.5F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<AxeItem> ABYSSALITE_AXE = ITEMS.register("abyssalite_axe",() -> new AxeItem(new AbyssaliteToolTier(),5.0F, -3.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<HoeItem> ABYSSALITE_HOE = ITEMS.register("abyssalite_hoe",() -> new HoeItem(new AbyssaliteToolTier(),-4, 0.0F, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE)));

    //SIGILS

    public static final RegistryObject<EmptySigil> EMPTY_SIGIL = ITEMS.register("empty_sigil", () -> new EmptySigil(new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(CreativeGroupUnderworld.INSTANCE)));
    public static final RegistryObject<Item> PROTECTION_SIGIL = ITEMS.register("protection_sigil", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> SPEED_SIGIL = ITEMS.register("speed_sigil", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> LEVITATION_SIGIL = ITEMS.register("levitation_sigil", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> INVISIBILITY_SIGIL = ITEMS.register("invisibility_sigil", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> EMPTY_SIGIL_WEAK = ITEMS.register("empty_sigil_weak", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> PROTECTION_SIGIL_WEAK = ITEMS.register("protection_sigil_weak", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> SPEED_SIGIL_WEAK = ITEMS.register("speed_sigil_weak", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> AUXILIARY_SIGIL_EMPTY = ITEMS.register("auxiliary_sigil_empty", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> AUXILIARY_SIGIL_HASTE = ITEMS.register("auxiliary_sigil_haste", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> AUXILIARY_SIGIL_STRENGTH = ITEMS.register("auxiliary_sigil_strength", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<Item> AUXILIARY_SIGIL_RESISTANCE = ITEMS.register("auxiliary_sigil_resistance", () -> new Item(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).fireResistant().rarity(Rarity.RARE).stacksTo(1)));


    //BLOCKS
    public static final RegistryObject<BlockItem> MOONSTONE = ITEMS.register("moonstone", () -> new BlockItemBase(BlockRegistry.MOONSTONE.get()));
    public static final RegistryObject<BlockItem> SCORIA = ITEMS.register("scoria", () -> new BlockItemBase(BlockRegistry.SCORIA.get()));
    public static final RegistryObject<BlockItem> SLATE = ITEMS.register("slate", () -> new BlockItemBase(BlockRegistry.SLATE.get()));
    public static final RegistryObject<BlockItem> BRIMSTONE = ITEMS.register("brimstone", () -> new BlockItemBase(BlockRegistry.BRIMSTONE.get()));
    public static final RegistryObject<BlockItem> CORE_BEDROCK = ITEMS.register("core_bedrock", () -> new BlockItemBase(BlockRegistry.CORE_BEDROCK.get()));
    public static final RegistryObject<BlockItem> SULPHURIC_SOIL = ITEMS.register("sulphuric_soil", () -> new BlockItemBase(BlockRegistry.SULPHURIC_SOIL.get()));
    public static final RegistryObject<BlockItem> SULPHURIC_GRASS = ITEMS.register("sulphuric_grass", () -> new BlockItemBase(BlockRegistry.SULPHURIC_GRASS.get()));
    public static final RegistryObject<BlockItem> ASH = ITEMS.register("ash", () -> new BlockItemBase(BlockRegistry.ASH.get()));
    public static final RegistryObject<BlockItem> SOOT = ITEMS.register("soot", () -> new BlockItemBase(BlockRegistry.SOOT.get()));
    public static final RegistryObject<BlockItem> RED_MOSS = ITEMS.register("red_moss", () -> new BlockItemBase(BlockRegistry.RED_MOSS.get()));
    //public static final RegistryObject<BlockItem> MOSSY_SKYSTONE = ITEMS.register("mossy_skystone", () -> new BlockItemBase(BlockRegistry.MOSSY_SKYSTONE.get()));
    public static final RegistryObject<BlockItem> SKYSTONE = ITEMS.register("skystone", () -> new BlockItemBase(BlockRegistry.SKYSTONE.get()));
    public static final RegistryObject<BlockItem> MOSSY_MOONSTONE = ITEMS.register("mossy_moonstone", () -> new BlockItemBase(BlockRegistry.MOSSY_MOONSTONE.get()));
    public static final RegistryObject<BlockItem> ASHWOOD_LOG = ITEMS.register("ashwood_log", () -> new BlockItemBase(BlockRegistry.ASHWOOD_LOG.get()));
    public static final RegistryObject<BlockItem> ASHWOOD_LEAVES = ITEMS.register("ashwood_leaves", () -> new BlockItemBase(BlockRegistry.ASHWOOD_LEAVES.get()));
//    public static final RegistryObject<BlockItem> ASHWOOD_SAPLING = ITEMS.register("ashwood_sapling", () -> new BlockItemBase(BlockRegistry.ASHWOOD_SAPLING.get()));

    public static final RegistryObject<BlockItem> PYRITE_ORE = ITEMS.register("pyrite_ore", () -> new BlockItemBase(BlockRegistry.PYRITE_ORE.get()));
    public static final RegistryObject<BlockItem> IRIDIUM_ORE = ITEMS.register("iridium_ore", () -> new BlockItemBase(BlockRegistry.IRIDIUM_ORE.get()));
    public static final RegistryObject<BlockItem> BLACK_DIAMOND_ORE = ITEMS.register("black_diamond_ore", () -> new BlockItemBase(BlockRegistry.BLACK_DIAMOND_ORE.get()));
    public static final RegistryObject<BlockItem> ABYSSALITE_ORE = ITEMS.register("abyssalite_ore", () -> new BlockItemBase(BlockRegistry.ABYSSALITE_ORE.get()));



}