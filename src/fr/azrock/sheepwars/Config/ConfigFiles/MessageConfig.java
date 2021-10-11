package fr.azrock.sheepwars.Config.ConfigFiles;

import org.bukkit.plugin.Plugin;

import fr.azrock.sheepwars.Config.AConfig;

public class MessageConfig extends AConfig {

	private final String PATH = "message.";
	
	
	
	public static String ARENA_JOIN, ARENA_LEAVE;
	
	public MessageConfig(Plugin plugin) {
		super("messages", plugin);
				
		ARENA_JOIN = this.get(PATH+"ARENA_JOIN");
		ARENA_LEAVE = this.get(PATH+"ARENA_LEAVE");
	}

}
