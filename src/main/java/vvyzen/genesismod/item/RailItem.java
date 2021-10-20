package vvyzen.genesismod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RailItem extends Item {
    public RailItem(Item.Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level level, ItemStack item, LivingEntity entity) {
        Arrow arrow = new Arrow(level, entity);
        arrow.setEffectsFromItem(item);
        return arrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == RailItem.class;
    }
}
