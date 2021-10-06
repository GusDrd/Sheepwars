package fr.azrock.sheepwars.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		
	}
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		//Check GameState to decide message.
		
		event.setJoinMessage("");
		
	}
	
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
		//Check GameState to decide message.
		
		event.setQuitMessage("");
		
	}
	
}
