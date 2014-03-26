package simwir.ct.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class ChatHandler {

	/**
	 * @author simon
	 * Displays the message in the players chat
	 * @param par1Message - the message to be shown
	 * @param par2Player - the player to show the message to
	 */
	public static void sendToPlayer(String par1Message, EntityPlayer par2Player){
		if(par1Message.length() > 0){
			par2Player.addChatMessage(new ChatComponentTranslation(par1Message));
		}
	}
	
}
