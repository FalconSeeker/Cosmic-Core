package me.falconseeker.cosmic.end.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.util.Utils;
import me.falconseeker.util.XTags;

public class CustomMobs implements Listener {

	private HashMap<Player, Integer> multiplier;
	
	public CustomMobs(Cosmic main) {
		Bukkit.getPluginManager().registerEvents(this, main);
	}
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
        Entity ent = e.getEntity();
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		
		if (XTags.getEntityTag(ent, "MobType") == null) return;
        	
		String s = (String) XTags.getEntityTag(ent, "MobType");
		
		if (s.equals("EnderMonster")) {
			drops.add(Utils.randomNote(1000, 30000, "End Dimension"));
			drops.add(Utils.createEXP(1000, "End Dimension"));
		}
		else if (s.equals("EnderCreeper")) {
            if (Utils.random(10)) drops.add(new ItemStack(Material.CONCRETE_POWDER));
            if (Utils.random(40)) drops.add(new ItemStack(Material.MONSTER_EGG));
        }
		e.getDrops().clear();
		e.getDrops().addAll(drops);
		return;
		}
	}
