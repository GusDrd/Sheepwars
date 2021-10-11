package fr.azrock.sheepwars.Config;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import fr.azrock.sheepwars.Common.GameConfig;
import fr.azrock.sheepwars.Config.ConfigFiles.MessageConfig;

public class ConfigManager {

public Plugin plugin;
	
	public ArrayList<AConfig> configList;
	
	
	
	public ConfigManager(Plugin plugin) {
		this.plugin = plugin;
		
		this.configList = new ArrayList<AConfig>();
		
		registerConfigs();		
	}
	
	
	
	public void registerConfigs() {
		this.configList.add(new MessageConfig(this.plugin));
		this.configList.add(new GameConfig(this.plugin));
	}
	
	
	
	public AConfig getConfigByName(String name) {
		for(AConfig config : configList) {
			if(config.getName().equalsIgnoreCase(name)) {
				Bukkit.getLogger().log(Level.INFO, "Found config named : "+config.getYMLName());
				return config;
			}
		}
		
		return null;
	}
	
	
	
	public FileConfiguration getMainConfig() {
		return this.plugin.getConfig();
	}
}
