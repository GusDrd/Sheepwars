package fr.azrock.sheepwars.Utils.Inventories;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AAction;
import fr.azrock.sheepwars.Utils.Inventories.AbstractGUI.AInventory;

public class InventoryListeners {

	public static void onClick(InventoryClickEvent event) {
		
		if(!(event.getWhoClicked() instanceof Player)) return;
		
		
		Player player = (Player)event.getWhoClicked();
		
		UUID invID = AInventory.getInventories().get(player.getUniqueId());
		
		if(invID != null) {
			
			event.setCancelled(true);
		
			AAction action = AInventory.getInventoryMap().get(invID).getActions().get(event.getSlot());
			
			if(action != null)
				action.onClick(player, event.getClick());
			
		}
	}
	
	
	public static void onClose(InventoryCloseEvent event) {
		if(AInventory.getInventories().containsKey(event.getPlayer().getUniqueId()))
			AInventory.getInventories().remove(event.getPlayer().getUniqueId());
	}
	
	public static void onQuit(PlayerQuitEvent event) {
		if(AInventory.getInventories().containsKey(event.getPlayer().getUniqueId()))
			AInventory.getInventories().remove(event.getPlayer().getUniqueId());
	}
	
}
