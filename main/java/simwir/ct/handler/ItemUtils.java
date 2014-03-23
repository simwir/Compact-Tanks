package simwir.ct.handler;

import net.minecraft.item.ItemStack;

public class ItemUtils {

	/**
	 * Takes The item stack and removes one item from the stack
	 * @param par1ItemStack - The item stack you want to remove 1 item from
	 * @return ItemStack - par1ItemStack but with one less item in the stack
	 */
	public static ItemStack comsumeItem(ItemStack par1ItemStack) {
		if(par1ItemStack.stackSize == 1){
			//TODO Find a way to make this code work
			/*
			 * This code is currently commented out due to it never being used
			 * This method is only called one place, and the check that is run here
			 * is already being checked before this method is called
			if(par1Stack.getItem().hasContainerItem()){
				return par1Stack.getItem().getContainerItemStack(par1Stack);
			}else{
				return null;
			}
			*/
			return null;
		}else{
			par1ItemStack.splitStack(1);
			return par1ItemStack;
		}
	}

}
