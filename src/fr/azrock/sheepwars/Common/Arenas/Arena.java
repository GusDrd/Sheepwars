package fr.azrock.sheepwars.Common.Arenas;

import java.util.ArrayList;

import org.bukkit.Location;

import fr.azrock.sheepwars.Common.Sheeps.Sheep;
import fr.azrock.sheepwars.Utils.Spawn;

public class Arena {

	private String name;

	private boolean open;

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



	public Arena(String name) {

		this.name = name;

		open(false);

		setMinPlayers(8);
		setMaxPlayers(14);
		setPlayersToReduce(10);

		setWaitingTime(120);
		setGameTime(600);
		setDeathMatchTime(300);

		setBonusSpawnInterval(60);
		this.bonusLocs = new ArrayList<Location>();

		setSheepGiveInterval(30);
		setDeathMatchGiveInterval(60);

		this.enabledSheeps = new ArrayList<Sheep>();

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

	public String getName() {
		return name;
	}

	public boolean isOpen() {
		return open;
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public void open(boolean open) {
		this.open = open;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public void setPlayersToReduce(int playersToReduce) {
		this.playersToReduce = playersToReduce;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	public void setDeathMatchTime(int deathMatchTime) {
		this.deathMatchTime = deathMatchTime;
	}

	public void setBonusSpawnInterval(int bonusSpawnInterval) {
		this.bonusSpawnInterval = bonusSpawnInterval;
	}

	public void setSheepGiveInterval(int sheepGiveInterval) {
		this.sheepGiveInterval = sheepGiveInterval;
	}

	public void setDeathMatchGiveInterval(int deathMatchGiveInterval) {
		this.deathMatchGiveInterval = deathMatchGiveInterval;
	}

	public void setLobby(Spawn lobby) {
		this.lobby = lobby;
	}

	public void getSpecSpawn(Spawn specSpawn) {
		this.specSpawn = specSpawn;
	}
}
