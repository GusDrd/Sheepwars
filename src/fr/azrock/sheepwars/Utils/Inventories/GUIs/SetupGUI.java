package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import org.bukkit.Material;

import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;
import net.md_5.bungee.api.ChatColor;

public class SetupGUI extends AInventory {

	public SetupGUI() {
		super(45, "Game Setup");
		
		
		setItem(11, new ItemBuilder(ChatColor.YELLOW+"Players", 1, Material.PLAYER_HEAD).build(), 
				(player, click) -> {
					// Open PlayersSetup Inventory
				});
		
		setItem(13, new ItemBuilder(ChatColor.YELLOW+"Timers", 1, Material.PLAYER_HEAD).build(), 
				(player, click) -> {
					// Open TimersSetup Inventory
				});
		
		setItem(15, new ItemBuilder(ChatColor.YELLOW+"Bonus", 1, Material.WHITE_WOOL).build(), 
				(player, click) -> {
					// Open BonusSetup Inventory
				});
		
		
		setItem(29, new ItemBuilder(ChatColor.YELLOW+"Sheeps", 1, Material.SHEEP_SPAWN_EGG).build(), 
				(player, click) -> {
					// Open Sheeps Inventory
				});
		
		setItem(31, new ItemBuilder(ChatColor.YELLOW+"Spawns", 1, Material.COMPASS).build(), 
				(player, click) -> {
					// Open SpawnSetup Inventory
				});
		
		setItem(33, new ItemBuilder(ChatColor.YELLOW+"Map Cuboid", 1, Material.STICK).build(), 
				(player, click) -> {
					// Switch to cuboid selection mode
				});
		
		
		
		
		for(int i=0; i<9; i++) {
			setItem(i, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+36, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		}
		
		setItem(9, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(17, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(18, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(26, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(27, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		setItem(35, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
	}
	

}
