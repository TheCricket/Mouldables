package com.chazwade.mouldables;

import com.chazwade.mouldables.init.ModBlocks;
import com.chazwade.mouldables.init.ModItems;
import com.chazwade.mouldables.init.ModRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Mouldables
{
	//Creative Tab Registration//
	public static CreativeTabs tabMouldables = new CreativeTabs("Mouldables")
	{
		public Item getTabIconItem()
		{
			return ModItems.mouldingClay;
		}
	};
   
    
    @EventHandler
    //Pre-Init//
    public void preInit(FMLPreInitializationEvent event)
    {
		ModBlocks.init();
		ModItems.init();
		ModRecipes.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
