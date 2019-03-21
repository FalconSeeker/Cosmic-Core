package me.falconseeker.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.falconseeker.cosmic.enchantments.EnchantmentInterface;

/**
 * 
 * ItemBuilder class made by Falcon_Seeker - 2019
 * 
 * @author Falco
 *
 */
public final class ItemBuilder {

	private ItemBuilder() {}
	
	/**
	 * 
	 * Creates an ItemStack with custom parameters
	 * 
	 * @param name - Color code supported. Name of item.
	 * @param mat - Material to be used
	 * @param lore - Color code supported. Lore
	 * @param amount - Amount of item to return
	 * @return - Returns an ItemStack
	 */
	public static ItemStack createItem(String name, Material mat, @Nullable List<String> lore, @Nullable int amount) {
		ItemStack i = new ItemStack(mat);
		if (amount != 0) i = new ItemStack(mat, amount);
		ItemMeta meta = i.getItemMeta();
		
		if (lore != null) {
		List<String> l = new ArrayList<String>();
		lore.forEach(s -> l.add(Utils.color(s)));
		
		meta.setLore(lore);
		}
		meta.setDisplayName(Utils.color(name));
		i.setItemMeta(meta);
		return i;
		
	}
	public static ItemStack createBook(String name, Material mat, List<String> lore, EnchantmentInterface ench) {
		
		int destroy_rate = Utils.randomInt(0, 100);
		int success_rate = Utils.randomInt(0, 100);
		int lvl = Utils.randomInt(1, ench.getMaxLevel());
		
		ItemStack i = new ItemStack(mat);
		ItemMeta meta = i.getItemMeta();
		
		List<String> l = new ArrayList<String>();
		l.add(Utils.color("&a" + String.valueOf(success_rate) + " Success Rate"));
		l.add(Utils.color("&c" + String.valueOf(destroy_rate) + " Destroy Rate."));

		lore.forEach(s -> l.add(Utils.color(s)));
		
		meta.setLore(lore);

		meta.setDisplayName(Utils.color(name + " " + Utils.numural(lvl)));
		i.setItemMeta(meta);
		
		ItemStack is = XTags.setItemTag(i, ench.getName(), lvl);
		ItemStack success = XTags.setItemTag(is, "destroy_rate", destroy_rate);
		ItemStack final_stack = XTags.setItemTag(success, "success_rate", success_rate);

		return final_stack;
	}
}
