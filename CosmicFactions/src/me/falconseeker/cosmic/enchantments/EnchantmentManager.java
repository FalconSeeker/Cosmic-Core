package me.falconseeker.cosmic.enchantments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.util.XTags;
import me.falconseeker.util.events.ArmorEquipEvent;
 
public class EnchantmentManager implements Listener
{
 
    private static Map<String, IEnchantment> listeners = new HashMap<>();
    private Cosmic main;

    public EnchantmentManager(Cosmic main) {
    	this.main = main;
    }
    public void register(String name, IEnchantment cmd) {
        listeners.put(name, cmd);
    }
    public boolean exists(String name) {
         return listeners.containsKey(name);
    }
     public IEnchantment getEnchantment(String name) {
         return listeners.get(name);
    }
     public Set<IEnchantment> getEnchantments() {
    	 Set<IEnchantment> enchantments = new HashSet<>();
    	 enchantments.addAll(listeners.values());
         return enchantments;
    }
    public List<IEnchantment> getEnchantmentByRarity(Tier rarity){
    	List<IEnchantment> enchantments = new ArrayList<>();
    	listeners.values().forEach(ench -> { if (ench.getRarity() == rarity) enchantments.add(ench); });
		return enchantments;	
    }
}
 
