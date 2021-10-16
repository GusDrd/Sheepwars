package fr.azrock.sheepwars.Utils;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class AreaShape {
	
	public static Set<Location> getSquaredArea(Location location, int around){
		Set<Block> blocks = getSquaredAreaBlocks(location, around);
		Set<Location> locations = new HashSet<Location>();
		
		for(Block b : blocks) {
			locations.add(b.getLocation());
		}
		
		return locations;
	}
	
	
	
	public static Set<Block> getSquaredAreaBlocks(Location location, int around){
		location = location.getBlock().getLocation();
		Set<Block> blocks = new HashSet<Block>();
		for(int x = -around; x <= around; x++) {
			for(int y = -around; y <= around; y++) {
				for(int z = -around; z <= around; z++) {
					blocks.add(location.add(x, y, z).getBlock());
					location.subtract(x, y, z);
				}
			}
		}
		return blocks;
	}

}
