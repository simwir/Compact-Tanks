package simwir.ct;

import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.ChatMessageComponent;

public class Debug {
	private static boolean debug = CompactTanks.debug;
	public static void consoleln(String par1Message){
		if(debug){
			System.out.println("[Creative-Supplier]"+"[Debug]"+par1Message);
		}
	}
	public static void chatln(String par1Message){
		if(debug){
			//TODO find a way to send messages to the chat
			//MinecraftServer.getServer().getConfigurationManager().sendChatMsg(ChatMessageComponent.createFromText("[Creative-Supplier]"+"[Debug]"+par1Message));
		}
	}
	public void chatln(String par1Message, EntityPlayer par2Player){
		if(debug){
			//TODO Find a way to send messages to the chat
			//par2Player.addChatMessage("[Creative-Supplier]"+"[Debug]"+par1Message);
		}
	}

}