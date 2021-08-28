package vvyzen.genesismod.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import vvyzen.genesismod.init.CreativeGroupUnderworld;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().tab(CreativeGroupUnderworld.INSTANCE));
    }
}