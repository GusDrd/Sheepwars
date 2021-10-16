package fr.azrock.sheepwars.Commands.Cmds;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.azrock.sheepwars.Commands.SubCommand;
import fr.azrock.sheepwars.Common.Enums.EnumSheep;

public class GiveCmd extends SubCommand {

	@Override
	public void execute(Player player, String[] args) {
		if(args.length == 0) {

			StringBuilder sb = new StringBuilder();

			for(EnumSheep sheep : EnumSheep.values()) {
				sb.append(sheep.getWoolItem().getItemMeta().getDisplayName());
				if(sheep == EnumSheep.TRACKER) {
					sb.append(ChatColor.GRAY+".");
					continue;
				}
				sb.append(ChatColor.GRAY+", ");
			}

			player.sendMessage(ChatColor.YELLOW+"Available Sheeps:");
			player.sendMessage(sb.toString());
			return;

		}else {

			String type = args[0];
			EnumSheep sheep = null;
			
			try {
				sheep = EnumSheep.valueOf(type);
			}catch(Error e) { player.sendMessage(ChatColor.RED+"This sheep does not exist! Type "+'"'+"/sw give"+'"'+" to get a list of available sheeps."); }
			
			if(sheep != null)
				player.getInventory().addItem(sheep.getWoolItem());
			
		}
	}

	@Override
	public String name() {
		return "give";
	}

	@Override
	public String permission() {
		return "sheepwars.give";
	}

}
