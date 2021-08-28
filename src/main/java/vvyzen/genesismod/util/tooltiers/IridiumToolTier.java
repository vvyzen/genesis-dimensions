package vvyzen.genesismod.util.tooltiers;

import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import vvyzen.genesismod.init.ItemRegistry;
import vvyzen.genesismod.init.TagRegistry;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class IridiumToolTier implements Tier {;

    @Override
    public int getUses() {
        return 650;
    }

    @Override
    public float getSpeed() {
        return 12.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 6.0f;
    }

    @Override
    public int getLevel() {
        return 5;
    }

    @Override
    public int getEnchantmentValue() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.IRIDIUM_INGOT.get());
    }

    @Override
    @Nonnull
    public Tag<Block> getTag() {
        return TagRegistry.NEEDS_IRIDIUM_TOOL;
    }
}
