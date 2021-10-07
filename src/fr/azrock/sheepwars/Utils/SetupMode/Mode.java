package fr.azrock.sheepwars.Utils.SetupMode;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

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
			player.sendMessage(ChatColor.YELLOW+"To setup the spawn point, place yourself at a location, look in the direction you wish and interract with the compass.");
			player.sendMessage(ChatColor.YELLOW+"This will automatically save the spawn point.");
			player.sendMessage(ChatColor.GRAY+"--------");
			
		}else if(mode == SetupMode.RED_SPAWNS || mode == SetupMode.BLUE_SPAWNS) {
			
			
			
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
