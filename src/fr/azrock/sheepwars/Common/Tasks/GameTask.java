package fr.azrock.sheepwars.Common.Tasks;

import org.bukkit.scheduler.BukkitRunnable;

import fr.azrock.sheepwars.Common.Game.Game;

public class GameTask extends BukkitRunnable {

	
	private int TIME, seconds;


	public GameTask(Game game) {
		TIME = game.getGameTime();

		seconds = TIME;
	}


	
	@Override
	public void run() {

	}
	
	
	
	public int getTime() {
		return seconds;
	}
}
