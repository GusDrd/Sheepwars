package fr.azrock.sheepwars.Utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Listeners.ConnectionListeners;
import fr.azrock.sheepwars.Utils.Inventories.InventoryListeners;

public class ListenerManager {

	public static void registerListeners(SheepWars plugin) {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new InventoryListeners(), plugin);
		pm.registerEvents(new ConnectionListeners(), plugin);
	}
	
}
