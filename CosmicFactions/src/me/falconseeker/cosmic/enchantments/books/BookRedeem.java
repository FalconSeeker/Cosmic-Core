package me.falconseeker.cosmic.enchantments.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.enchantments.EnchantmentInterface;
import me.falconseeker.cosmic.enchantments.EnchantmentManager;
import me.falconseeker.cosmic.enchantments.Tier;
import me.falconseeker.util.ItemBuilder;
import me.falconseeker.util.Utils;
import me.falconseeker.util.XTags;

public class BookRedeem implements Listener {

	private EnchantmentManager enchantManager;
	
	public BookRedeem(Cosmic main) {
		this.enchantManager = main.getEnchantManager();
	}
	
	@EventHandler
	public void onRedeem(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if (p.getInventory().getItemInMainHand() == null) return;
		ItemStack i = p.getInventory().getItemInMainHand();
		
		if (XTags.getItemTag(i, "Tier") == null) return;
		
		Tier t = (Tier) XTags.getItemTag(i, "Tier");
		
		List<EnchantmentInterface> enchantments = enchantManager.getEnchantmentByRarity(t);
		EnchantmentInterface ench = enchantments.get(Utils.randomInt(0, enchantments.size()));
		
		ItemStack book = ItemBuilder.createBook(ench.getName(), Material.BOOK, ench.getDescription(), ench);
		p.getInventory().addItem(book);
	}
}
