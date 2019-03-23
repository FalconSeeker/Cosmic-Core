package me.falconseeker.cosmic.enchantments;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.util.XTags;
import me.falconseeker.util.events.ArmorEquipEvent;

public class EnchantmentListeners implements Listener {
	
	private EnchantmentManager enchantManager;
	private int maxEnchantment;
	
	public EnchantmentListeners(Cosmic main) {
		this.enchantManager = main.getEnchantManager();
		this.maxEnchantment = main.getConfig().getInt("maxEnchantment");
	}
	//Procs the attackers enchantments
    @EventHandler
    public void onDamagerProcEvent(EntityDamageByEntityEvent e) {
    	
    	if (!(e.getDamager() instanceof Player)) return;
    	if (!(e.getEntity() instanceof Player)) return;
    	
    	Player attacked = (Player) e.getEntity();
    	Player p = (Player) e.getDamager();
    	
    	if (p.getInventory().getItemInMainHand() == null) return;
    	
    	ItemStack sword = p.getInventory().getItemInMainHand();
    	
    		for (int i = 0; i <= maxEnchantment; i++) {
    			if (XTags.getItemTag(sword, i) == null) continue;
    			
    			String s = (String) XTags.getItemTag(sword, i);
    			IEnchantment ench = enchantManager.getEnchantment(s);

    			if (ench.getType() == EnchantType.IDLE || ench.getType() == EnchantType.ATTACKED) continue;
    			ench.onDamagerProc(p, attacked, sword, s);
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
    		for (int i = 0; i <= maxEnchantment; i++) {
    			if (XTags.getItemTag(armor, i) == null) continue;
    			
    			String s = (String) XTags.getItemTag(armor, i);
    			IEnchantment ench = enchantManager.getEnchantment(s);
    			
    			if (ench.getType() == EnchantType.IDLE) continue;
    			ench.onDamagedProc(attacked, attacked, armor, s);
    		}
    	}
    }
    @EventHandler
    public void onArmorEquip(ArmorEquipEvent e) {
    	Player p = e.getPlayer();
    	if (e.getOldArmorPiece() != null) {
    		ItemStack armor = e.getOldArmorPiece();
    		
    		for (int i = 0; i < maxEnchantment; i++) {
    			if (XTags.getItemTag(armor, i) == null) continue;
    			
    			String s = (String) XTags.getItemTag(armor, i);
    			IEnchantment ench = enchantManager.getEnchantment(s);
    			
    			ench.onEquip(p, armor, s, true);    			
    		}
    	}
    }
}
