package simwir.ct.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import simwir.ct.handler.TankHandler;
import simwir.ct.lib.BlockReferences;

public class TileWaterSource extends TileEntity implements IFluidHandler{
	public final TankHandler tank = new TankHandler(BlockReferences.WATER_SOURCE_UNC_NAME, 16000, this);

	/*
	 * IFluidHandler
	 */
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if(resource == null) return null;
		if(!resource.isFluidEqual(tank.getFluid())) return null;
		return drain(from, resource.amount, doDrain);
		
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return FluidRegistry.getFluidStack("water", maxDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if(fluid == FluidRegistry.getFluid("water")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[]{tank.getInfo()};
	}

}
