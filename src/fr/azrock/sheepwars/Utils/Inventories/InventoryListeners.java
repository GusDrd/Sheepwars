package fr.azrock.sheepwars.Utils.Inventories;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class InventoryListeners implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if(!(event.getWhoClicked() instanceof Player)) return;
		
		
		Player player = (Player)event.getWhoClicked();
		
		UUID invID = AInventory.getInventories().get(player.getUniqueId());
		
		if(invID != null) {
			
			event.setCancelled(true);
		
			AAction action = AInventory.getInventoryMap().get(invID).getActions().get(event.getSlot());
			
			if(action != null) {
				action.onClick(player, event.getClick());
			}
			
			
			
		}
	}
	
	
	@EventHandler
	public void onClose(InventoryCloseEvent event) {
		if(AInventory.getInventories().containsKey(event.getPlayer().getUniqueId()))
			AInventory.getInventories().remove(event.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(AInventory.getInventories().containsKey(event.getPlayer().getUniqueId()))
			AInventory.getInventories().remove(event.getPlayer().getUniqueId());
	}
	
}
