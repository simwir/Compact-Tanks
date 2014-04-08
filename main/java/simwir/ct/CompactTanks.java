package simwir.ct;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import simwir.ct.blocks.BlockLargeTank;
import simwir.ct.blocks.BlockMedTank;
import simwir.ct.blocks.BlockSmallTank;
import simwir.ct.blocks.BlockWaterSource;
import simwir.ct.handler.CraftingHandler;
import simwir.ct.items.ItemEnderBucket;
import simwir.ct.items.ItemMeter;
import simwir.ct.lib.BlockReferences;
import simwir.ct.lib.ItemReferences;
import simwir.ct.lib.References;
import simwir.ct.tile.TileLargeTank;
import simwir.ct.tile.TileMedTank;
import simwir.ct.tile.TileSmallTank;
import simwir.ct.tile.TileWaterSource;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class CompactTanks {
	@Instance(References.MOD_ID)
	public static CompactTanks instance;
	// Defining blocks
	public static Block waterSource;
	public static Block smallTank;
	public static Block medTank;
	public static Block largeTank;
	// Defining Items
	public static Item meter;
	public static Item enderBucket;
	//Capacity
	public static int smallCapacity;
	public static int medCapacity;
	public static int largeCapacity;
	//Other
	public static boolean debug;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.addCustomCategoryComment("Capacity", References.CAPACITY_CONFIG_CATEGORY_COMMENT);
		smallCapacity = config.get("Capacity", "Small Tank", BlockReferences.SMALL_TANK_CAPACITY).getInt();
		if(smallCapacity==-1){smallCapacity=BlockReferences.SMALL_TANK_CAPACITY;}
		medCapacity = config.get("Capacity", "Medium Tank", BlockReferences.MED_TANK_CAPACITY).getInt();
		if(medCapacity==-1){medCapacity=BlockReferences.MED_TANK_CAPACITY;}
		largeCapacity = config.get("Capacity", "Large Tank", BlockReferences.LARGE_TANK_CAPACITY).getInt();
		if(largeCapacity==-1){largeCapacity=BlockReferences.LARGE_TANK_CAPACITY;}
		debug = config.get("Other", "Debug", false, References.DEBUG_CONFIG_COMMENT).getBoolean(false);
		config.save();
		// Adding blocks and items to the actual game
		// Blocks
		waterSource = new BlockWaterSource();
		smallTank = new BlockSmallTank();
		medTank = new BlockMedTank();
		largeTank = new BlockLargeTank();
		// Items
		meter = new ItemMeter();
		enderBucket = new ItemEnderBucket();
		gameRegisters();
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {

		CraftingHandler.craftingHandler();
		registerTileEntities();
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
	private static void gameRegisters() {

		// Registers blocks to the game.
		GameRegistry.registerBlock(waterSource, BlockReferences.WATER_SOURCE_UNC_NAME);
		GameRegistry.registerBlock(smallTank, BlockReferences.SMALL_TANK_UNC_NAME);
		GameRegistry.registerBlock(medTank, BlockReferences.MED_TANK_UNC_NAME);
		GameRegistry.registerBlock(largeTank, BlockReferences.LARGE_TANK_UNC_NAME);
		//Registeres items to the game
		GameRegistry.registerItem(meter, ItemReferences.ITEM_METER_UNC_NAME);
		GameRegistry.registerItem(enderBucket, ItemReferences.ENDER_BUCKET_UNC_NAME);
	}
	private void registerTileEntities() {

		GameRegistry.registerTileEntity(TileWaterSource.class, BlockReferences.WATER_SOURCE_TE_KEY);
		GameRegistry.registerTileEntity(TileSmallTank.class, BlockReferences.SMALL_TANK_TE_KEY);
		GameRegistry.registerTileEntity(TileMedTank.class, BlockReferences.MED_TANK_TE_KEY);
		GameRegistry.registerTileEntity(TileLargeTank.class, BlockReferences.LARGE_TANK_TE_KEY);
	}
}
