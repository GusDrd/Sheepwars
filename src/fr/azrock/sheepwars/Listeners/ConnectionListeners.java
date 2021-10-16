package fr.azrock.sheepwars.Listeners;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Game.GameState;
import fr.azrock.sheepwars.Config.ConfigFiles.MessageConfig;

public class ConnectionListeners {
	
	
	
	public static void onLogin(PlayerLoginEvent event) {
		if (SheepWars.get().getGame().getGameState() != GameState.WAITING) {
			if(!event.getPlayer().hasPermission("sheepwars.spectator")) {
				event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
				event.setKickMessage(ChatColor.RED + "KICK_GAME_STARTED");
			} 
		}else if(Bukkit.getOnlinePlayers().size() >= SheepWars.get().getGame().getMaxPlayers()) {
			event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			event.setKickMessage(ChatColor.RED + "KICK_GAME_FULL");
		} 
	}



	
	
	public static void onJoin(PlayerJoinEvent event) {

		if(SheepWars.get().getGame().getGameState() == GameState.WAITING) {

			event.setJoinMessage(MessageConfig.replacePlayerPHs(MessageConfig.GAME_JOIN, event.getPlayer()));

			if(SheepWars.get().getGame().getLobby() != null)
				SheepWars.get().getGame().getLobby().send(event.getPlayer());
			else
				Bukkit.getLogger().log(Level.WARNING, "There is no lobby setup for this session of sheepwars!");

			if(Bukkit.getOnlinePlayers().size() == SheepWars.get().getGame().getMinPlayers()) {

			}

		}else {

			event.setJoinMessage("");

			if(SheepWars.get().getGame().getSpecLobby() != null)
				SheepWars.get().getGame().getSpecLobby().send(event.getPlayer());
			else
				Bukkit.getLogger().log(Level.WARNING, "There is no spectator lobby setup for this session of sheepwars!");

		}

	}



	
	
	public static void onQuit(PlayerQuitEvent event) {

		//Check GameState to decide message.
		if(SheepWars.get().getGame().getGameState() == GameState.WAITING) {
			
			if(Bukkit.getOnlinePlayers().size() == SheepWars.get().getGame().getMinPlayers())
				SheepWars.get().getGame().stopWaitingTask();
			
		}else if(SheepWars.get().getGame().getGameState() != GameState.IN_GAME) {
			
			// Return if spectator
			// Manage in game player disconnection.
			
		}

		event.setQuitMessage("");

	}
	
	

}
