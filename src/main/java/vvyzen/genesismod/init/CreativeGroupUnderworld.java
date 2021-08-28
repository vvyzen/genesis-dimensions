package vvyzen.genesismod.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class CreativeGroupUnderworld
    extends CreativeModeTab{
    public static final CreativeModeTab INSTANCE = new CreativeModeTab("underworld") {
        public ItemStack makeIcon() {
            return new ItemStack((ItemLike) ItemRegistry.BLACK_DIAMOND.get());
        }

    };
    private CreativeGroupUnderworld(int index, String label){
        super(index, label);
    }
    public ItemStack makeIcon(){
        return new ItemStack((ItemLike) ItemRegistry.BLACK_DIAMOND.get());
    }
}