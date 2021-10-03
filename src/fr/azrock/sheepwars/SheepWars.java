package fr.azrock.sheepwars;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.sheepwars.Commands.ACommand;
import fr.azrock.sheepwars.Config.ConfigManager;

public class SheepWars extends JavaPlugin {

	
	private static SheepWars instance;
	
	private ConfigManager configManager;
	
	
	
	public void onEnable() {
		instance = this;
		
		configManager = new ConfigManager(this);
		
		
		ACommand.registerCommands(this);		
	}
	
	
	
	public static SheepWars get() {
		return instance;
	}
	
	public ConfigManager getConfigManager() {
		return this.configManager;
	}
}
