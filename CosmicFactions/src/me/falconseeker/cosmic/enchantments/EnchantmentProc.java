package me.falconseeker.cosmic.enchantments;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.util.XTags;
import net.md_5.bungee.api.ChatColor;
 
public class EnchantmentProc implements Listener
{
 
    private static HashMap<String, CosmicEnchantment> listeners = new HashMap<String, CosmicEnchantment>();
    private Cosmic main;
    
    public EnchantmentProc(Cosmic main) {
    	this.main = main;
    }
    public void register(String name, CosmicEnchantment cmd) {
        listeners.put(name, cmd);
    }
 
    public boolean exists(String name) {
         return listeners.containsKey(name);
    }
     public CosmicEnchantment getListener(String name) {
         return listeners.get(name);
    }
    @EventHandler
    public void onEntityHitEvent(EntityDamageByEntityEvent e) {
    	
    	if (!(e.getDamager() instanceof Player)) return;
    	if (!(e.getEntity() instanceof Player)) return;
    	
    	Player attacked = (Player) e.getEntity();
    	Player p = (Player) e.getDamager();
    	
    	if (p.getInventory().getItemInMainHand() == null) return;
    	ItemStack held_item = p.getInventory().getItemInMainHand();
    	
    	for (ItemStack armor : p.getInventory().getArmorContents()) {
    		for (int i = 0; i <= 10; i++) {
    			if (XTags.getItemTag(armor, i) == null) continue;
    			if (getListener((String) XTags.getItemTag(armor, i)).getType() == EnchantType.IDLE) continue;
    	    	getListener((String) XTags.getItemTag(armor, i)).onProc(p, attacked, armor, (String) XTags.getItemTag(armor, i));
    		}
    	}
    }
 
}
 
