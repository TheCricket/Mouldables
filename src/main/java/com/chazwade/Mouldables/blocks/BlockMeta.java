package com.chazwade.mouldables.blocks;

import com.chazwade.mouldables.Mouldables;
import com.chazwade.mouldables.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * This will be used to make any block that will use metadata
 */
public class BlockMeta extends Block {

    //The ammount of blocks your series will hold
    private int ammountOfBlocks = 16;
    //The base for the texture
    private String texture;
    //The actual grouping of textures
    private IIcon[] textures;

    /**
     * You will need to provide it with the material, the ammount of blocks, and the base texture file
     * @param material
     * @param ammountOfBlocks
     * @param texture
     */
    public BlockMeta(Material material, int ammountOfBlocks, String texture) {
        super(material);
        setCreativeTab(Mouldables.tabMouldables);
        this.ammountOfBlocks = ammountOfBlocks;
        this.texture = texture;
        this.textures = new IIcon[ammountOfBlocks];
    }

    /**
     * Register each texture as "base.(metadata)"
     * @param icon
     */
    @Override
    public void registerBlockIcons(IIconRegister icon) {
        for(int c = 0; c < ammountOfBlocks; c++) {
            //For example the texture "oak_planks" is now "oak_planks.0 or .1"
            textures[c] = icon.registerIcon(Reference.MODID + ":" + texture + "." + c);
        }
    }

    /**
     * Get the actual texture for each block
     * @param side
     * @param meta
     * @return
     */
    @Override
    public IIcon getIcon(int side, int meta) {
        if(meta > ammountOfBlocks) {
            meta = 0;
        }

        return textures[meta];
    }

    /**
     * We want to drop the block that you mined so this makes that happen
     * @param meta
     * @return
     */
    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    /**
     * Add all of the blocks that you need to the creative tab so it isn't just one
     * @param item
     * @param tab
     * @param list
     */
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for(int c = 0; c < ammountOfBlocks; c++) {
            list.add(new ItemStack(item, 1, c));
        }
    }
}
