package vvyzen.genesismod.client;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vvyzen.genesismod.client.renderer.OtherworldRenderInfo;
import vvyzen.genesismod.init.BlockRegistry;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "ssvrfi", value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistrar {
    private static final Logger LOGGER = LogManager.getLogger();


    public static void blockRenderLayer(){

    }


    private void setup(final FMLCommonSetupEvent event)
    {
        blockRenderLayer();
        LOGGER.info("motherfuck !!!!!!!!!!!!1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    }
}
