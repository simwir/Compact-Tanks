package simwir.ct.items;

import simwir.ct.lib.ItemReferences;
import simwir.ct.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMeter extends Item {
	public ItemMeter(){
		super();
		this.setUnlocalizedName(ItemReferences.ITEM_METER_UNC_NAME);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(References.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
