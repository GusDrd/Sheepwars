package fr.azrock.sheepwars.Config.ConfigFiles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Config.AConfig;

public class MessageConfig extends AConfig {

	//private final String PATH = "message.";



	public static String GAME_JOIN, WAIT_TIME;

	public MessageConfig(Plugin plugin) {
		super("messages", plugin);

		GAME_JOIN = translate(this.get("GAME_JOIN"));
		WAIT_TIME = translate(this.get("WAIT_TIME"));
	}


	public static String replaceValuePHs(String s) {
		return s.replaceAll("%players%", ""+Bukkit.getOnlinePlayers())
				.replaceAll("%max_players%", ""+SheepWars.get().getGame().getMaxPlayers());
	}

	public static String replacePlayerPHs(String s, Player p) {
		return s.replaceAll("%players%", ""+Bukkit.getOnlinePlayers().size())
				.replaceAll("%max_players%", ""+SheepWars.get().getGame().getMaxPlayers())
				.replaceAll("%player%", p.getName());
	}


	public String translate(String s) {
		if(s == null) return "";

		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
