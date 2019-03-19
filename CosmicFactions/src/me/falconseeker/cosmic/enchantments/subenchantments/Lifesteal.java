package me.falconseeker.cosmic.enchantments.subenchantments;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.enchantments.CosmicEnchantment;
import me.falconseeker.cosmic.enchantments.EnchantType;

public class Lifesteal implements CosmicEnchantment {

	public int max_level = 1;

	@Override
	public int getMaxLevel() {
		return max_level;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onProc(Player attacker, Player attacked, ItemStack i, String enchantment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnchantType getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
