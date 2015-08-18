package com.chazwade.mouldables.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlockWithMetadata {

    public ItemBlockMeta(Block block) {
        super(block, block);
    }

    /**
     * We want each block to have their own unique
     * @param stack
     * @return
     */
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "." + stack.getItemDamage();
    }
}
