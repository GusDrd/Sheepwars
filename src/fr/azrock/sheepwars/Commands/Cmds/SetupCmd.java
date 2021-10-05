package fr.azrock.sheepwars.Commands.Cmds;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.azrock.sheepwars.Commands.SubCommand;

public class SetupCmd extends SubCommand {

	@Override
	public void execute(Player player, String[] args) {
		
		
		player.sendMessage(ChatColor.GREEN+"Setup inventory coming soon...");
		//Open setup inventory
		
	}

	@Override
	public String name() {
		return "setup";
	}

	@Override
	public String permission() {
		return "sheepwars.setup";
	}

}
