package fr.azrock.sheepwars.Utils.SetupMode;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.Spawn;
import net.md_5.bungee.api.ChatColor;

public class ModeListeners implements Listener {


	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Mode mode = SheepWars.get().getSetupMode();

		if(mode.isEnabled()) {
			if(event.getPlayer().getName().equals(mode.getPlayer().getName())) {
				
				event.setCancelled(true);

				if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {

					Spawn spawn = new Spawn(event.getPlayer().getLocation());

					switch(mode.getMode()) {

					//-----------------------
					case LOBBY:
						
						SheepWars.get().getGame().setLobby(spawn);
						event.getPlayer().sendMessage(ChatColor.GREEN+"The lobby has successfuly been saved!");
						mode.leave();

						break;

						//-----------------------
					case SPEC_LOBBY:

						SheepWars.get().getGame().setSpecLobby(spawn);
						event.getPlayer().sendMessage(ChatColor.GREEN+"The spectator lobby has successfuly been saved!");
						mode.leave();

						break;

						//-----------------------
					case BLUE_SPAWNS:

						int current = SheepWars.get().getGame().getBlueSpawns().size();
						int min = (int)Math.ceil(SheepWars.get().getGame().getMaxPlayers()/2.0);
						
						SheepWars.get().getGame().addBlueSpawn(spawn);
						
						current++;
						int v = min-current;
						
						event.getPlayer().sendMessage(ChatColor.YELLOW+"You have set a new spawnpoint for the "+ChatColor.BLUE+"blue team"+ChatColor.YELLOW+" !");
						event.getPlayer().sendMessage(ChatColor.YELLOW+"You need "+ChatColor.BLUE+v+ChatColor.YELLOW+" more spawns !");

						break;

						//-----------------------
					case RED_SPAWNS:
						
						current = SheepWars.get().getGame().getRedSpawns().size();
						min = (int)Math.ceil(SheepWars.get().getGame().getMaxPlayers()/2.0);
						
						SheepWars.get().getGame().addRedSpawn(spawn);
						
						current++;
						int vR = min-current;
						
						event.getPlayer().sendMessage(ChatColor.YELLOW+"You have set a new spawnpoint for the "+ChatColor.RED+"red team"+ChatColor.YELLOW+" !");
						event.getPlayer().sendMessage(ChatColor.YELLOW+"You need "+ChatColor.RED+vR+ChatColor.YELLOW+" more spawns !");

						break;

						//-----------------------
					case BONUS:

						break;

					}

				}

			}
		}

	}


	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Mode mode = SheepWars.get().getSetupMode();

		if(mode.isEnabled()) {
			if(event.getPlayer().getName().equals(mode.getPlayer().getName())) {
				
				if(mode.getMode() == SetupMode.RED_SPAWNS) {
					SheepWars.get().getGame().saveRedSpawn();
				}else if(mode.getMode() == SetupMode.BLUE_SPAWNS) {
					SheepWars.get().getGame().saveBlueSpawns();
				}else {
					mode.leave();
				}
				
				event.getPlayer().sendMessage(ChatColor.GREEN+"The lobbies have successfuly been saved!");
				mode.leave();
				return;
			}
		}
	}


}