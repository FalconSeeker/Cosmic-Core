package me.falconseeker.util.events;

import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.enchantments.IEnchantment;
import me.falconseeker.util.XTags;

public class Enchantment {

	private Enchantment() {}
	
	public static boolean hasEnchantment(ItemStack i, IEnchantment ench) {
		if (XTags.getItemTag(i, ench.getName()) != null) return true;
		return false;
	}
	public static int getLevel(ItemStack i, IEnchantment ench) {
		if (XTags.getItemTag(i, ench.getName()) != null) return (int) XTags.getItemTag(i, ench.getName());
		return 0;
	}
}
