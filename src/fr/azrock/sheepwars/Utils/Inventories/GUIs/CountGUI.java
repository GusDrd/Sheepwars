package fr.azrock.sheepwars.Utils.Inventories.GUIs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;

import fr.azrock.sheepwars.Utils.ItemBuilder;
import fr.azrock.sheepwars.Utils.Inventories.AInventory;

public class CountGUI extends AInventory {

	private int var;
	
	
	public CountGUI(String name, int var) {
		super(9, name);
		
		this.var = var;
		
		
		setItem(11, 
				new ItemBuilder(ChatColor.RED+"-1", 1, Material.RED_STAINED_GLASS_PANE, "").build(), 
				(player, click) -> {
					if(this.var > 0) this.var -= 1;
		});
		
		
		setItem(13, 
				new ItemBuilder(ChatColor.YELLOW+""+var, 1, Material.WHITE_TERRACOTTA, ChatColor.GRAY+"[Left-Click] Save changes.", ChatColor.GRAY+"[Right-Click] Discard changes.").build(), 
				(player, click) -> {
					
            if(click == ClickType.RIGHT) {
            	
            	
            	
            }else if(click == ClickType.LEFT) {
            	
            	
            	
            }
		});
		
		
		setItem(15, 
				new ItemBuilder(ChatColor.GREEN+"+1", 1, Material.GREEN_STAINED_GLASS_PANE, "").build(), 
				(player, click) -> {
					if(this.var <= 3600) this.var += 1;
		});
	}

}
