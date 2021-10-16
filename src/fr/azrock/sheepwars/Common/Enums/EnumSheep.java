package fr.azrock.sheepwars.Common.Enums;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Sheeps.Sheep;
import fr.azrock.sheepwars.Utils.ItemBuilder;
import net.minecraft.server.v1_14_R1.Entity;
import net.minecraft.server.v1_14_R1.EntityTypes;

public enum EnumSheep {
	
	HEALER("healer", new ItemBuilder(ChatColor.LIGHT_PURPLE+"Healer", 1, Material.PINK_WOOL).build()), 
	
	DISTORTION("distortion", new ItemBuilder(ChatColor.DARK_PURPLE+"Distortion", 1, Material.PURPLE_WOOL).build()), 
	
	EARTHQUAKE("earthquake", new ItemBuilder(ChatColor.GOLD+"Earthquake", 1, Material.BROWN_WOOL).build()), 
	
	EXPLOSIVE("explosive", new ItemBuilder(ChatColor.RED+"Explosive", 1, Material.RED_WOOL).build()), 
	
	FRAGMENTATION("fragmentation", new ItemBuilder(ChatColor.GRAY+"Framentation", 1, Material.GRAY_WOOL).build()), 
	
	BLIND("blind", new ItemBuilder(ChatColor.DARK_GRAY+"Blind", 1, Material.BLACK_WOOL).build()), 
	
	GALACTIC("galactic", new ItemBuilder(ChatColor.DARK_BLUE+"Galactic", 1, Material.BLUE_WOOL).build()), 
	
	GLUTTON("glutton", new ItemBuilder(ChatColor.DARK_GREEN+"Glutton", 1, Material.GREEN_WOOL).build()), 
	
	TRACKER("tracker", new ItemBuilder(ChatColor.GREEN+"Tracker", 1, Material.LIME_WOOL).build()), 
	
	LIGHTNING("lightning", new ItemBuilder(ChatColor.YELLOW+"Lightining", 1, Material.YELLOW_WOOL).build()), 
	
	FROZEN("frozen", new ItemBuilder(ChatColor.AQUA+"Frozen", 1, Material.LIGHT_BLUE_WOOL).build()), 
	
	INCENDIARY("incendiary", new ItemBuilder(ChatColor.GOLD+"Incendiary", 1, Material.ORANGE_WOOL).build()), 
	
	BOARDING("boarding", new ItemBuilder(ChatColor.WHITE+"Healer", 1, Material.WHITE_WOOL).build()), 
	
	STICKY("sticky", new ItemBuilder(ChatColor.DARK_AQUA+"Sticky", 1, Material.CYAN_WOOL).build()),
	
	GLOWING("glowing", new ItemBuilder(ChatColor.BLUE+"Glowing", 1, Material.MAGENTA_WOOL).build());
	
	
	private String name;
	private ItemStack wool;
	
	EnumSheep(String name, ItemStack wool) {
		this.name = name;
		this.wool = wool;
		WoolBean.SHEEP_WOOL.put(wool.getType(), this);
	}
	
	
	public String getName() {
		return name;
	}
	
	public ItemStack getWoolItem() {
		return wool;
	}
	
	public static EnumSheep getSheepByWool(Material mat) {
		return WoolBean.SHEEP_WOOL.get(mat);
	}
	
	public EntityTypes<? extends Entity> getEntityType() {
		Map<String, EntityTypes<Entity>> registeredSheeps = SheepWars.get().getEntities();
		
		if (registeredSheeps.containsKey(name))
			return registeredSheeps.get(name);
		
		return EntityTypes.SHEEP;
	}
	
	
	
	public static Sheep summon(Material wool, Player summoner) {
		return Sheep.summonSheep(summoner, getSheepByWool(wool));
	}
	
	
	private static final class WoolBean {
		private static final Map<Material, EnumSheep> SHEEP_WOOL = new HashMap<Material, EnumSheep>();
	}
}
