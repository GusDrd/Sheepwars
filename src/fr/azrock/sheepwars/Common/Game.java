package fr.azrock.sheepwars.Common;

import java.util.ArrayList;

import org.bukkit.Location;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Sheeps.Sheep;
import fr.azrock.sheepwars.Utils.Spawn;

public class Game {

	private SheepWars plugin;
	
	private GameConfig config;
	

	private int minPlayers;
	private int playersToReduce;
	private int maxPlayers;

	private int waitingTime;
	private int gameTime;
	private int deathMatchTime;

	private int bonusSpawnInterval;
	public ArrayList<Location> bonusLocs;

	private int sheepGiveInterval;
	private int deathMatchGiveInterval;

	public ArrayList<Sheep> enabledSheeps;

	private Spawn lobby;
	private Spawn specSpawn;
	public ArrayList<Spawn> redSpawns;
	public ArrayList<Spawn> blueSpawns;



	public Game(SheepWars plugin) {

		this.plugin = plugin;
		
		this.config = (GameConfig)plugin.getConfigManager().getConfigByName("game");

		
		//----- PLAYER LIMITS -------------------
		setMinPlayers(config.getMinPlayers());
		setMaxPlayers(config.getMaxPlayers());
		setPlayersToReduce(config.getPlayersToReduce());

		
		//----- TIMERS --------------------------
		setWaitingTime(config.getWaitingTime());
		setGameTime(config.getGameTime());
		setDeathMatchTime(config.getDeathMatchGiveInterval());

		
		//----- BONUS ---------------------------
		setBonusSpawnInterval(config.getBonusSpawnInterval());
		this.bonusLocs = new ArrayList<Location>();

		
		//----- INTERVALS -----------------------
		setSheepGiveInterval(config.getSheepGiveInterval());
		setDeathMatchGiveInterval(config.getDeathMatchGiveInterval());

		
		//----- SHEEPS ON -----------------------
		this.enabledSheeps = new ArrayList<Sheep>();

		
		//----- SPAWNS --------------------------
		this.lobby = null;
		this.specSpawn = null;
		this.redSpawns = new ArrayList<Spawn>();
		this.blueSpawns = new ArrayList<Spawn>();
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

	public Spawn getSpecSpawn() {
		return specSpawn;
	}

	public ArrayList<Spawn> getRedSpawns() {
		return redSpawns;
	}

	public ArrayList<Spawn> getBlueSpawns() {
		return blueSpawns;
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
	}

	public void getSpecSpawn(Spawn specSpawn) {
		this.specSpawn = specSpawn;
	}
}
