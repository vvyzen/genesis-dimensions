package vvyzen.genesismod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
    }
}