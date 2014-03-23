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
		
		
		//Recipe for WaterSource
		GameRegistry.addRecipe(new ItemStack(CompactTanks.waterSource,1),
			new Object[]{"III","WBW","III",'I',
			Item.itemRegistry.getObject("iron_ingot"),
			'W',Item.itemRegistry.getObject("water_bucket"),
			'B', Item.itemRegistry.getObject("bucket")});
		
	}
}
