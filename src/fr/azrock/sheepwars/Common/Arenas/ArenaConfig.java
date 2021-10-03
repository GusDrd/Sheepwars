package fr.azrock.sheepwars.Common.Arenas;

import org.bukkit.plugin.Plugin;

import fr.azrock.sheepwars.Config.AConfig;

public class ArenaConfig extends AConfig {

	private final String PATH = "arena.";


	public ArenaConfig(Plugin plugin) {
		super("arena", plugin);
	}


	public void addArena(Arena arena) {

	}

	public void removeArena(String name) {
		this.setPath(PATH+name, null);
	}

}
