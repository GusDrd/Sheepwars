package fr.azrock.sheepwars.Utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Spawn {

	private final Location loc;


	public Spawn(Location loc) {
		this.loc = loc;
	}

	public Location getLoc() {
		return this.loc;
	}


	public void send(Player player) {
		player.teleport(this.loc);
	}


	/**
	 * Parse a structured string into a spawn
	 */
	public static Spawn unserialize(String loc) {
		return new Spawn(Serializer.deserializePos(loc));
	}

	/**
	 * Format a spawn into a structured string
	 */
	public String serialize() {		
		return Serializer.serializePos(loc);
	}
	
}
