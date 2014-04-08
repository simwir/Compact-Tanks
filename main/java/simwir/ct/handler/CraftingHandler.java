package simwir.ct.handler;

import simwir.ct.CompactTanks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

	/**
	 * Registers the crafting recipes
	 */
	public static void craftingHandler() {
		
		//Block Recipes
		//Recipe for WaterSource
		GameRegistry.addRecipe(new ItemStack(CompactTanks.waterSource,1),
			new Object[]{"III","WBW","III",'I',
			Item.itemRegistry.getObject("iron_ingot"),
			'W',Item.itemRegistry.getObject("water_bucket"),
			'B', Item.itemRegistry.getObject("bucket")});
		//Recipe for small tank
		GameRegistry.addRecipe(new ItemStack(CompactTanks.smallTank,1),
			new Object[]{"IDI","IBI","GEG",
			'I', Item.itemRegistry.getObject("iron_ingot"),
			'D', Item.itemRegistry.getObject("diamond"),
			'B', Item.itemRegistry.getObject("bucket"),
			'G', Item.itemRegistry.getObject("gold_ingot"),
			'E', Item.itemRegistry.getObject("ender_pearl")});
		//Recipe for medium tank
		GameRegistry.addRecipe(new ItemStack(CompactTanks.medTank,1),
			new Object[]{"GDG","GEG","DPD",
			'G', Item.itemRegistry.getObject("gold_ingot"),
			'D', Item.itemRegistry.getObject("diamond"),
			'P', Item.itemRegistry.getObject("ender_pearl"),
			'E', CompactTanks.enderBucket});
		//Recipe for large tank
		GameRegistry.addRecipe(new ItemStack(CompactTanks.largeTank),
			new Object[]{"DQD","EEE","PPP",
			'D', Item.itemRegistry.getObject("diamond"),
			'E', CompactTanks.enderBucket,
			'P', Item.itemRegistry.getObject("ender_pearl"),
			'Q', Item.itemRegistry.getObject("emerald")});
		
		//Item Recipes
		//Recipe for Meter
		GameRegistry.addRecipe(new ItemStack(CompactTanks.meter,1), 
			new Object[]{"I I"," B ","  S",
			'I',Item.itemRegistry.getObject("iron_ingot"),
			'B',Item.itemRegistry.getObject("bucket"),
			'S',Item.itemRegistry.getObject("sign")});
		//Recipe for ender bucket
		GameRegistry.addRecipe(new ItemStack(CompactTanks.enderBucket,1),
			new Object[]{"EEE","EBE","EEE",
			'E',Item.itemRegistry.getObject("ender_pearl"),
			'B',Item.itemRegistry.getObject("bucket")});
	}
}
