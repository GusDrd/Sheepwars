package fr.azrock.sheepwars.Utils.Inventories.AbstractGUI;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public interface AAction {
	void onClick(Player player, ClickType click);
}
