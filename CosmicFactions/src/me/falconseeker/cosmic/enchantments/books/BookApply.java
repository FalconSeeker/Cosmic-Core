package me.falconseeker.cosmic.enchantments.books;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.enchantments.EnchantmentInterface;
import me.falconseeker.cosmic.enchantments.EnchantmentManager;
import me.falconseeker.util.XTags;

public class BookApply implements Listener {

	private EnchantmentManager enchantManager;
	
	public BookApply(Cosmic main) {
		this.enchantManager = main.getEnchantManager();
	}
	
	@EventHandler
	public void onApply(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem() == null) return;
		if (e.getCursor() == null) return;
		ItemStack current = e.getCurrentItem();
		ItemStack cursor = e.getCursor();
		
		if (XTags.getItemTag(cursor, "Enchantment") == null) return;
		EnchantmentInterface ench = enchantManager.getEnchantment((String) XTags.getItemTag(cursor, "Enchantment"));
		
		if (!current.getType().toString().contains(ench.getApplyType().toString())) return;
		
		XTags.setItemTag(current, ench.getName(), XTags.getItemTag(cursor, ench.getName()));
	}
}
