package com.chazwade.mouldables.items;

import com.chazwade.mouldables.Mouldables;
import com.chazwade.mouldables.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemMeta extends Item {

    private IIcon[] textures;
    private String unlocalizedName;
    private int ammountOfItems;

    public ItemMeta(String unlocalizedName, int ammountOfItems) {
        super();
        setHasSubtypes(true);
        setUnlocalizedName(unlocalizedName);
        setCreativeTab(Mouldables.tabMouldables);
        textures = new IIcon[ammountOfItems];
        this.unlocalizedName = unlocalizedName;
        this.ammountOfItems = ammountOfItems;
    }

    @Override
    public void registerIcons(IIconRegister icon) {
        for(int c = 0; c < ammountOfItems; c++) {
            this.textures[c] = icon.registerIcon(Reference.MODID + ":" + unlocalizedName + "." + c);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        if(meta > ammountOfItems)
            meta = 0; //Safety null check
        return this.textures[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for(int c = 0; c < ammountOfItems; c++) {
            list.add(new ItemStack(item, 1, c));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "." + stack.getItemDamage();
    }
}
