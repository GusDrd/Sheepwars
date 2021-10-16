package fr.azrock.sheepwars.Common.Sheeps;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Enums.EnumSheep;
import fr.azrock.sheepwars.Common.Game.GameState;
import fr.azrock.sheepwars.Utils.WorldUtils;
import net.minecraft.server.v1_14_R1.Vec3D;

public class SheepListeners {

	
	public static void onInteract(PlayerInteractEvent event) {
		
		if(SheepWars.get().getGame().getGameState() == GameState.IN_GAME) {
			
			if((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.getItem() != null && event.getItem().getType().toString().contains("_WOOL")) {
				
				Player player = event.getPlayer();
				Vector vector = player.getLocation().getDirection().multiply(6);
				
				vector.setY(vector.getY() > 2.5 ? 2.5 : vector.getY());
				
				Sheep sheep = EnumSheep.summon(event.getMaterial(), player);
				
				if(sheep != null) {
					event.setCancelled(true);
					player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
					
					if(!sheep.isSupport())
						sheep.setMot(new Vec3D(vector.getX(), vector.getY(), vector.getZ()));
					
					
				}
				
			}
			
		}
	}
	
	
	
	public static void onEntityDeath(EntityDeathEvent event) {
		event.setDroppedExp(0);
		if(event.getDrops() != null)
			event.getDrops().clear();
		
		if(event.getEntity() == null)
			return;
		
		
		Player killer = event.getEntity().getKiller();
		if(killer != null && killer instanceof Player) {
			
			String type = event.getEntity().getMetadata("type").get(0).asString();
			World world = event.getEntity().getLocation().getWorld();
			
			if(type.equals(EnumSheep.BLIND.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.BLIND.getWoolItem());
			}else if(type.equals(EnumSheep.BOARDING.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.BOARDING.getWoolItem());
			}else if(type.equals(EnumSheep.DISTORTION.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.DISTORTION.getWoolItem());
			}else if(type.equals(EnumSheep.EARTHQUAKE.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.EARTHQUAKE.getWoolItem());
			}else if(type.equals(EnumSheep.EXPLOSIVE.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.EXPLOSIVE.getWoolItem());
			}else if(type.equals(EnumSheep.FRAGMENTATION.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.FRAGMENTATION.getWoolItem());
			}else if(type.equals(EnumSheep.FROZEN.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.FROZEN.getWoolItem());
			}else if(type.equals(EnumSheep.GALACTIC.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.GALACTIC.getWoolItem());
				WorldUtils.setToDay(SheepWars.get());
			}else if(type.equals(EnumSheep.GLOWING.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.GLOWING.getWoolItem());
			}else if(type.equals(EnumSheep.GLUTTON.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.GLUTTON.getWoolItem());
			}else if(type.equals(EnumSheep.HEALER.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.HEALER.getWoolItem());
			}else if(type.equals(EnumSheep.INCENDIARY.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.INCENDIARY.getWoolItem());
			}else if(type.equals(EnumSheep.LIGHTNING.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.LIGHTNING.getWoolItem());
				world.setThundering(false);
			}else if(type.equals(EnumSheep.STICKY.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.STICKY.getWoolItem());
			}else if(type.equals(EnumSheep.TRACKER.getName())) {
				world.dropItem(event.getEntity().getLocation(), EnumSheep.TRACKER.getWoolItem());
			}
			
		}
		
		
	}
	
	
}
