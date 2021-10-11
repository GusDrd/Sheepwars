package fr.azrock.sheepwars.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.azrock.sheepwars.Commands.Cmds.SetupCmd;

public class SWCommand extends ACommand {

	private static ArrayList<SubCommand> sCommands;
	
	
	public SWCommand() {
		super("Sheepwars");
		
		sCommands = new ArrayList<SubCommand>();
		registerSubCommands();
	}
	
	
	public void registerSubCommands() {
		sCommands.add(new SetupCmd());
	}
	

	@Override
	public void execute(Player player, String[] args) {
		
		if(args.length == 0) {
			
			if(!player.hasPermission("sheepwars.help")) return;

			player.sendMessage(ChatColor.DARK_GRAY+"-------- "+ChatColor.AQUA+"SheepWars"+ChatColor.DARK_GRAY+" --------");
			player.sendMessage(ChatColor.YELLOW+"Welcome in SheepWars!");
			player.sendMessage(" ");
			player.sendMessage(ChatColor.YELLOW+"To configure your sheepwars server,");
			player.sendMessage(ChatColor.YELLOW+"simply type "+ChatColor.AQUA+"/sw setup"+ChatColor.YELLOW+" and navigate");
			player.sendMessage(ChatColor.YELLOW+"through the menu to setup everything.");
			player.sendMessage(" ");
			player.sendMessage(ChatColor.YELLOW+"All public messages can be changed through");
			player.sendMessage(ChatColor.YELLOW+"the "+ChatColor.AQUA+"message.yml"+ChatColor.YELLOW+" configuration file.");
			player.sendMessage(ChatColor.DARK_GRAY+"--------------------------");
			return;

		}else {

			SubCommand cmdArg = getSC(args[0]);

			//Check if argument exists
			if(cmdArg == null) {
				if(!player.hasPermission("sheepwars.help")) return;
				
				player.sendMessage(ChatColor.RED+"This command doesn't exist! Try /sheepwars to get help.");
				return;
			}
			
			if(!player.hasPermission(cmdArg.permission())) return;
			

			ArrayList<String> al = new ArrayList<String>();		//Declare new ArrayList al
			al.addAll(Arrays.asList(args));  					//Initialize new arrayList al with the args array's content.
			al.remove(0);										//Remove first argument (eg. /parcours add Test, remove 'add' argument)
			args = al.toArray(new String[al.size()]);			//Set new args to the modified ArrayList al in order to compensate for seperate arg classes.

			try {
				cmdArg.execute(player, args);
			}catch(Exception e) { player.sendMessage(ChatColor.RED+"An error occured!"); e.printStackTrace(); }

		}
		
	}

	
	public SubCommand getSC(String args) {
		for(SubCommand sc : sCommands) {
			if(sc.name().equalsIgnoreCase(args)) return sc;
		}
		
		return null;
	}
}
