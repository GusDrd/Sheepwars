package fr.azrock.sheepwars.Common.Tasks;

import org.bukkit.scheduler.BukkitRunnable;

import fr.azrock.sheepwars.Common.Game;

public class GameTask extends BukkitRunnable {

	
	private int TIME, seconds, storedTime;


	public GameTask(Game game) {
		TIME = game.getGameTime();

		seconds = TIME;
		storedTime = -1;
	}


	@Override
	public void run() {

	}

}
