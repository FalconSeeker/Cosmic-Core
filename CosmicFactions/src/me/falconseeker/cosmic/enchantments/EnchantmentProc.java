package me.falconseeker.cosmic.enchantments;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.util.Utils;
import me.falconseeker.util.XTags;
import me.falconseeker.util.events.ArmorEquipEvent;
 
public class EnchantmentProc implements Listener
{
 
    private static HashMap<String, EnchantmentInterface> listeners = new HashMap<String, EnchantmentInterface>();
    private Cosmic main;
    
    public EnchantmentProc(Cosmic main) {
    	this.main = main;
    }
    public void register(String name, EnchantmentInterface cmd) {
        listeners.put(name, cmd);
    }
 
    public boolean exists(String name) {
         return listeners.containsKey(name);
    }
     public EnchantmentInterface getListener(String name) {
         return listeners.get(name);
    }
    //Gets the attackers enchantments
    @EventHandler
    public void onDamagerProcEvent(EntityDamageByEntityEvent e) {
    	
    	if (!(e.getDamager() instanceof Player)) return;
    	if (!(e.getEntity() instanceof Player)) return;
    	
    	Player attacked = (Player) e.getEntity();
    	Player p = (Player) e.getDamager();
    	
    	if (p.getInventory().getItemInMainHand() == null) return;
    	
    	ItemStack sword = p.getInventory().getItemInMainHand();
    	
    		for (int i = 0; i <= 10; i++) {
    			if (XTags.getItemTag(sword, i) == null) continue;
    			String s = (String) XTags.getItemTag(sword, i);
    			if (getListener(s).getType() == EnchantType.IDLE) continue;
    	    	getListener(s).onDamagerProc(p, attacked, sword, s);
    		}
    }
    //Gets the attacked players enchantments
    @EventHandler
    public void onDamagedProcEvent(EntityDamageByEntityEvent e) {
    	
    	if (!(e.getDamager() instanceof Player)) return;
    	if (!(e.getEntity() instanceof Player)) return;

    	Player attacked = (Player) e.getEntity();
    	Player p = (Player) e.getDamager();
    	
    	for (ItemStack armor : attacked.getInventory().getArmorContents()) {
    		for (int i = 0; i <= 10; i++) {
    			if (XTags.getItemTag(armor, i) == null) continue;
    			if (getListener((String) XTags.getItemTag(armor, i)).getType() == EnchantType.IDLE) continue;
    	    	getListener((String) XTags.getItemTag(armor, i)).onDamagerProc(attacked, attacked, armor, (String) XTags.getItemTag(armor, i));
    		}
    	}
    }
    @EventHandler
    public void onArmorEquip(ArmorEquipEvent e) {
    	Player p = e.getPlayer();
    }
}
 
