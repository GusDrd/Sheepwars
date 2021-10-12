package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;
import fr.azrock.sheepwars.Utils.SetupMode.SetupMode;

public class SpawnSetupGUI extends AInventory {

	public SpawnSetupGUI() {
		super(27, "Spawns Setup");
		
		
		setItem(11, new ItemBuilder(ChatColor.YELLOW+"Lobby", 1, Material.ENDER_PEARL, 
				Arrays.asList(" ", ChatColor.GRAY+"Click to setup", ChatColor.GRAY+"the lobby spawnpoint.")).build(), 
				(player, click) -> {

					if(SheepWars.get().getSetupMode().enter(player, SetupMode.LOBBY)) {
						player.sendMessage(ChatColor.RED+"Another player is already setting up the spawn locations!");
						player.closeInventory();
					}
				});

		setItem(12, new ItemBuilder(ChatColor.YELLOW+"Spectator Lobby", 1, Material.ENDER_EYE, 
				Arrays.asList(" ", ChatColor.GRAY+"Click to setup", ChatColor.GRAY+"the spectator spawnpoint.")).build(), 
				(player, click) -> {

					if(!SheepWars.get().getSetupMode().enter(player, SetupMode.SPEC_LOBBY)) {
						player.sendMessage(ChatColor.RED+"Another player is already setting up the spawn locations!");
						player.closeInventory();
					}
				});
		
		setItem(14, new ItemBuilder(ChatColor.RED+"Red Spawns", 1, Material.RED_WOOL, 
				Arrays.asList(" ", ChatColor.GRAY+"Click to setup", ChatColor.GRAY+"the red team's", ChatColor.GRAY+"game spawnpoints.")).build(), 
				(player, click) -> {

					if(!SheepWars.get().getSetupMode().enter(player, SetupMode.RED_SPAWNS)) {
						player.sendMessage(ChatColor.RED+"Another player is already setting up the spawn locations!");
						player.closeInventory();
					}

				});

		setItem(15, new ItemBuilder(ChatColor.BLUE+"Blue Spawns", 1, Material.BLUE_WOOL, 
				Arrays.asList(" ", ChatColor.GRAY+"Click to setup", ChatColor.GRAY+"the blue team's", ChatColor.GRAY+"game spawnpoints.")).build(), 
				(player, click) -> {
					
					if(!SheepWars.get().getSetupMode().enter(player, SetupMode.BLUE_SPAWNS)) {
						player.sendMessage(ChatColor.RED+"Another player is already setting up the spawn locations!");
						player.closeInventory();
					}
					
				});



		for(int i=0; i<9; i++) {
			setItem(i, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+18, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		}

		setItem(9, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(17, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(10, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(16, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());


		setItem(18, new ItemBuilder(ChatColor.YELLOW+"Return", 1, Material.ARROW, 
				Arrays.asList(" ", ChatColor.GRAY+"Click to return", ChatColor.GRAY+"to the previous menu")).build(), 
				(player, click) -> {
					player.closeInventory();
					SheepWars.get().getInventoryManager().getSetupInventory().open(player);
				});
	}

}
