package fr.azrock.sheepwars.Utils.Inventories;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class AInventory {

	private UUID invID;
	private Inventory inventory;
	
	private Map<Integer, AAction> actions;
	
	//Static variables to have only 1 instance inside this class and not an instance by child class.
	private static Map<UUID, AInventory> inventoryMap = new HashMap<UUID, AInventory>();
	private static Map<UUID, UUID> inventories = new HashMap<UUID, UUID>();
	
	
	
	public AInventory(int slots, String name) {
		
		invID = UUID.randomUUID();
		inventory = Bukkit.createInventory(null, slots, name);
		
		actions = new HashMap<Integer, AAction>();
		
		inventoryMap.put(invID, this);
	}
	
	
	
	/* ---------------------
	 *  UTILITY Methods
	 * -------------------------- */
	public void open(Player player) {
		player.openInventory(inventory);
		inventories.put(player.getUniqueId(), invID);
	}
	
	public void delete(Player player) {
		player.closeInventory();
		inventoryMap.remove(invID);
	}
	
	
	
	/* ---------------------
	 *  ITEMS Setters
	 * -------------------------- */
	public void setItem(int slot, ItemStack item, AAction action) {
		inventory.setItem(slot, item);
		
		if(action != null) 
			actions.put(slot, action);
	}
	
	public void setItem(int slot, ItemStack item) {
		setItem(slot, item, null);
	}
	
	
	
	/* ---------------------
	 *  INVENTORY Getters
	 * -------------------------- */
	public UUID getID() {
		return invID;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	
	
	/* ---------------------
	 *  MAPS Getters
	 * -------------------------- */
	public static Map<UUID, AInventory> getInventoryMap() {
		return inventoryMap;
	}
	
	public static Map<UUID, UUID> getInventories() {
		return inventories;
	}
	
	public Map<Integer, AAction> getActions() {
		return actions;
	}
}
