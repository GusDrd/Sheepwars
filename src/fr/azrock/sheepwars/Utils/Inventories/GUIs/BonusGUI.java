package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;

public class BonusGUI extends AInventory {

	public BonusGUI() {
		super(45, "Bonus Setup");
		
		
		//Loop through existing bonus classes and automatically show them up. Generalise click to enable or disable.
		
		
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
		
		
		setItem(36, new ItemBuilder(ChatColor.YELLOW+"Save & Return", 1, Material.ARROW, 
				Arrays.asList(" ", ChatColor.GRAY+"Save the current", ChatColor.GRAY+"selection and return", ChatColor.GRAY+"to the previous menu.")).build(), 
				(player, click) -> {

					//Save Values.

					player.closeInventory();
					SheepWars.get().getInventoryManager().getSetupInventory().open(player);
				});
		
		
		setItem(40, new ItemBuilder(ChatColor.YELLOW+"Bonus Locations", 1, Material.COMPASS, 
				Arrays.asList(" ", ChatColor.GRAY+"Click to setup", ChatColor.GRAY+"the possible bonus", ChatColor.GRAY+"spawn locations.")).build(), 
				(player, click) -> {
					// Enter Setup mode for bonus locations.
				});
	}

}
