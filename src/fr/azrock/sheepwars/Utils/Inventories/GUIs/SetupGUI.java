package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import org.bukkit.Material;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;
import net.md_5.bungee.api.ChatColor;

public class SetupGUI extends AInventory {

	public SetupGUI() {
		super(45, "Game Setup");
		
		
		setItem(11, new ItemBuilder(ChatColor.YELLOW+"Players", 1, Material.PLAYER_HEAD).build(), 
				(player, click) -> {
					player.closeInventory();
					SheepWars.get().getInventoryManager().getPlayerSetupInv().open(player);
				});
		
		setItem(13, new ItemBuilder(ChatColor.YELLOW+"Timers", 1, Material.CLOCK).build(), 
				(player, click) -> {
					player.closeInventory();
					SheepWars.get().getInventoryManager().getTimerSetupInv().open(player);
				});
		
		setItem(15, new ItemBuilder(ChatColor.YELLOW+"Spawns", 1, Material.COMPASS).build(), 
				(player, click) -> {
					player.closeInventory();
					SheepWars.get().getInventoryManager().getSpawnSetupInv().open(player);
				});
		
		setItem(29, new ItemBuilder(ChatColor.YELLOW+"Sheeps", 1, Material.SHEEP_SPAWN_EGG).build(), 
				(player, click) -> {
					player.closeInventory();
					SheepWars.get().getInventoryManager().getSheepsInv().open(player);
				});
		
		setItem(31, new ItemBuilder(ChatColor.YELLOW+"Bonus", 1, Material.WHITE_WOOL).build(), 
				(player, click) -> {
					player.closeInventory();
					SheepWars.get().getInventoryManager().getBonusInv().open(player);
				});
		
		setItem(33, new ItemBuilder(ChatColor.YELLOW+"Map Region", 1, Material.STICK).build(), 
				(player, click) -> {
					// Switch to cuboid selection mode
				});
		
		
		
		
		for(int i=0; i<9; i++) {
			setItem(i, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+36, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		}
		
		for(int i=9; i<=27; i+=9) {
			setItem(i, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+1, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+7, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
			setItem(i+8, new ItemBuilder(" ", 1, Material.GRAY_STAINED_GLASS_PANE).build());
		}
	}
	

}
