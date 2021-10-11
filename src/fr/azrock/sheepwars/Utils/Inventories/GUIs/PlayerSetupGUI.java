package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;

public class PlayerSetupGUI extends AInventory {

	private int minPlayers;
	private int reducePlayers;
	private int maxPlayers;
	
	
	public PlayerSetupGUI() {
		super(27, "Players Setup");
		
		
		minPlayers = SheepWars.get().getGame().getMinPlayers();
		reducePlayers = SheepWars.get().getGame().getPlayersToReduce();
		maxPlayers = SheepWars.get().getGame().getMaxPlayers();

		
		setItem(11, new ItemBuilder(ChatColor.YELLOW+"Min. Players: "+ChatColor.AQUA+minPlayers, 1, Material.LIME_TERRACOTTA, 
				Arrays.asList(" ", ChatColor.GRAY+"Define the minimum number", ChatColor.GRAY+"of players required to", ChatColor.GRAY+"start the waiting timer.", " ", 
						ChatColor.GRAY+"[LEFT-CLICK]  -1", ChatColor.GRAY+"[RIGHT-CLICK]  +1")).build(), 
				(player, click) -> {

					if(click == ClickType.LEFT) {	
						if(minPlayers == 2) return;
						
						minPlayers--;
					}else if(click == ClickType.RIGHT) {
						if(minPlayers == maxPlayers-1) return;
						
						minPlayers++;
					}else {
						return;
					}
					
					setItem(11, new ItemBuilder(ChatColor.YELLOW+"Min. Players: "+ChatColor.AQUA+minPlayers, 1, Material.LIME_TERRACOTTA, 
							Arrays.asList(" ", ChatColor.GRAY+"Define the minimum number", ChatColor.GRAY+"of players required to", ChatColor.GRAY+"start the waiting timer.", " ", 
									ChatColor.GRAY+"[LEFT-CLICK]  -1", ChatColor.GRAY+"[RIGHT-CLICK]  +1")).build());

				});

		setItem(13, new ItemBuilder(ChatColor.YELLOW+"Timer Players: "+ChatColor.AQUA+reducePlayers, 1, Material.CLOCK, 
				Arrays.asList(" ", ChatColor.GRAY+"Define the number of", ChatColor.GRAY+"players required to reduce", ChatColor.GRAY+"the timer to 25% of time.", " ", 
						ChatColor.GRAY+"[LEFT-CLICK]  -1", ChatColor.GRAY+"[RIGHT-CLICK]  +1", " ", ChatColor.GRAY+"Please do mind that this", ChatColor.GRAY+"value should NOT be smaller", ChatColor.GRAY+"than Min. Players.")).build(), 
				(player, click) -> {

					if(click == ClickType.LEFT) {
						reducePlayers--;
					}else if(click == ClickType.RIGHT) {
						reducePlayers++;
					}else {
						return;
					}
					
					setItem(13, new ItemBuilder(ChatColor.YELLOW+"Timer Players: "+ChatColor.AQUA+reducePlayers, 1, Material.CLOCK, 
							Arrays.asList(" ", ChatColor.GRAY+"Define the number of", ChatColor.GRAY+"players required to reduce", ChatColor.GRAY+"the timer to 25% of time.", " ", 
									ChatColor.GRAY+"[LEFT-CLICK]  -1", ChatColor.GRAY+"[RIGHT-CLICK]  +1")).build());

				});

		setItem(15, new ItemBuilder(ChatColor.YELLOW+"Max. Players: "+ChatColor.AQUA+maxPlayers, 1, Material.RED_TERRACOTTA, 
				Arrays.asList(" ", ChatColor.GRAY+"Define the minimum number", ChatColor.GRAY+"of players required to", ChatColor.GRAY+"start a game of sheepwars.", " ", 
						ChatColor.GRAY+"[LEFT-CLICK]  -1", ChatColor.GRAY+"[RIGHT-CLICK]  +1")).build(), 
				(player, click) -> {

					if(click == ClickType.LEFT) {
						if(maxPlayers == minPlayers+1) return;
						
						maxPlayers--;
					}else if(click == ClickType.RIGHT) {
						if(maxPlayers == 100) return;
						
						maxPlayers++;
					}else {
						return;
					}
					
					setItem(15, new ItemBuilder(ChatColor.YELLOW+"Max. Players: "+ChatColor.AQUA+maxPlayers, 1, Material.RED_TERRACOTTA, 
							Arrays.asList(" ", ChatColor.GRAY+"Define the minimum number", ChatColor.GRAY+"of players required to", ChatColor.GRAY+"start a game of sheepwars.", " ", 
									ChatColor.GRAY+"[LEFT-CLICK]  -1", ChatColor.GRAY+"[RIGHT-CLICK]  +1")).build());
					
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

					SheepWars.get().getGame().setMinPlayers(minPlayers);
					SheepWars.get().getGame().setPlayersToReduce(reducePlayers);
					SheepWars.get().getGame().setMaxPlayers(maxPlayers);
					
					player.closeInventory();
					SheepWars.get().getInventoryManager().getSetupInventory().open(player);
				});
	}

}
