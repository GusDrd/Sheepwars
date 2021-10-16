package fr.azrock.sheepwars;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;

import fr.azrock.sheepwars.Commands.ACommand;
import fr.azrock.sheepwars.Common.Game.Game;
import fr.azrock.sheepwars.Common.Sheeps.HealerSheep;
import fr.azrock.sheepwars.Config.ConfigManager;
import fr.azrock.sheepwars.Listeners.EventManager;
import fr.azrock.sheepwars.Utils.Inventories.InventoryManager;
import fr.azrock.sheepwars.Utils.SetupMode.Mode;
import net.minecraft.server.v1_14_R1.DataConverterRegistry;
import net.minecraft.server.v1_14_R1.DataConverterTypes;
import net.minecraft.server.v1_14_R1.Entity;
import net.minecraft.server.v1_14_R1.EntityTypes;
import net.minecraft.server.v1_14_R1.EnumCreatureType;
import net.minecraft.server.v1_14_R1.IRegistry;
import net.minecraft.server.v1_14_R1.SharedConstants;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SheepWars extends JavaPlugin {
	
	
	private static SheepWars instance;
	
	private ConfigManager configManager;
	
	private InventoryManager guiManager;
	
	private Game gameManager;
	
	private Mode setupMode;
	
	
	private Map<String, EntityTypes<Entity>> entities = new HashMap<String, EntityTypes<Entity>>();
	
	
	
	public void onLoad() {
		
		this.registerEntity("healerSheep", "healerSheep", HealerSheep::new, EnumCreatureType.CREATURE);
		
	}
	
	
	
	public void onEnable() {
		instance = this;
		
		configManager = new ConfigManager(this);
		
		gameManager = new Game(this);
		
		guiManager = new InventoryManager();
		
		
		setupMode = new Mode();
		
		ACommand.registerCommands(this);
		
		Bukkit.getPluginManager().registerEvents(new EventManager(), this);
	}
	
	
	
	public static SheepWars get() {
		return instance;
	}
	
	public ConfigManager getConfigManager() {
		return this.configManager;
	}
	
	public Game getGame() {
		return this.gameManager;
	}
	
	public Mode getSetupMode() {
		return this.setupMode;
	}
	
	public InventoryManager getInventoryManager() {
		return this.guiManager;
	}
	
	
	
	public Map<String, EntityTypes<Entity>> getEntities() {
		return entities;
	}
	
	private void registerEntity(String name, String nmsName, EntityTypes.b entity, EnumCreatureType creatureType) {
		
		Map<String, Type<?>> types = (Map<String, Type<?>>) DataConverterRegistry.a().getSchema(DataFixUtils.makeKey(SharedConstants.a().getWorldVersion())).findChoiceType(DataConverterTypes.ENTITY).types();
		
		types.put("minecraft:"+name, types.get("minecraft:"+nmsName));
		
		EntityTypes.a<Entity> a = EntityTypes.a.a(entity, creatureType);
		EntityTypes entityType = IRegistry.a(IRegistry.ENTITY_TYPE, name, a.a(name));
		
		entities.put(name, entityType);
	}
}
