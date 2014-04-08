package simwir.ct.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import simwir.ct.lib.ItemReferences;
import simwir.ct.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderBucket extends Item {
	public ItemEnderBucket(){
		this.setUnlocalizedName(ItemReferences.ENDER_BUCKET_UNC_NAME);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(References.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}

}
