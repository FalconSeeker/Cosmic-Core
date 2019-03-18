package me.falconseeker.cosmic.end.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.end.endmonsters.EnderCreeper;
import me.falconseeker.end.endmonsters.EnderMonster;
import me.falconseeker.util.Utils;

public class CustomMobs implements Listener {

	private HashMap<Player, Integer> multiplier;
	
	public CustomMobs(Cosmic main) {
		Bukkit.getPluginManager().registerEvents(this, main);
	}
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof EnderMonster && e.getEntity() instanceof EnderCreeper)) return;
		Entity end_mob = e.getEntity();
		StringBuilder health = new StringBuilder("");
		Double health_d = ((LivingEntity) end_mob).getHealth();
		
		for (int i = 0; i < ((LivingEntity) end_mob).getMaxHealth(); i++) {
			if (i <= health_d) {
				health.append(Utils.color("&cX"));
				continue;
			}
			health.append(Utils.color("&7X"));
		}
		end_mob.setCustomName(health.toString());
	}
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof EnderCreeper && e.getEntity() instanceof EnderMonster)) return;
		Entity end_mob = e.getEntity();
		
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(Utils.randomNote(1000, 30000, "End Dimension"));
		drops.add(Utils.createEXP(1000, "End Dimension"));

		e.getDrops().clear();
		e.getDrops().addAll(drops);
	}
}
