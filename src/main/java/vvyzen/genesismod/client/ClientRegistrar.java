package vvyzen.genesismod.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "ssvrfi", value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistrar {
    public static void setup(FMLCommonSetupEvent event){

    //put(new ResourceLocation("ssvrfi", "otherworld"), new OtherworldRenderInfo());
    }
}
