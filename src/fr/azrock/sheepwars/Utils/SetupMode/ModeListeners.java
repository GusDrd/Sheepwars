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

						break;

						//-----------------------
					case RED_SPAWNS:

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
				mode.leave();
			}
		}
	}


}