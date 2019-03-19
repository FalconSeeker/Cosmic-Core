package me.falconseeker.cosmic.end.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.util.Utils;
import me.falconseeker.util.XTags;

public class MobHealth implements Listener {

	public MobHealth(Cosmic main) {
		Bukkit.getPluginManager().registerEvents(this, main);
	}
	
	  @EventHandler
	  public void damage(EntityDamageByEntityEvent e)
	  {
		  if (XTags.getEntityTag(e.getEntity(), "MobType") == null) return;

	      if (((e.getDamager() instanceof Player)) && 
	        ((e.getEntity() instanceof LivingEntity)) && (!(e.getEntity() instanceof Player)))
	      {
	        LivingEntity ent = (LivingEntity)e.getEntity();
	        EntityType entt = ent.getType();
	        if ((entt != EntityType.ENDER_DRAGON) && (entt != EntityType.WITHER))
	        {
	    	Entity end_mob = e.getEntity();
	    	StringBuilder health = new StringBuilder("");
	    	Double health_d = ((LivingEntity) end_mob).getHealth()/2;
	    		
	    	for (int i = 0; i < ((LivingEntity) end_mob).getMaxHealth()/2; i++) {
	    	if (i <= health_d) {
	    		health.append(Utils.color("&ch"));
	    		continue;
	    	}
	    	health.append(Utils.color("&7h"));
	    	}	      
	    	ent.setCustomName(health.toString());
	        ent.setCustomNameVisible(true);
	          
	        if (ent.getHealth() - e.getFinalDamage() < 1.0D) {
	            ent.setCustomName(null);
	            ent.setCustomNameVisible(false);
	          }
	        }
	      }
	  }
	  
	  @EventHandler
	  public void onEntityRegain(EntityRegainHealthEvent e)
	  {
		if (XTags.getEntityTag(e.getEntity(), "MobType") == null) return;
		
	    if (!(e.getEntity() instanceof LivingEntity)) return;
	      LivingEntity ent = (LivingEntity)e.getEntity();
	      double health_d = ent.getHealth();
	      if (health_d >= 1.0D)
	      {
	        if (health_d + e.getAmount() > 20.0D) {
	          health_d = 20.0D;
	        }
	    	Entity end_mob = e.getEntity();
	    	StringBuilder health = new StringBuilder("");
	    		
	    	for (int i = 0; i < ((LivingEntity) end_mob).getMaxHealth()/2; i++) {
	    	if (i <= health_d) {
	    		health.append(Utils.color("&ch"));
	    		continue;
	    	}
	    	health.append(Utils.color("&7h"));
	    	}	      
	    	ent.setCustomName(health.toString());
	        ent.setCustomNameVisible(true);
	      }
	  }
}
