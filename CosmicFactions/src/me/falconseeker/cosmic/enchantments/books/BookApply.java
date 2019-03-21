package me.falconseeker.cosmic.enchantments.books;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.enchantments.EnchantmentManager;

public class BookApply implements Listener {

	private EnchantmentManager enchantManager;
	
	public BookApply(Cosmic main) {
		this.enchantManager = main.getEnchantManager();
	}
	
	@EventHandler
	public void onApply(InventoryClickEvent e) {
		
	}
}
