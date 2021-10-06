package fr.azrock.sheepwars;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.sheepwars.Commands.ACommand;
import fr.azrock.sheepwars.Common.Game;
import fr.azrock.sheepwars.Config.ConfigManager;
import fr.azrock.sheepwars.Utils.ListenerManager;

public class SheepWars extends JavaPlugin {

	
	private static SheepWars instance;
	
	private ConfigManager configManager;
	
	private Game game;
	
	
	
	public void onEnable() {
		instance = this;
		
		configManager = new ConfigManager(this);
		
		game = new Game(this);
		
		
		ACommand.registerCommands(this);
		
		ListenerManager.registerListeners(this);
	}
	
	
	
	public static SheepWars get() {
		return instance;
	}
	
	public ConfigManager getConfigManager() {
		return this.configManager;
	}
	
	public Game getGame() {
		return this.game;
	}
}
