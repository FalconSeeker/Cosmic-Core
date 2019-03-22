package me.falconseeker.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.falconseeker.cosmic.enchantments.EnchantmentInterface;
import me.falconseeker.cosmic.enchantments.Tier;
import net.md_5.bungee.api.ChatColor;

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
		List<String> l = new ArrayList<>();
		lore.forEach(s -> l.add(Utils.color(s)));
		
		meta.setLore(lore);
		}
		meta.setDisplayName(Utils.color(name));
		i.setItemMeta(meta);
		return i;
		
	}
	/**
	 * 
	 * Creates a book that can be used to apply enchants on items
	 * 
	 * @param name - Name of the enchantment
	 * @param mat - Material of the book
	 * @param lore - Lore of the enchantment
	 * @param ench - EnchantmentInterface enchantment being used
	 * @return - Returns an ItemStack
	 */
	public static ItemStack createBook(String name, Material mat, List<String> lore, EnchantmentInterface ench) {
		
		int destroyRate = Utils.randomInt(0, 100);
		int successRate = Utils.randomInt(0, 100);
		int lvl = Utils.randomInt(1, ench.getMaxLevel());
		
		ItemStack i = new ItemStack(mat);
		ItemMeta meta = i.getItemMeta();
		
		lore.add(0, ChatColor.GREEN + "" + successRate + " Success Rate");
		lore.add(1, ChatColor.RED + "" + destroyRate + " Destroy Rate.");
		
		lore = Utils.colorAll(lore);
		
		meta.setLore(lore);

		meta.setDisplayName(Utils.color(name + " " + Utils.numural(lvl)));
		i.setItemMeta(meta);
		
		i = XTags.setItemTag(i, ench.getName(), lvl);
		i = XTags.setItemTag(i, "destroy_rate", destroyRate);
		i = XTags.setItemTag(i, "success_rate", successRate);

		return XTags.setItemTag(i, ench.getName(), "Enchantment");
	}
	/**
	 * 
	 * Creates a book that can be opened when right clicking it
	 * 
	 * @param name
	 * @param mat
	 * @param lore
	 * @param ench
	 * @return
	 */
	public static ItemStack createClosedBook(String name, Material mat, List<String> lore, Tier tier) {
		ItemStack i = new ItemStack(mat);
		ItemMeta meta = i.getItemMeta();
		String color = tier.getColor();
		
		List<String> l = new ArrayList<>();
		l.add(Utils.color("&7Examine to receive a random"));
		l.add(Utils.color(tier.getColor() + tier.toString().toLowerCase() + " &7enchantment book"));

		lore.forEach(s -> l.add(Utils.color(s)));
		
		meta.setLore(lore);

		meta.setDisplayName(Utils.color("&l" + "" + color + StringUtils.capitalise(tier.toString().toLowerCase())));
		i.setItemMeta(meta);

		return i;
	}
}
