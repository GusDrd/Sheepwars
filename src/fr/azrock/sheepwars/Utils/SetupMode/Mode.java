package fr.azrock.sheepwars.Utils.SetupMode;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.azrock.sheepwars.Utils.ItemBuilder;

public class Mode {
	
	
	private boolean isEnabled;
	
	private Player player;
	
	private SetupMode mode;
	
	
	
	public Mode() {
		isEnabled = false;
		player = null;
		mode = null;
	}
	
	
	
	/**
	 * @return true if operation succeeded
	 * */
	public boolean enter(Player player, SetupMode mode) {
		
		if(isEnabled)
			return false;
		
		isEnabled = true;
		this.player = player;
		this.mode = mode;
		
		player.closeInventory();
		
		
		if(mode == SetupMode.LOBBY || mode == SetupMode.SPEC_LOBBY) {
			
			player.sendMessage(ChatColor.GRAY+"--------");
			player.sendMessage(ChatColor.YELLOW+"To setup the spawn point, place yourself at a location, look in the direction you wish and interract with the spawnpoint selector.");
			player.sendMessage(ChatColor.YELLOW+"This will automatically save the spawn point.");
			player.sendMessage(ChatColor.GRAY+"--------");
			
			player.getInventory().clear();
			player.getInventory().setItem(0, new ItemBuilder("Spawnpoint Selector", 1, Material.BLAZE_ROD).build());
			
		}else if(mode == SetupMode.RED_SPAWNS || mode == SetupMode.BLUE_SPAWNS) {
			
			player.sendMessage(ChatColor.GRAY+"--------");
			player.sendMessage(ChatColor.YELLOW+"To setup the spawnpoints, place yourself at a location, look in the direction you wish and interract with the spawnpoint selector.");
			player.sendMessage(ChatColor.RED+"Careful! Not saving enough spawns will cause players to spawn on top of eachother!");
			player.sendMessage(" ");
			player.sendMessage(ChatColor.YELLOW+"Once you have saved as many spawns as you wish, drop the stick to save.");
			player.sendMessage(ChatColor.YELLOW+"Remove spawnpoints through the "+ChatColor.AQUA+"game.yml"+ChatColor.YELLOW+" config.");
			player.sendMessage(ChatColor.GRAY+"--------");
						
			player.getInventory().clear();
			player.getInventory().setItem(0, new ItemBuilder("Spawnpoint Selector", 1, Material.BLAZE_ROD).build());
			
			
		}else if(mode == SetupMode.BONUS) {
			
			
			
		}
		
		return true;
	}
	
	public void leave() {
		
		player.getInventory().clear();
		
		player = null;
		mode = null;
		
		isEnabled = false;
	}
	
	
	
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public SetupMode getMode() {
		return mode;
	}
	
}
