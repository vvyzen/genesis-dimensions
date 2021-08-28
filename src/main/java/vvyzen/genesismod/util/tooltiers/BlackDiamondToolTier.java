package vvyzen.genesismod.util.tooltiers;

import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import vvyzen.genesismod.init.ItemRegistry;
import vvyzen.genesismod.init.TagRegistry;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class BlackDiamondToolTier implements Tier {;

    @Override
    public int getUses() {
        return 1740;
    }

    @Override
    public float getSpeed() {
        return 14.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 7.0f;
    }

    @Override
    public int getLevel() {
        return 6;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.BLACK_DIAMOND.get());
    }

    @Override
    @Nonnull
    public Tag<Block> getTag(){
        return TagRegistry.NEEDS_CARBON_TOOL;
    }
}
