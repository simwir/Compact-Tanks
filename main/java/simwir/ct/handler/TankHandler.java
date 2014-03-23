package simwir.ct.handler;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;

public class TankHandler extends FluidTank{
	
	private final String name;

	public TankHandler(String name, int capacity, TileEntity tile) {
		super(capacity);
		this.name = name;
		this.tile = tile;
	}
	
	public Fluid getFluidType(){
		return getFluid() !=null ? getFluid().getFluid() : null;
	}
	
	@Override
	public final NBTTagCompound writeToNBT(NBTTagCompound nbt){
		if(fluid != null){
			fluid.writeToNBT(nbt);
		}else{
			nbt.setString("Empty", "");
		}
		return nbt;
	}
	
	@Override
	public FluidTank readFromNBT(NBTTagCompound nbt) {
		if (!nbt.hasKey("Empty"))
        {
            FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt);

            if (fluid != null)
            {
                setFluid(fluid);
            }
        }
        return this;
	}
	
	@Override
	public FluidTankInfo getInfo() {
		return new FluidTankInfo(this);
	}

}
