package me.falconseeker.cosmic.money.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.money.Money;
import me.falconseeker.util.Utils;
import me.falconseeker.util.XTags;

public class MoneyClick implements Listener {

	private Money money;
	
	public MoneyClick(Cosmic main) {
		this.money = main.getMoney();
		Bukkit.getPluginManager().registerEvents(this, main);
	}
	//Money notes stacking
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem() == null) return;
		if (p.getItemOnCursor() == null) return;
		
		ItemStack original = e.getCursor();
		ItemStack newstack = e.getCurrentItem();
		
		if (original.getType() != Material.PAPER && newstack.getType() != Material.PAPER) return;
		if (XTags.getItemTag(newstack, "Value") == null || XTags.getItemTag(original, "Value") == null) return;
		
		e.setCancelled(true);
		p.getInventory().setItem(e.getSlot(), Utils.createNote((int) XTags.getItemTag(newstack, "Value") + (int) XTags.getItemTag(original, "Value"), p.getName()));
		e.getCursor().setAmount(-1);
		p.updateInventory();
		p.playSound(p.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, .5f, .5f);
	}
	//Money notes deposit
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if (p.getInventory().getItemInMainHand() == null) return;
		
		ItemStack i = p.getInventory().getItemInMainHand();
		
		if (XTags.getItemTag(i, "Value") == null) return;
		
		int value = (int) XTags.getItemTag(i, "Value");
		StringBuilder message = new StringBuilder(Utils.color("&a&l+" + String.valueOf(value)));
		
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, .5f, .5f);
		
		if (i.getType() == Material.PAPER) {
			p.sendMessage(message.toString());
			money.addMoney(p, value);
		}
		if (i.getType() == Material.EXP_BOTTLE) {
			p.sendMessage(message.append(" XP").toString());
			p.setExp(p.getExp() + value);
		}
		
		p.getInventory().getItemInMainHand().setAmount(-1);
		p.updateInventory();
	}
}
