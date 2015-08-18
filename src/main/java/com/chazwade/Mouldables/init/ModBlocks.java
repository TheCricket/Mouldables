package com.chazwade.mouldables.init;

import com.chazwade.mouldables.blocks.BlockMeta;
import com.chazwade.mouldables.items.itemblocks.ItemBlockMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static Block construction;

    public static void init() {
        setup();
        register();
    }

    private static void setup() {
        construction = new BlockMeta(Material.rock, 16, "constructionBlock");
    }

    private static void register() {
        registerMetadataBlock(construction);
    }

    private static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }

    private static void registerMetadataBlock(Block block) {
        GameRegistry.registerBlock(block, ItemBlockMeta.class, block.getUnlocalizedName());
    }
}
