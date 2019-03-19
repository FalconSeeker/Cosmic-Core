package me.falconseeker.cosmic.money;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.falconseeker.cosmic.Cosmic;

public class Money {

	private HashMap<Player, Integer> money;
	private Cosmic main;
	
	public Money(Cosmic main) {
		this.main = main;
		this.money = new HashMap<Player, Integer>();
	}
	public int getMoney(Player p) {
		if (money.get(p) == null) return 0;
		return money.get(p);
	}
	public void addMoney(Player p, int amount) {
		money.put(p, amount);
	}
	public void resetBalance(Player p) {
		if (!money.containsKey(p)) return;
		money.remove(p);
	}
	public void serialize() {
		for (String s : main.getConfig().getConfigurationSection("data").getKeys(false)) {
			money.put(Bukkit.getPlayer(UUID.fromString(s)), main.getConfig().getInt("data." + "s." + "money"));
		}
	}
}
