package fr.azrock.sheepwars.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Serializer {

	public static String serializeLoc(Location loc) {
		if(loc == null)
			return " ";
		
		StringBuilder sb = new StringBuilder();
		sb.append(loc.getWorld().getName()); sb.append('%');
		sb.append(String.valueOf(loc.getX())); sb.append('%');
		sb.append(String.valueOf(loc.getY())); sb.append('%');
		sb.append(String.valueOf(loc.getZ()));
		
		return sb.toString();
	}
	
	public static Location deserializeLoc(String loc) {
		if(loc == null || loc.isEmpty())
			return null;
		
		String[] list = loc.split("%");
		
		return new Location(Bukkit.getWorld(list[0]), Double.valueOf(list[1]), Double.valueOf(list[2]), Double.valueOf(list[3]));
	}
	
	
	
	public static String serializePos(Location loc) {
		if(loc == null)
			return " ";
		
		StringBuilder sb = new StringBuilder();
		sb.append(loc.getWorld().getName()); sb.append('%');
		sb.append(String.valueOf(loc.getX())); sb.append('%');
		sb.append(String.valueOf(loc.getY())); sb.append('%');
		sb.append(String.valueOf(loc.getZ())); sb.append('%');
		sb.append(String.valueOf(loc.getYaw())); sb.append('%');
		sb.append(String.valueOf(loc.getPitch()));
		
		return sb.toString();
	}
	
	
	public static Location deserializePos(String loc) {
		if(loc == null || loc.isEmpty())
			return null;
		
		String[] list = loc.split("%");
		
		return new Location(Bukkit.getWorld(list[0]), Double.valueOf(list[1]), Double.valueOf(list[2]), Double.valueOf(list[3]), Float.valueOf(list[4]), Float.valueOf(list[5]));
	}
	
}
