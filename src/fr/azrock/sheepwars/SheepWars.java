package fr.azrock.sheepwars;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.sheepwars.Commands.ACommand;
import fr.azrock.sheepwars.Common.Game;
import fr.azrock.sheepwars.Config.ConfigManager;
import fr.azrock.sheepwars.Utils.ListenerManager;
import fr.azrock.sheepwars.Utils.Inventories.InventoryManager;
import fr.azrock.sheepwars.Utils.SetupMode.Mode;

public class SheepWars extends JavaPlugin {
	
	
	private static SheepWars instance;
	
	private ConfigManager configManager;
	
	private InventoryManager guiManager;
	
	private Game gameManager;
	
	
	private Mode setupMode;
	
	
	
	public void onEnable() {
		instance = this;
		
		configManager = new ConfigManager(this);
		
		gameManager = new Game(this);
		
		guiManager = new InventoryManager();
		
		
		setupMode = new Mode();
		
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
		return this.gameManager;
	}
	
	public Mode getSetupMode() {
		return this.setupMode;
	}
	
	public InventoryManager getInventoryManager() {
		return this.guiManager;
	}
}
