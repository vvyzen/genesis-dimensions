package vvyzen.genesismod.util.tooltiers;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class EssenceToolTier implements Tier {;


    @Override
    public int getUses() {
        return 0;
    }

    @Override
    public float getSpeed() {
        return 50000.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 20;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
