package simwir.ct;

import net.minecraftforge.common.config.Configuration;
import simwir.ct.lib.References;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
public class CompactTanks {
	
	@Instance(References.MOD_ID)
	public static CompactTanks instance;
	
	//Defining blocks
	//ex. public static Block fluidSupplier;
	
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
		 
		 gameRegisters();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		registerTileEntities();
		
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		
	}
	
	private static void gameRegisters(){
		
		 // Registers blocks to the game. Only be needed on blocks
		//ex. GameRegistry.registerBlock(powerSupplier, BlockReferences.POWER_SUPPLIER_UNC_NAME);
	}
	
	
	private void registerTileEntities() {
		
		//ex. GameRegistry.registerTileEntity(TileFluidSupplier.class, BlockReferences.FLUID_SUPPLIER_TE_KEY);
	}
	
}
