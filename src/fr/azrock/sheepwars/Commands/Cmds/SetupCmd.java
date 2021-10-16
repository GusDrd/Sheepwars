package fr.azrock.sheepwars.Commands.Cmds;

import org.bukkit.entity.Player;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Commands.SubCommand;
import fr.azrock.sheepwars.Common.Game.GameState;
import net.md_5.bungee.api.ChatColor;

public class SetupCmd extends SubCommand {

	@Override
	public void execute(Player player, String[] args) {
		
		if(SheepWars.get().getGame().getGameState() != GameState.WAITING) {
			player.sendMessage(ChatColor.RED+"A game has already started! You can only setup your server before a game starts.");
			return;
		}
			
			
			
		SheepWars.get().getInventoryManager().getSetupInventory().open(player);
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
