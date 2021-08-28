package vvyzen.genesismod.util.tooltiers;

import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import vvyzen.genesismod.init.ItemRegistry;
import vvyzen.genesismod.init.TagRegistry;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class AbyssaliteToolTier implements Tier {;

    @Override
    public int getUses() {
        return 2271;
    }

    @Override
    public float getSpeed() {
        return 16.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 8.0f;
    }

    @Override
    public int getLevel() {
        return 7;
    }

    @Override
    public int getEnchantmentValue() {
        return 8;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.ABYSSALITE.get());
    }
    @Nonnull
    public Tag<Block> getTag(){
        return TagRegistry.NEEDS_ABYSSALITE_TOOL;
    }
}
