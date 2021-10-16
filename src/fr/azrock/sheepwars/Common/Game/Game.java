package fr.azrock.sheepwars.Common.Game;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Sheeps.Sheep;
import fr.azrock.sheepwars.Common.Tasks.DeathmatchTask;
import fr.azrock.sheepwars.Common.Tasks.GameTask;
import fr.azrock.sheepwars.Common.Tasks.WaitingTask;
import fr.azrock.sheepwars.Utils.Spawn;

public class Game {

	private SheepWars plugin;

	private GameConfig config;


	// -- Players --
	private int minPlayers;
	private int playersToReduce;
	private int maxPlayers;

	// -- Times --
	private int waitingTime;
	private int gameTime;
	private int deathMatchTime;

	// -- Tasks --
	private WaitingTask waitTask;
	private GameTask gameTask;
	private DeathmatchTask deathTask;
	
	// -- Bonus --
	private int bonusSpawnInterval;
	public ArrayList<Location> bonusLocs;

	// -- Give Intervals --
	private int sheepGiveInterval;
	private int deathMatchGiveInterval;

	// -- Sheeps --
	public ArrayList<Sheep> enabledSheeps;

	// -- Spawns --
	private Spawn lobby;
	private Spawn specSpawn;
	public ArrayList<Spawn> redSpawns;
	public ArrayList<Spawn> blueSpawns;
	
	// -- Other --
	private GameState state;



	public Game(SheepWars plugin) {

		this.plugin = plugin;

		this.config = (GameConfig)plugin.getConfigManager().getConfigByName("game");


		//----- PLAYER LIMITS -------------------
		minPlayers = config.getMinPlayers();
		maxPlayers = config.getMaxPlayers();
		playersToReduce = config.getPlayersToReduce();


		//----- TIMERS --------------------------
		waitingTime = config.getWaitingTime();
		gameTime = config.getGameTime();
		deathMatchTime = config.getDeathMatchGiveInterval();
		

		//----- TASKS ---------------------------
		waitTask = null;
		gameTask = new GameTask(this);
		deathTask = new DeathmatchTask(this);


		//----- BONUS ---------------------------
		bonusSpawnInterval = config.getBonusSpawnInterval();
		this.bonusLocs = new ArrayList<Location>();


		//----- INTERVALS -----------------------
		sheepGiveInterval = config.getSheepGiveInterval();
		deathMatchGiveInterval = config.getDeathMatchGiveInterval();


		//----- SHEEPS ON -----------------------
		this.enabledSheeps = new ArrayList<Sheep>();


		//----- SPAWNS --------------------------
		this.lobby = config.getLobby();
		this.specSpawn = config.getSpecLobby();
		this.redSpawns = new ArrayList<Spawn>();
		this.blueSpawns = new ArrayList<Spawn>();
		
		if(config.getRedSpawns() != null)
			for(String s : config.getRedSpawns()) redSpawns.add(Spawn.unserialize(s));
		
		if(config.getBlueSpawns() != null)
			for(String s : config.getBlueSpawns()) blueSpawns.add(Spawn.unserialize(s));
		
		
		//----- OTHER --------------------------
		state = GameState.WAITING;
	}



	/* ==============================================================  *
	 * ===                      GAME METHODS                      ===  *
	 * ==============================================================  */

	public void startGame() {

	}

	public void endGame() {

	}




	/* =========================================================  *
	 * ===                      GETTERS                      ===  *
	 * =========================================================  */

	public int getMinPlayers() {
		return minPlayers;
	}

	public int getPlayersToReduce() {
		return playersToReduce;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public int getGameTime() {
		return gameTime;
	}

	public int getDeathMatchTime() {
		return deathMatchTime;
	}

	public int getBonusSpawnInterval() {
		return bonusSpawnInterval;
	}

	public ArrayList<Location> getBonusLocations() {
		return bonusLocs;
	}

	public int getSheepGiveInterval() {
		return sheepGiveInterval;
	}

	public int getDeathMatchGiveInterval() {
		return deathMatchGiveInterval;
	}

	public ArrayList<Sheep> getEnabledSheeps() {
		return enabledSheeps;
	}

	public Spawn getLobby() {
		return lobby;
	}

	public Spawn getSpecLobby() {
		return specSpawn;
	}

	public ArrayList<Spawn> getRedSpawns() {
		return redSpawns;
	}

	public ArrayList<Spawn> getBlueSpawns() {
		return blueSpawns;
	}
	
	public WaitingTask getWaitingTask() {
		return waitTask;
	}
	
	public GameTask getGameTask() {
		return gameTask;
	}
	
	public DeathmatchTask getDeathmatchTask() {
		return deathTask;
	}
	
	public GameState getGameState() {
		return state;
	}



	/* =========================================================  *
	 * ===                      SETTERS                      ===  *
	 * =========================================================  */

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
		config.setMinPlayers(minPlayers);
	}

	public void setPlayersToReduce(int playersToReduce) {
		this.playersToReduce = playersToReduce;
		config.setPlayersToReduce(playersToReduce);
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
		config.setMaxPlayers(maxPlayers);
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
		config.setWaitingTime(waitingTime);
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
		config.setGameTime(gameTime);
	}

	public void setDeathMatchTime(int deathMatchTime) {
		this.deathMatchTime = deathMatchTime;
		config.setDeathMatchTime(deathMatchTime);
	}

	public void setBonusSpawnInterval(int bonusSpawnInterval) {
		this.bonusSpawnInterval = bonusSpawnInterval;
		config.setBonusSpawnInterval(bonusSpawnInterval);
	}

	public void setSheepGiveInterval(int sheepGiveInterval) {
		this.sheepGiveInterval = sheepGiveInterval;
		config.setSheepGiveInterval(sheepGiveInterval);
	}

	public void setDeathMatchGiveInterval(int deathMatchGiveInterval) {
		this.deathMatchGiveInterval = deathMatchGiveInterval;
		config.setDeathMatchGiveInterval(deathMatchGiveInterval);
	}

	public void setLobby(Spawn lobby) {
		this.lobby = lobby;
		config.setLobby(lobby.serialize());
	}

	public void setSpecLobby(Spawn specSpawn) {
		this.specSpawn = specSpawn;
		config.setSpecLobby(lobby.serialize());
	}

	public void addRedSpawn(Spawn spawn) {
		this.redSpawns.add(spawn);
	}

	public void saveRedSpawn() {
		ArrayList<String> list = new ArrayList<String>();
		for(Spawn s : redSpawns) list.add(s.serialize());
		config.setRedSpawns(list);
	}

	public void addBlueSpawn(Spawn spawn) {
		this.blueSpawns.add(spawn);
	}

	public void saveBlueSpawns() {
		ArrayList<String> list = new ArrayList<String>();
		for(Spawn s : blueSpawns) list.add(s.serialize());
		config.setBlueSpawns(list);
	}
	
	public void setGameState(GameState state) {
		this.state = state;
	}
	
	public void runWaitingTask() {
		this.waitTask = new WaitingTask(this);
		waitTask.runTaskTimer(plugin, 0L, 20L);
	}
	
	public void stopWaitingTask() {
		this.waitTask.cancel();
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setLevel(0);
			p.setExp(0.0F);
		}
	}
	
	public void reduceWaitingTask() {
		this.waitTask.reduce();
	}
}
