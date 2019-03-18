package me.falconseeker.util;

import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * ItemBuilder class made by Falcon_Seeker - 2019
 * @author Falco
 *
 */
public final class ItemBuilder extends Utils {

	private ItemBuilder() {}
	
	public static ItemStack createItem(String name, Material mat, @Nullable List<String> lore, @Nullable int amount) {
		ItemStack i = new ItemStack(mat);
		if (amount != 0) i = new ItemStack(mat, amount);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(color(name));
		i.setItemMeta(meta);
		return i;
		
	}
}
