package fr.azrock.sheepwars.Utils;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	
	private ItemStack itemStack;
	
	private ItemMeta itemMeta;
	
	
	
	public ItemBuilder(String name, int amount, Material material) {
		itemStack = new ItemStack(material, amount);
		itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(name);
	}
	
	
	public ItemBuilder(String name, int amount, Material material, String... lore) {
		this(name, amount, material);
		itemMeta.setLore(Arrays.asList(lore));
	}
	
	
	public ItemBuilder(String name, int amount, Material material, List<String> lore) {
		this(name, amount, material);
		itemMeta.setLore(lore);
	}
	
	
	public ItemBuilder(String name, int amount, Material material, List<String> lore, boolean enchanted) {
		this(name, amount, material, lore);
		
		itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	}
	
	
	
	public ItemBuilder hideAllFlags() {
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		return this;
	}
	
	
	
	public ItemStack build() {		
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
}
