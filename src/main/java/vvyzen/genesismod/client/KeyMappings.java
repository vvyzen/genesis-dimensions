package vvyzen.genesismod.client;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public class KeyMappings {

    public static KeyMapping purifyMenu;
    public static KeyMapping mainAbility1;
    public static KeyMapping mainAbility2;
    public static KeyMapping sideAbility1;
    public static KeyMapping sideAbility2;

    public static void mapKeys(){
        purifyMenu = registerKey(new KeyMapping("key.ssvrfi.open.purify", 61, "key.categories.misc"));

        mainAbility1 = registerKey(new KeyMapping("key.ssvrfi.ability.main", 90, "key.categories.misc"));
        mainAbility2 = registerKey(new KeyMapping("key.ssvrfi.ability.mainalt", -1, "key.categories.misc"));

        sideAbility1 = registerKey(new KeyMapping("key.ssvrfi.ability.side", 88, "key.categories.misc"));
        sideAbility2 = registerKey(new KeyMapping("key.ssvrfi.ability.sidealt", -1, "key.categories.misc"));
    }

    private static KeyMapping registerKey(KeyMapping key){
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
