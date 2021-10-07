package fr.azrock.sheepwars.Utils.SetupMode;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Utils.Spawn;

public class ModeListeners implements Listener {


	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Mode mode = SheepWars.get().getSetupMode();

		if(mode.isEnabled()) {
			if(event.getPlayer().getName().equals(mode.getPlayer().getName())) {

				if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) {

					Spawn spawn = new Spawn(event.getPlayer().getLocation());
					
					switch(mode.getMode()) {
					
					//-----------------------
					case LOBBY:
						
						// SAVE TO LOBBY CONFIG
						mode.leave();
						
						break;
					
						//-----------------------
					case SPEC_LOBBY:
						
						// SAVE TO SPEC_LOBBY CONFIG
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


}