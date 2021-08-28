package vvyzen.genesismod.util.tooltiers;

import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import vvyzen.genesismod.init.ItemRegistry;
import vvyzen.genesismod.init.TagRegistry;

import javax.annotation.Nonnull;

public class PyriteToolTier implements Tier {;

    @Override
    public int getUses() {
        return 320;
    }

    @Override
    public float getSpeed() {
        return 10.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 5.0f;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.PYRITE_INGOT.get());
    }

    @Override
    @Nonnull
    public Tag<Block> getTag(){
        return TagRegistry.NEEDS_PYRITE_TOOL;
    }
}
