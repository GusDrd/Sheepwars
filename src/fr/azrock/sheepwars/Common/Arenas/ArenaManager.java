package fr.azrock.sheepwars.Common.Arenas;

import java.util.ArrayList;

import fr.azrock.sheepwars.SheepWars;

public class ArenaManager {

	public SheepWars plugin;
	public ArenaConfig config;
	
	public ArrayList<Arena> arenaList;
	
	//-----------------------------------------------
	
	
	public ArenaManager(SheepWars plugin) {
		this.plugin = plugin;
		this.config = (ArenaConfig)plugin.getConfigManager().getConfigByName("arena");
		
		this.arenaList = new ArrayList<Arena>();
		
	}
	
	
	
	//-----------------------------------------------
	public boolean addArena(String name) {
		if(arenaExists(name))
			return false;
		
		Arena arena = new Arena(name);
		
		arenaList.add(arena);
		config.addArena(arena);
		
		return true;
	}
	
	
	//-----------------------------------------------
	public boolean removeArena(String name) {
		if(!arenaExists(name))
			return false;
		
		arenaList.remove(getArena(name));
		config.removeArena(name);
		
		return true;
	}
	
	
	//-----------------------------------------------
	public Arena getArena(String name) {
		for(Arena arena : arenaList) {
			if(arena.getName().equalsIgnoreCase(name))
				return arena;
		}
		return null;
	}
	
	
	//-----------------------------------------------
	public boolean arenaExists(String name) {
		return getArena(name) != null;
	}
	
	//-----------------------------------------------
}
