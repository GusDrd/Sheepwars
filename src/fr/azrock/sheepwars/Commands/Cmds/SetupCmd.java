package fr.azrock.sheepwars.Commands.Cmds;

import org.bukkit.entity.Player;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Commands.SubCommand;

public class SetupCmd extends SubCommand {

	@Override
	public void execute(Player player, String[] args) {
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
