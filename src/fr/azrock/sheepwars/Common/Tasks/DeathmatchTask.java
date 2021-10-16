package fr.azrock.sheepwars.Common.Tasks;

import org.bukkit.scheduler.BukkitRunnable;

import fr.azrock.sheepwars.Common.Game.Game;

public class DeathmatchTask extends BukkitRunnable {

	
	private int TIME, seconds;


	public DeathmatchTask(Game game) {
		TIME = game.getDeathMatchTime();

		seconds = TIME;
	}

	
	
	@Override
	public void run() {

	}
	
	
	
	public int getTime() {
		return seconds;
	}
}
