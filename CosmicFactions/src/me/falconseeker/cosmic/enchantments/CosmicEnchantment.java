package me.falconseeker.cosmic.enchantments;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface CosmicEnchantment {
	public int getMaxLevel();
	public int getLevel();
	public String getName();
	public void onProc(Player attacker, Player attacked, ItemStack i, String enchantment);
	public EnchantType getType();
}
