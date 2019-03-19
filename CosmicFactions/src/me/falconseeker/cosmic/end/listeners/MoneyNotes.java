package me.falconseeker.cosmic.end.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.util.XTags;

public class MoneyNotes implements Listener {

	@EventHandler
	public void onMoneyDeposit(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInMainHand() == null) return;
		ItemStack i = p.getInventory().getItemInMainHand();
		if (XTags.getItemTag(i, "Value") == null) return;
			
		}
	}
