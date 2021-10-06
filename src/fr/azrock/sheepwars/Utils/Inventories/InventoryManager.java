package fr.azrock.sheepwars.Utils.Inventories;

import fr.azrock.sheepwars.Utils.Inventories.GUIs.SetupGUI;

public class InventoryManager {

	
	private SetupGUI setupInventory;
	
	
	
	public InventoryManager() {
		setupInventory = new SetupGUI();
	}
	
	
	public SetupGUI getSetupInventory() {
		return setupInventory;
	}
	
}
