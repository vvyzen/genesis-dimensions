package vvyzen.genesismod.util.tooltiers;

import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraft.resources.ResourceLocation;
import vvyzen.genesismod.util.tooltiers.*;

import java.util.Arrays;
import java.util.List;

public class TierSorter {
    //fuck you mojang were integer tiers too easy for you piece of shit
    static ResourceLocation diamond = new ResourceLocation("diamond");
    static ResourceLocation netherite = new ResourceLocation("netherite");
    static ResourceLocation pyrite = new ResourceLocation("ssvrfi","pyrite");
    static ResourceLocation iridium = new ResourceLocation("ssvrfi","iridium");
    static ResourceLocation carbon = new ResourceLocation("ssvrfi","carbon");
    static ResourceLocation abyssalite = new ResourceLocation("ssvrfi","abyssalite");

    public static List<Object> pyrite_after = Arrays.asList(diamond, netherite);
    public static List<Object> iridium_after = Arrays.asList(pyrite);
    public static List<Object> carbon_after = Arrays.asList(iridium);
    public static List<Object> abyssalite_after = Arrays.asList(carbon);

    public static List<Object> pyrite_before = Arrays.asList(iridium);
    public static List<Object> iridium_before = Arrays.asList(carbon);
    public static List<Object> carbon_before = Arrays.asList(abyssalite);
    public static List<Object> abyssalite_before = Arrays.asList();

    public static Tier PYRITE_TIER;
    public static Tier IRIDIUM_TIER;
    public static Tier CARBON_TIER;
    public static Tier ABYSSALITE_TIER;

    static {

    }
}
