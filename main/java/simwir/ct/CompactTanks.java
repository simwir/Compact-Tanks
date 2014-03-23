package simwir.ct;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import simwir.ct.blocks.BlockWaterSource;
import simwir.ct.handler.CraftingHandler;
import simwir.ct.lib.BlockReferences;
import simwir.ct.lib.References;
import simwir.ct.tile.TileWaterSource;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
public class CompactTanks {
	
	@Instance(References.MOD_ID)
	public static CompactTanks instance;
	
	//Defining blocks
	public static Block waterSource;
	
	//Defining Items
	//ex. public static Item goldDust;
	
	public static boolean debug;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		 
		 config.load();
		 debug = config.get("Other", "Debug", false,References.DEBUG_CONFIG_COMMENT).getBoolean(false);
		 config.save();
		 
		// Adding blocks and items to the actual game
		//ex. fluidSupplier = new BlockFluidSupplier();
		 waterSource = new BlockWaterSource();
		 
		 gameRegisters();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		CraftingHandler.craftingHandler();
		registerTileEntities();
		
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		
	}
	
	private static void gameRegisters(){
		
		 // Registers blocks to the game. Only needed on blocks
		GameRegistry.registerBlock(waterSource, BlockReferences.WATER_SOURCE_UNC_NAME);
	}
	
	
	private void registerTileEntities() {
		
		GameRegistry.registerTileEntity(TileWaterSource.class, BlockReferences.WATER_SOURCE_TE_KEY);
	}
	
}
