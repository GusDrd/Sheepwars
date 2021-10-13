package fr.azrock.sheepwars.Common.Tasks;

import org.bukkit.scheduler.BukkitRunnable;

import fr.azrock.sheepwars.Common.Game;

public class DeathmatchTask extends BukkitRunnable {

	
	private int TIME, seconds, storedTime;


	public DeathmatchTask(Game game) {
		TIME = game.getDeathMatchTime();

		seconds = TIME;
		storedTime = -1;
	}

	@Override
	public void run() {

	}

}
