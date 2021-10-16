package fr.azrock.sheepwars.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

import fr.azrock.sheepwars.Common.Sheeps.SheepListeners;
import fr.azrock.sheepwars.Utils.Inventories.InventoryListeners;
import fr.azrock.sheepwars.Utils.SetupMode.ModeListeners;

public class EventManager implements Listener {

	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		ConnectionListeners.onLogin(event);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		ConnectionListeners.onJoin(event);
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		ConnectionListeners.onQuit(event);
		InventoryListeners.onQuit(event);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		SheepListeners.onInteract(event);
		ModeListeners.onInteract(event);
	}
	
	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent event) {
		ModeListeners.onDrop(event);
		CommonListeners.onItemDrop(event);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		InventoryListeners.onClick(event);
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		InventoryListeners.onClose(event);
	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent event) {
		CommonListeners.onFoodChange(event);
	}
	
	@EventHandler
	public void onItemDamage(PlayerItemDamageEvent event) {
		CommonListeners.onItemDamage(event);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		CommonListeners.onBlockPlace(event);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		CommonListeners.onBlockBreak(event);
	}
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		CommonListeners.onEntitySpawn(event);
	}
	
	@EventHandler
	public void onVehicleExit(VehicleExitEvent event) {
		CommonListeners.onExit(event);
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		SheepListeners.onEntityDeath(event);
	}
	
}
