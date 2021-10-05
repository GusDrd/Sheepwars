package fr.azrock.sheepwars.Common;

import org.bukkit.plugin.Plugin;

import fr.azrock.sheepwars.Config.AConfig;

public class GameConfig extends AConfig {

	private final String PATH = "game.";
	
	
	public GameConfig(Plugin plugin) {
		super("game", plugin);
		
		setupDefaultGameConfig();
	}
	
	
	public void setupDefaultGameConfig() {
		
		if(!this.hasPath("game")) {
			
			this.setPath(PATH+"minPlayers", 8);
			this.setPath(PATH+"playersToReduce", 14);
			this.setPath(PATH+"maxPlayers", 10);
			
			this.setPath(PATH+"waitingTime", 120);
			this.setPath(PATH+"gameTime", 600);
			this.setPath(PATH+"deathMatchTime", 300);
			
			this.setPath(PATH+"bonusSpawnInterval", 60);
			//List of serialized locations needs to be saved for bonus to work.
			
			this.setPath(PATH+"sheepGiveInterval", 30);
			this.setPath(PATH+"deathMatchGiveInterval", 60);
		}
		
	}
	
	
	
	
	public int getMinPlayers() {
		return this.get(PATH+"minPlayers");
	}

	public int getPlayersToReduce() {
		return this.get(PATH+"playersToReduce");
	}

	public int getMaxPlayers() {
		return this.get(PATH+"maxPlayers");
	}

	public int getWaitingTime() {
		return this.get(PATH+"waitingTime");
	}

	public int getGameTime() {
		return this.get(PATH+"gameTime");
	}

	public int getDeathMatchTime() {
		return this.get(PATH+"deathMatchTime");
	}

	public int getBonusSpawnInterval() {
		return this.get(PATH+"bonusSpawnInterval");
	}

	public int getSheepGiveInterval() {
		return this.get(PATH+"sheepGiveInterval");
	}
	
	public int getDeathMatchGiveInterval() {
		return this.get(PATH+"deathMatchGiveInterval");
	}
	
	

}
