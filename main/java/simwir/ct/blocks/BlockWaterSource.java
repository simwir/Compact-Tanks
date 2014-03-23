package simwir.ct.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import simwir.ct.handler.ItemUtils;
import simwir.ct.lib.BlockReferences;
import simwir.ct.lib.References;
import simwir.ct.tile.TileWaterSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWaterSource extends BlockContainer {

	public BlockWaterSource() {
		super(Material.iron);
		setBlockName(BlockReferences.WATER_SOURCE_UNC_NAME);
		setHardness(5.0F);
		setResistance(10.0F);
		setStepSound(soundTypeMetal);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.blockIcon = par1IIconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileWaterSource tileWaterSource = (TileWaterSource) par1World.getTileEntity(x, y, z);
		ItemStack heldItem = par5EntityPlayer.inventory.getCurrentItem();
		
		if(tileWaterSource != null){
			if(FluidContainerRegistry.isEmptyContainer(heldItem)){
				FluidStack available = FluidRegistry.getFluidStack("water", 1000);
				ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(available, heldItem);
				
				if(fillStack != null){
					if(heldItem.stackSize==1){
						par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, fillStack);	
					}else{
						
						if(par5EntityPlayer.inventory.addItemStackToInventory(fillStack)){
							par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, ItemUtils.comsumeItem(heldItem));
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileWaterSource();
	}

}
