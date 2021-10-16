package fr.azrock.sheepwars.Listeners;

import org.bukkit.craftbukkit.v1_14_R1.entity.CraftSheep;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Game.GameState;

public class CommonListeners {

	
	
	public static void onFoodChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
	
	
	public static void onItemDamage(PlayerItemDamageEvent event) {
		event.setCancelled(true);
	}
	
	
	
	public static void onItemDrop(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
	
	
	
	public static void onBlockPlace(BlockPlaceEvent event) {
		event.setCancelled(true);
	}
	
	
	
	public static void onBlockBreak(BlockBreakEvent event) {
		if(SheepWars.get().getGame().getGameState() != GameState.IN_GAME)
			event.setCancelled(true);
	}
	
	
	
	public static void onEntitySpawn(EntitySpawnEvent event) {
		if(event.getEntity() instanceof Item) {
			Item itemEntity = (Item) event.getEntity();
			
			if (!itemEntity.getItemStack().getType().toString().endsWith("_WOOL"))
				event.setCancelled(true);
		}
	}
	
	
	
	public static void onExit(VehicleExitEvent event) {
		if(event.getExited() instanceof Player) {
			Player player = (Player)event.getExited();
			
			if(event.getVehicle() instanceof CraftSheep) {
				if(player.getLastDamageCause().getCause() == DamageCause.FALL)
					player.getLastDamageCause().setCancelled(true);
			}
		}
	}
}
