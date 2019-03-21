package me.falconseeker.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
}
