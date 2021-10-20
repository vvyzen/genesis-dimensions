package vvyzen.genesismod.events;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vvyzen.genesismod.GenesisMod;
import vvyzen.genesismod.init.ItemRegistry;
import vvyzen.genesismod.init.TagRegistry;

@Mod.EventBusSubscriber(modid = GenesisMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEventHandler {


    /*@SubscribeEvent
    public static void angelabilities(LivingEvent.LivingUpdateEvent angelevent){
        LivingEntity player = angelevent.getEntityLiving();
        if(player instanceof Player){

        }
    }*/








    @SubscribeEvent
    public static void shattererswap(PlayerInteractEvent.RightClickItem shatteruse) {
        LivingEntity player = shatteruse.getPlayer();
        if (player.getMainHandItem().getItem() == ItemRegistry.WORLD_SHATTERER.get() || player.getMainHandItem().getItem() == ItemRegistry.WORLD_SHATTERER_SHOVEL.get()) {
            if (player.getMainHandItem().getItem() == ItemRegistry.WORLD_SHATTERER.get()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, ItemRegistry.WORLD_SHATTERER_SHOVEL.get().getDefaultInstance());
            }
            else{
                player.setItemInHand(InteractionHand.MAIN_HAND, ItemRegistry.WORLD_SHATTERER.get().getDefaultInstance());

            }
        }
    }
    @SubscribeEvent
    public static void sigileffect(LivingEvent.LivingUpdateEvent sigiluse){
        LivingEntity player = sigiluse.getEntityLiving();
        if(player instanceof Player){
            if(TagRegistry.ACTIVESIGIL.contains(player.getMainHandItem().getItem())){
                if(player.getMainHandItem().getItem() == ItemRegistry.SPEED_SIGIL.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,2,4));
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP,2,2));
                }
                else if(player.getMainHandItem().getItem() == ItemRegistry.PROTECTION_SIGIL.get()){
                    if(player.hasEffect(MobEffects.REGENERATION) == false){
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,50,0));
                    }
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2,1));
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,2,0));
                    player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,2,0));
                }
                else if(player.getMainHandItem().getItem() == ItemRegistry.LEVITATION_SIGIL.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.LEVITATION,20,2));
                }
                else if(player.getMainHandItem().getItem() == ItemRegistry.SPEED_SIGIL_WEAK.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,2,1));
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP,2,0));
                }
                else if(player.getMainHandItem().getItem() == ItemRegistry.PROTECTION_SIGIL_WEAK.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2,1));
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,2,0));
                    player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,2,0));
                }
                else if(player.getMainHandItem().getItem() == ItemRegistry.INVISIBILITY_SIGIL.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 400, 0));
                }
                else{
                    System.out.println("WARNING: Sigil event run without valid sigil held! PLEASE REPORT THIS TO THE MOD AUTHOR IMMEDIATELY");
                }
            }
            if(TagRegistry.AUXILIARYSIGIL.contains(player.getOffhandItem().getItem())){
                if(player.getOffhandItem().getItem() == ItemRegistry.AUXILIARY_SIGIL_HASTE.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,2,0));
                }
                else if (player.getOffhandItem().getItem() == ItemRegistry.AUXILIARY_SIGIL_RESISTANCE.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2,0));
                }
                else if (player.getOffhandItem().getItem() == ItemRegistry.AUXILIARY_SIGIL_STRENGTH.get()){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,2,0));
                }
                else{
                    System.out.println("WARNING: Auxiliary Sigil event run without valid sigil held! PLEASE REPORT THIS TO THE MOD AUTHOR IMMEDIATELY");
                }
            }
        }
    }





}