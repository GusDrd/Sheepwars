package fr.azrock.sheepwars.Common.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.azrock.sheepwars.Common.Game;

public class WaitingTask extends BukkitRunnable {

	
	private int TIME, REDUCE_TIME, seconds, storedTime;
	
	private Game game;
		
	
	public WaitingTask(Game game) {
		this.game = game;
		
		TIME = this.game.getWaitingTime();
		REDUCE_TIME = (int)Math.ceil(TIME/2.0);
		
		seconds = TIME;
		storedTime = -1;
	}
	
	
	@Override
	public void run() {
		
		if(seconds > 0) {
			seconds--;
			
			for(Player player : Bukkit.getOnlinePlayers()) {
				player.setLevel(seconds);
				player.setExp(((float)seconds/180f));
			}
			
			if(seconds == 60) {
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.sendTitle("Message", "", 10, 20, 10);
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10f, 0.1f);
				}
			}else if(seconds == 30) {
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.sendTitle("Message", "", 10, 20, 10);
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10f, 0.1f);
				}
			}else if (seconds <= 10) {
				for(Player player : Bukkit.getOnlinePlayers()) {
					
					if(seconds>=7) {
						player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10f, 0.1f);
					}else if(seconds >=4) {
						player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10f, 1f);
					}else {
						player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10f, 2f);
					}
					player.sendTitle("Message", "", 10, 20, 10);
				}
			}
			
		}else {
			stop();
			Bukkit.broadcastMessage("�aStart Game");
		}
		
	}
	
	
	public void stop() {
		cancel();
		reset();
	}
	
	public void reset() {
		seconds = TIME;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setLevel(seconds);
			p.setExp((float)seconds/180f);
		}
	}
	
	public void reduce() {
		if(seconds <= REDUCE_TIME) return;
		
		storedTime = seconds;
		seconds = REDUCE_TIME;
	}
	
	public void setBack() {
		if(storedTime == -1)
			seconds = TIME;
		else
			seconds = storedTime;
		
		storedTime = -1;
	}

}
