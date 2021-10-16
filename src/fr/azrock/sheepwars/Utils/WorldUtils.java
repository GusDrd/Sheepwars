package fr.azrock.sheepwars.Utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import fr.azrock.sheepwars.SheepWars;

public class WorldUtils {
	
	public static void setToNight(SheepWars plugin) {

		final long nightTime = 18000;
		final World world = Bukkit.getWorld("world");

		
		if(world.getTime() == nightTime) 
			return;


		new BukkitRunnable() {

			long dayTime = 6000;
			
			@Override
			public void run() {

				dayTime += 400;

				world.setTime(dayTime);

				if(world.getTime() == nightTime) {
					this.cancel();
				}
			}

		}.runTaskTimer(plugin, 0L, 2L);
	}

	
	
	public static void setToDay(SheepWars plugin) {
		
		final long dayTime = 6000;
		final World world = Bukkit.getWorld("world");

		
		if(world.getTime() == dayTime) 
			return;


		new BukkitRunnable() {

			long nightTime = 18000;
			
			@Override
			public void run() {

				nightTime -= 400;

				world.setTime(nightTime);

				if(world.getTime() == dayTime) {
					this.cancel();
				}
			}

		}.runTaskTimer(plugin, 0L, 2L);
		
	}
	
}
