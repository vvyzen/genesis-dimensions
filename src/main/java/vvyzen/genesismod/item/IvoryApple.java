package vvyzen.genesismod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import vvyzen.genesismod.init.CreativeGroupUnderworld;

public class IvoryApple extends Item {
    public IvoryApple(Properties tab) {
        super(new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE).rarity(Rarity.UNCOMMON).food(new FoodProperties.Builder()
                        .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 50, 0), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 800, 1), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 800, 1 ), 1.0F)
                        .alwaysEat()
                        .build()
                )

        );
    }
}