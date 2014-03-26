package simwir.ct.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import simwir.ct.CompactTanks;
import simwir.ct.Debug;
import simwir.ct.handler.ChatHandler;
import simwir.ct.handler.ItemUtils;
import simwir.ct.items.ItemMeter;
import simwir.ct.lib.BlockReferences;
import simwir.ct.lib.References;
import simwir.ct.tile.TileSmallTank;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSmallTank extends BlockContainer {
	public BlockSmallTank() {

		super(Material.iron);
		this.setBlockName(BlockReferences.SMALL_TANK_UNC_NAME);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {

		this.blockIcon = par1IIconRegister.registerIcon(References.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		TileSmallTank tileSmallTank = (TileSmallTank) par1World.getTileEntity(x, y, z);
		ItemStack heldtItem = par5EntityPlayer.inventory.getCurrentItem();
		Debug.consoleln("Current fluid in tank: " + tileSmallTank.getFluidName());
		Debug.consoleln("Amount of fluid in tank: " + tileSmallTank.getFluidAmount());
		if (tileSmallTank != null) {
			/*
			 * If the container is empty
			 */
			if (FluidContainerRegistry.isEmptyContainer(heldtItem)) {
				if (tileSmallTank.canFillBucket()) {
					FluidStack availabe = tileSmallTank.drain(ForgeDirection.UNKNOWN, 1000, false);
					ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(availabe, heldtItem);
					if (fillStack != null) {
						if (heldtItem.stackSize == 1) {
							par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, fillStack);
							tileSmallTank.drain(ForgeDirection.UNKNOWN, 1000, true);
							return true;
						} else {
							if (par5EntityPlayer.inventory.addItemStackToInventory(fillStack)) {
								par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, ItemUtils.comsumeItem(heldtItem));
								tileSmallTank.drain(ForgeDirection.UNKNOWN, 1000, true);
							}
							return true;
						}
					}
				}
				/*
				 * If the container if filled
				 */
			} else if (FluidContainerRegistry.isFilledContainer(heldtItem)) {
				if (tileSmallTank.fill(ForgeDirection.UNKNOWN, FluidContainerRegistry.getFluidForFilledItem(heldtItem), false) == 1000) {
					Debug.consoleln("There's space for this fluid");
					par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, ItemUtils.comsumeItem(heldtItem));
					tileSmallTank.fill(ForgeDirection.UNKNOWN, FluidContainerRegistry.getFluidForFilledItem(heldtItem), true);
				}
				return true;
			}else if(heldtItem.isItemEqual(new ItemStack(CompactTanks.meter))){
				Debug.consoleln("Fluid Meter found");
				if(tileSmallTank.isTankEmpty()){
					ChatHandler.sendToPlayer("The tank is empty", par5EntityPlayer);
				}else{
					if(!tileSmallTank.printFluid()){
						ChatHandler.sendToPlayer("Current fluid in tank: " + tileSmallTank.getFluidName(), par5EntityPlayer);
						ChatHandler.sendToPlayer("Amount of fluid in tank: " + tileSmallTank.getFluidAmount(), par5EntityPlayer);
						return true;
					}else{
						Debug.consoleln("Can't print fluid");
					}
				}
			}else {
				if (!par1World.isRemote) {
					// TODO add code for GUI here
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {

		return new TileSmallTank();
	}
}
