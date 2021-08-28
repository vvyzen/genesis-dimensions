package vvyzen.genesismod.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags;

public class TagRegistry {
    public static final Tags.IOptionalNamedTag<Item> ACTIVESIGIL = tag("activesigil");
    public static final Tags.IOptionalNamedTag<Item> AUXILIARYSIGIL = tag("auxiliarysigil");

    public static final Tag.Named<Block> NEEDS_PYRITE_TOOL = (Tag.Named<Block>)BlockTags.createOptional(new ResourceLocation("ssvrfi:needs_pyrite_tool"));
    public static final Tag.Named<Block> NEEDS_IRIDIUM_TOOL = (Tag.Named<Block>)BlockTags.createOptional(new ResourceLocation("ssvrfi:needs_iridium_tool"));
    public static final Tag.Named<Block> NEEDS_CARBON_TOOL = (Tag.Named<Block>)BlockTags.createOptional(new ResourceLocation("ssvrfi:needs_carbon_tool"));
    public static final Tag.Named<Block> NEEDS_ABYSSALITE_TOOL = (Tag.Named<Block>)BlockTags.createOptional(new ResourceLocation("ssvrfi:needs_abyssalite_tool"));

    //public static final Tags.IOptionalNamedTag<Block> NEEDS_PYRITE_TOOL = tagBlock("needs_pyrite_tool");
    //public static final Tags.IOptionalNamedTag<Block> NEEDS_IRIDIUM_TOOL = tagBlock("needs_iridium_tool");
    //public static final Tags.IOptionalNamedTag<Block> NEEDS_CARBON_TOOL = tagBlock("needs_carbon_tool");
    //public static final Tags.IOptionalNamedTag<Block> NEEDS_ABYSSALITE_TOOL = tagBlock("needs_abyssalite_tool");

    private static Tags.IOptionalNamedTag<Item> tag(String name)
    {
        return ItemTags.createOptional(new ResourceLocation("ssvrfi", name));
    }
    private static Tags.IOptionalNamedTag<Block> tagBlock(String name)
    {
        return BlockTags.createOptional(new ResourceLocation("ssvrfi", name));
    }
    private static Tags.IOptionalNamedTag<Fluid> tagFluid(String name)
    {
        return FluidTags.createOptional(new ResourceLocation("ssvrfi", name));
    }
}
