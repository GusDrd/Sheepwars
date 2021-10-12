package fr.azrock.sheepwars.Config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public abstract class AConfig {

	private Plugin plugin;
	public String name;
	
	private FileConfiguration config;
	private File configFile;
	
	
	
	public AConfig(String name, Plugin plugin) {
		this.name = name;
		this.plugin = plugin;
		
		saveFile();
		reload();
	}
	
	
	/*
	 * Reload the config based on its name.
	 * Create a new configFile if config.yml doesn't already exist.
	 */
	public void reload() {
		configFile = new File(plugin.getDataFolder(), name+".yml");
        config = new YamlConfiguration();
        
        try {
        	config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
        	Bukkit.getLogger().log(Level.SEVERE, "Could not reload config named : "+getYMLName(), e);
        }
	}
	
	
	public void saveFile() {
		configFile = new File(plugin.getDataFolder(), name+".yml");
		
		if (!configFile.exists()) {
        	configFile.getParentFile().mkdirs();
        	
        	if(plugin.getResource(name+".yml") != null) {
        		plugin.saveResource(name+".yml", false);
        		return;
        	}
        	
        	
        	try {
				configFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getLogger().log(Level.WARNING, "Could not create file "+name+".yml", e);
			}
        	
         }
	}
	
	
	
	/*
	 * Save the config.
	 */
	public void save() {
		try {
			this.config.save(this.configFile);
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not save config named : "+getYMLName(), e);
		}
	}
	
	
	
	/*
	 * Set a path's value.
	 */
	public void setPath(String path, Object value) {
		this.config.set(path, value);
		save();
	}
	
	
	
	/*
	 * Create a new path.
	 */
	public void createPath(String path) {
		this.config.createSection(path);
		save();
	}
	
	
	
	/*
	 * @return Object - The object stored at a given path.
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String path) {
		return (T)this.config.get(path);
	}
	
	
	
	/*
	 * @return boolean - If a config has a given path.
	 */
	public boolean hasPath(String path) {
		return config.getConfigurationSection(path) != null;
	}


	
	/*
	 * @return boolean - If a config's path doesn't have any value(s).
	 */
	public boolean pathIsNull(String path) {
		return (get(path) == null);
	}
	
	
	
	
	
	/*
	 * @return String - The config's name.
	 */
	public String getName() {
		return this.name;
	}
	
	
	
	/*
	 * @return String - The config's name.yml.
	 */
	public String getYMLName() {
		return this.name+".yml";
	}
	
	
	
	/*
	 * @return FileConfiguration - The bukkit config.
	 */
	public FileConfiguration getConfig() {
		return this.config;
	}
	
	
	
	/*
	 * @return File - The config's file.
	 */
	public File getFile() {
		return this.getFile();
	}
	
}
