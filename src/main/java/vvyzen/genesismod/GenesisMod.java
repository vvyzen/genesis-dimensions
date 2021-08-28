package vvyzen.genesismod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vvyzen.genesismod.init.BlockRegistry;
import vvyzen.genesismod.init.FluidRegistry;
import vvyzen.genesismod.init.ItemRegistry;
import vvyzen.genesismod.util.tooltiers.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ssvrfi")
public class GenesisMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "ssvrfi";

    public GenesisMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FluidRegistry.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());

        TierSorter.PYRITE_TIER = TierSortingRegistry.registerTier(new PyriteToolTier(), new ResourceLocation("ssvrfi", "pyrite"), TierSorter.pyrite_after, TierSorter.pyrite_before);
        TierSorter.IRIDIUM_TIER = TierSortingRegistry.registerTier(new IridiumToolTier(), new ResourceLocation("ssvrfi", "iridium"), TierSorter.iridium_after, TierSorter.iridium_before);
        TierSorter.CARBON_TIER = TierSortingRegistry.registerTier(new BlackDiamondToolTier(), new ResourceLocation("ssvrfi", "carbon"), TierSorter.carbon_after, TierSorter.carbon_before);
        TierSorter.ABYSSALITE_TIER = TierSortingRegistry.registerTier(new AbyssaliteToolTier(), new ResourceLocation("ssvrfi", "abyssalite"), TierSorter.abyssalite_after, TierSorter.abyssalite_before);

        //TierSortingRegistry.isCorrectTierForDrops(Tiers.STONE, BlockRegistry.ABYSSALITE_ORE.get().defaultBlockState());
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        LOGGER.info(TierSortingRegistry.getSortedTiers());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("ssvrfi", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");

        }
    }
}
