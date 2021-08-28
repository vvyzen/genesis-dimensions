package vvyzen.genesismod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import vvyzen.genesismod.init.CreativeGroupUnderworld;

public class EmptySigil extends Item {
    public EmptySigil(Properties properties) {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).fireResistant().tab(CreativeGroupUnderworld.INSTANCE));
    }
}