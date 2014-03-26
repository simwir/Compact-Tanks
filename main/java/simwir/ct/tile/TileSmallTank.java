package simwir.ct.tile;

import simwir.ct.Debug;
import simwir.ct.handler.TankHandler;
import simwir.ct.lib.BlockReferences;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileSmallTank extends TileEntity implements IFluidHandler{
	public final TankHandler tank = new TankHandler(BlockReferences.SMALL_TANK_UNC_NAME, BlockReferences.SMALL_TANK_CAPACITY, this);
	private String currentFluid = null;
	private int fluidAmount = 0;
	private int fluidCheckCooldown = 0;
	
	/*
	 * Custom code
	 */
	@Override
	public void updateEntity() {
		if(fluidCheckCooldown > 0){
			fluidCheckCooldown--;
		}
	}
	
	public boolean printFluid(){
		Debug.chatln("Checking if cooldown is met");
		if(fluidCheckCooldown == 0){
			fluidCheckCooldown = 200000;
			Debug.chatln("Cooldown met, setting cooldown to " + fluidCheckCooldown);
			return true;
		}else{
			Debug.chatln("Cooldown not met");
			return false;
		}
	}
	/**
	 * @author simon
	 * Checks if the fluid is equal to the fluid in the tank,
	 * or if there's no fluid in the tank.
	 * @param resource - A fluidStack for the fluid going into the tank.
	 * @param changeFluid - A boolean, if the fluid should be changed if the current fluid is null.
	 * @return boolean -  Returns true if the fluid can be filled into the tank, and false if it can't
	 */
	public boolean canFill(FluidStack resource, boolean changeFluid){
		if(currentFluid == null){
			if(changeFluid){
				changeFluid(FluidRegistry.getFluidName(resource));
			}
			return true;
		}else if(currentFluid == FluidRegistry.getFluidName(resource)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @author simon
	 * Returns the fluid type inside the tank
	 * @return Fluid - The fluid inside the tank
	 */
	public Fluid getFluid(){
		return tank.getFluidType();
	}
	/**
	 * @author simon
	 * Returns the name of the fluid name 
	 * @return String - Of the name of the fluid
	 */
	public String getFluidName(){
		if(tank.getFluid() != null){
			return FluidRegistry.getFluidName(tank.getFluid());
		}else{
			return "No fluid in tank";
		}
		
	}
	
	/**
	 * @author simon
	 * Returns a boolean for wether or not the tank is empty
	 * @return boolean -  returns true if the tank is empty, else true
	 */
	public boolean isTankEmpty(){
		if(tank.getFluid() == null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @author simon
	 * Returns the amount of fluid inside the tank
	 * @return
	 */
	public int getFluidAmount(){
		return tank.getFluidAmount();
	}
	
	public boolean canFillBucket(){
		if(tank.getFluidAmount() >= 1000){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @author simon
	 * Changes the fluid in the tank
	 * @param fluidName -  A string for the fluid that is now in the tank
	 */
	public void changeFluid(String fluidName){
		currentFluid = fluidName;
		
	}
	
	/*
	 * IFluidHander 
	 */
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if(canDrain(from, FluidRegistry.getFluid(resource.fluidID))){
			return tank.drain(resource.amount, doDrain);
		}else{
			return null;
		}
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		//if(currentFluid == null){
		//	return true;
		//}else if(currentFluid == FluidRegistry.g)
		if(tank.getFluidType() == null){
			return true;
		}else if(fluid == tank.getFluidType()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if(fluid == tank.getFluidType()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		// TODO Auto-generated method stub
		return null;
	}

}
