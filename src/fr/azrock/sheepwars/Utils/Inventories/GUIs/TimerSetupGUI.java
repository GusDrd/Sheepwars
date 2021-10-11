package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;

public class TimerSetupGUI extends AInventory {

	private int waitTime;
	private int gameTime;
	private int deathTime;
	
	
	public TimerSetupGUI() {
		super(27, "Timers Setup");
		
		
		waitTime = SheepWars.get().getGame().getWaitingTime();
		gameTime = SheepWars.get().getGame().getGameTime();
		deathTime = SheepWars.get().getGame().getDeathMatchTime();
		
		
		setItem(11, new ItemBuilder(ChatColor.YELLOW+"Waiting Time: "+ChatColor.AQUA+waitTime, 1, Material.LIGHT_BLUE_TERRACOTTA, 
				Arrays.asList(" ", ChatColor.GRAY+"Define how long players will", ChatColor.GRAY+"wait before a game starts.", " ", 
						ChatColor.GRAY+"[LEFT-CLICK]  -5s", ChatColor.GRAY+"[RIGHT-CLICK]  +5s")).build(), 
				(player, click) -> {

					if(click == ClickType.LEFT) {
						waitTime -= 5;
					}else if(click == ClickType.RIGHT) {
						waitTime += 5;
					}else {
						return;
					}
					
					setItem(11, new ItemBuilder(ChatColor.YELLOW+"Waiting Time: "+ChatColor.AQUA+waitTime, 1, Material.LIGHT_BLUE_TERRACOTTA, 
							Arrays.asList(" ", ChatColor.GRAY+"Define how long players will", ChatColor.GRAY+"wait before a game starts.", " ", 
									ChatColor.GRAY+"[LEFT-CLICK]  -5s", ChatColor.GRAY+"[RIGHT-CLICK]  +5s")).build());

				});

		setItem(13, new ItemBuilder(ChatColor.YELLOW+"Game Time: "+ChatColor.AQUA+gameTime, 1, Material.YELLOW_TERRACOTTA, 
				Arrays.asList(" ", ChatColor.GRAY+"Define how long a game", ChatColor.GRAY+"of sheepwars will last.", " ", 
						ChatColor.GRAY+"[LEFT-CLICK]  -30s", ChatColor.GRAY+"[RIGHT-CLICK]  +30s")).build(), 
				(player, click) -> {

					if(click == ClickType.LEFT) {
						gameTime -= 30;
					}else if(click == ClickType.RIGHT) {
						gameTime += 30;
					}else {
						return;
					}
					
					setItem(13, new ItemBuilder(ChatColor.YELLOW+"Game Time: "+ChatColor.AQUA+gameTime, 1, Material.YELLOW_TERRACOTTA, 
							Arrays.asList(" ", ChatColor.GRAY+"Define how long a game", ChatColor.GRAY+"of sheepwars will last.", " ", 
									ChatColor.GRAY+"[LEFT-CLICK]  -30s", ChatColor.GRAY+"[RIGHT-CLICK]  +30s")).build());

				});

		setItem(15, new ItemBuilder(ChatColor.YELLOW+"Deathmatch Time: "+ChatColor.AQUA+deathTime, 1, Material.COAL_BLOCK, 
				Arrays.asList(" ", ChatColor.GRAY+"Define how long the", ChatColor.GRAY+"deathmatch will last.", " ", 
						ChatColor.GRAY+"[LEFT-CLICK]  -30s", ChatColor.GRAY+"[RIGHT-CLICK]  +30s")).build(), 
				(player, click) -> {

					if(click == ClickType.LEFT) {
						deathTime -= 30;
					}else if(click == ClickType.RIGHT) {
						deathTime += 30;
					}else {
						return;
					}
					
					setItem(15, new ItemBuilder(ChatColor.YELLOW+"Deathmatch Time: "+ChatColor.AQUA+deathTime, 1, Material.COAL_BLOCK, 
							Arrays.asList(" ", ChatColor.GRAY+"Define how long the", ChatColor.GRAY+"deathmatch will last.", " ", 
									ChatColor.GRAY+"[LEFT-CLICK]  -30s", ChatColor.GRAY+"[RIGHT-CLICK]  +30s")).build());
					
				});



		for(int i=0; i<9; i++) {
			setItem(i, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+18, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		}
		
		setItem(9, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(17, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(10, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(16, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());



		setItem(18, new ItemBuilder(ChatColor.YELLOW+"Save & Return", 1, Material.ARROW, 
				Arrays.asList(" ", ChatColor.GRAY+"Save the current", ChatColor.GRAY+"values and return", ChatColor.GRAY+"to the previous menu.")).build(), 
				(player, click) -> {

					SheepWars.get().getGame().setWaitingTime(waitTime);
					SheepWars.get().getGame().setGameTime(gameTime);
					SheepWars.get().getGame().setDeathMatchTime(deathTime);

					player.closeInventory();
					SheepWars.get().getInventoryManager().getSetupInventory().open(player);
				});
	}

}
