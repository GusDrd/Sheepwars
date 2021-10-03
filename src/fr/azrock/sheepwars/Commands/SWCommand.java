package fr.azrock.sheepwars.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.entity.Player;

public class SWCommand extends ACommand {

	private static ArrayList<SubCommand> sCommands;
	
	
	public SWCommand() {
		super("Sheepwars", "sheepwars");
		
		sCommands = new ArrayList<SubCommand>();
		registerSubCommands();
	}
	
	
	public void registerSubCommands() {
		
		
	}
	

	@Override
	public void execute(Player player, String[] args) {
		
		if(args.length == 0) {

			//MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Essaie avec /warp list/create/remove/tp <warp>");
			return;

		}else {

			SubCommand cmdArg = getSC(args[0]);

			//Check if argument exists
			if(cmdArg == null) {
				//MessageUtils.getInstance().alert(player, Alert.UNKNOWN_COMMAND);
				return;
			}

			ArrayList<String> al = new ArrayList<String>();		//Declare new ArrayList al
			al.addAll(Arrays.asList(args));  					//Initialize new arrayList al with the args array's content.
			al.remove(0);										//Remove first argument (eg. /parcours add Test, remove 'add' argument)
			args = al.toArray(new String[al.size()]);			//Set new args to the modified ArrayList al in order to compensate for seperate arg classes.

			try {
				cmdArg.execute(player, args);
			}catch(Exception e) { player.sendMessage("§cUne erreur s'est produite!"); e.printStackTrace(); }

		}
		
	}

	
	public SubCommand getSC(String args) {
		for(SubCommand sc : sCommands) {
			if(sc.name().equalsIgnoreCase(args)) return sc;
		}
		
		return null;
	}
}
