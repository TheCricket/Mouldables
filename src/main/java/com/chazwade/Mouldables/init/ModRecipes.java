package com.chazwade.mouldables.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {

    public static void init() {
        initRecipes();
        initSmelting();
    }

    private static void initRecipes() {
        for(int c = 0; c < 16; c++) {
            GameRegistry.addRecipe(new ItemStack(ModItems.mouldingClay, 8, c), new Object[]{
                    "AAA",
                    "ABA",
                    "AAA",
                    'B', new ItemStack(Items.dye, 1, c),
                    'A', Items.clay_ball
            });
        }

    }

    private static void initSmelting() {
        for(int c = 0; c < 16; c++) {
            GameRegistry.addSmelting(new ItemStack(ModItems.mouldingClay, 1, c), new ItemStack(ModBlocks.construction, 1, c), 0.1F);
        }
    }
}
