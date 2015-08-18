package com.chazwade.mouldables.init;

import com.chazwade.mouldables.items.ItemMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

    public static Item mouldingClay;

    public static void init() {
        setup();
        register();
    }

    private static void setup() {
        mouldingClay = new ItemMeta("mouldingClay", 16);
    }

    private static void register() {
        registerItem(mouldingClay);
    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
