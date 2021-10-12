package fr.azrock.sheepwars.Listeners;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Config.ConfigFiles.MessageConfig;

public class ConnectionListeners implements Listener {

	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		
	}
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		//Check GameState to decide message.
		
		event.setJoinMessage(MessageConfig.replacePlayerPHs(MessageConfig.GAME_JOIN, event.getPlayer()));
		
		if(SheepWars.get().getGame().getLobby() != null)
			SheepWars.get().getGame().getLobby().send(event.getPlayer());
		else
			Bukkit.getLogger().log(Level.WARNING, "There is no lobby setup for this session of sheepwars!");
		
	}
	
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
		//Check GameState to decide message.
		
		event.setQuitMessage("");
		
	}
	
}
