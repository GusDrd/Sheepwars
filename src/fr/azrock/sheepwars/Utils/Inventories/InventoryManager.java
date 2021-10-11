package fr.azrock.sheepwars.Utils.Inventories;

import fr.azrock.sheepwars.Utils.Inventories.GUIs.BonusGUI;
import fr.azrock.sheepwars.Utils.Inventories.GUIs.PlayerSetupGUI;
import fr.azrock.sheepwars.Utils.Inventories.GUIs.SetupGUI;
import fr.azrock.sheepwars.Utils.Inventories.GUIs.SheepsGUI;
import fr.azrock.sheepwars.Utils.Inventories.GUIs.SpawnSetupGUI;
import fr.azrock.sheepwars.Utils.Inventories.GUIs.TimerSetupGUI;

public class InventoryManager {

	
	private SetupGUI setupInventory;
	
	private PlayerSetupGUI playerSetupInv;
	private TimerSetupGUI timerSetupInv;
	private SpawnSetupGUI spawnSetupInv;
	
	private SheepsGUI sheepsInv;
	private BonusGUI bonusInv;
	
	
	
	public InventoryManager() {
		setupInventory = new SetupGUI();
		
		playerSetupInv = new PlayerSetupGUI();
		timerSetupInv = new TimerSetupGUI();
		spawnSetupInv = new SpawnSetupGUI();
		
		sheepsInv = new SheepsGUI();
		bonusInv = new BonusGUI();
	}
	
	
	public SetupGUI getSetupInventory() {
		return setupInventory;
	}
	
	public PlayerSetupGUI getPlayerSetupInv() {
		return playerSetupInv;
	}
	
	public TimerSetupGUI getTimerSetupInv() {
		return timerSetupInv;
	}
	
	public SpawnSetupGUI getSpawnSetupInv() {
		return spawnSetupInv;
	}
	
	
	public SheepsGUI getSheepsInv() {
		return sheepsInv;
	}
	public BonusGUI getBonusInv() {
		return bonusInv;
	}
}
