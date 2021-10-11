package fr.azrock.sheepwars.Common;

import org.bukkit.plugin.Plugin;

import fr.azrock.sheepwars.Config.AConfig;
import fr.azrock.sheepwars.Utils.Spawn;

public class GameConfig extends AConfig {

	private final String PATH = "game.";


	private final String MIN_PLAYERS = "minPlayers";
	private final String REDUCE_PLAYERS = "playersToReduce";
	private final String MAX_PLAYERS = "maxPlayers";

	private final String WAIT_TIME = "waitingTime";
	private final String GAME_TIME = "gameTime";
	private final String DEATH_TIME = "deathMatchTime";

	private final String BONUS_INTERVAL = "bonusSpawnInterval";

	private final String SHEEP_INTERVAL = "sheepGiveInterval";
	private final String DEATH_INTERVAL = "deathMatchGiveInterval";
	
	private final String LOBBY = "lobby";
	private final String SPEC_LOBBY = "specLobby";





	public GameConfig(Plugin plugin) {
		super("game", plugin);

		
		
		if(!this.hasPath("game")) {

			this.setPath(PATH+MIN_PLAYERS, 8);
			this.setPath(PATH+REDUCE_PLAYERS, 14);
			this.setPath(PATH+MAX_PLAYERS, 10);

			this.setPath(PATH+WAIT_TIME, 120);
			this.setPath(PATH+GAME_TIME, 600);
			this.setPath(PATH+DEATH_TIME, 300);

			this.setPath(PATH+BONUS_INTERVAL, 60);
			//List of serialized locations needs to be saved for bonus to work.

			this.setPath(PATH+SHEEP_INTERVAL, 30);
			this.setPath(PATH+DEATH_INTERVAL, 60);
		}
		
	}





	public void setMinPlayers(int i) {
		this.setPath(PATH+MIN_PLAYERS, i);
	}

	public void setPlayersToReduce(int i) {
		this.setPath(PATH+REDUCE_PLAYERS, i);
	}

	public void setMaxPlayers(int i) {
		this.setPath(PATH+MAX_PLAYERS, i);
	}

	public void setWaitingTime(int i) {
		this.setPath(PATH+WAIT_TIME, i);
	}

	public void setGameTime(int i) {
		this.setPath(PATH+GAME_TIME, i);
	}

	public void setDeathMatchTime(int i) {
		this.setPath(PATH+DEATH_TIME, i);
	}

	public void setBonusSpawnInterval(int i) {
		this.setPath(PATH+BONUS_INTERVAL, i);
	}

	public void setSheepGiveInterval(int i) {
		this.setPath(PATH+SHEEP_INTERVAL, i);
	}

	public void setDeathMatchGiveInterval(int i) {
		this.setPath(PATH+DEATH_INTERVAL, i);
	}
	
	public void setLobby(String s) {
		this.setPath(PATH+LOBBY, s);
	}
	
	public void setSpecLobby(String s) {
		this.setPath(PATH+SPEC_LOBBY, s);
	}





	public int getMinPlayers() {
		return this.get(PATH+MIN_PLAYERS);
	}

	public int getPlayersToReduce() {
		return this.get(PATH+REDUCE_PLAYERS);
	}

	public int getMaxPlayers() {
		return this.get(PATH+MAX_PLAYERS);
	}

	public int getWaitingTime() {
		return this.get(PATH+WAIT_TIME);
	}

	public int getGameTime() {
		return this.get(PATH+GAME_TIME);
	}

	public int getDeathMatchTime() {
		return this.get(PATH+DEATH_TIME);
	}

	public int getBonusSpawnInterval() {
		return this.get(PATH+BONUS_INTERVAL);
	}

	public int getSheepGiveInterval() {
		return this.get(PATH+SHEEP_INTERVAL);
	}

	public int getDeathMatchGiveInterval() {
		return this.get(PATH+DEATH_INTERVAL);
	}
	
	public Spawn getLobby() {
		return Spawn.unserialize(this.get(PATH+LOBBY));
	}
	
	public Spawn getSpecLobby() {
		return Spawn.unserialize(this.get(PATH+SPEC_LOBBY));
	}
}
