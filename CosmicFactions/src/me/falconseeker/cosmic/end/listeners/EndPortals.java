package me.falconseeker.cosmic.end.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.falconseeker.cosmic.Cosmic;

public class EndPortals {

	private Location loc1;
	private int delay;
	private Cosmic main;
	
	public EndPortals(Cosmic main) {
		this.main = main;
		if (main.getConfig().get("Portal.Location") != null) this.loc1 = (Location) main.getConfig().get("Portal.location");
		this.delay = main.getConfig().getInt("Portal.delay");
	}
	
	@EventHandler
	public void onMove(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		
		if (!(e.getCause() == TeleportCause.END_PORTAL)) return;
	
		p.sendMessage("&e&l(!) &eYou will be teleported in &n" + String.valueOf(delay) + "s&r&e... DON'T MOVE!");
		p.sendMessage("&7Decrease this wait time by increasing your enchanting level.");
		
		p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, delay, 1));
		e.setCancelled(true);
		
		new BukkitRunnable() {

			@Override
			public void run() {
				p.teleport(loc1);
			}
			
		}.runTaskLater(main, delay);
	}
}
