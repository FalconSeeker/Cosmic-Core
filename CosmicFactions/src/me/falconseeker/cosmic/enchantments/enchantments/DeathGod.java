package me.falconseeker.cosmic.enchantments.enchantments;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.falconseeker.cosmic.enchantments.EnchantApplyType;
import me.falconseeker.cosmic.enchantments.EnchantType;
import me.falconseeker.cosmic.enchantments.EnchantmentInterface;

public class DeathGod implements EnchantmentInterface {

	@Override
	public int getMaxLevel() {
		return 3;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnchantType getType() {
		return EnchantType.ATTACKED;
	}

	@Override
	public EnchantApplyType getApplyType() {
		return EnchantApplyType.HELMETS;
	}
	@Override
	public List<String> getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onDamagerProc(Player damager, Player damaged, ItemStack i, String enchantment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDamagedProc(Player damager, Player damaged, ItemStack i, String enchantment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onIdleProc(Player applier, ItemStack i, String enchantment) {
		// TODO Auto-generated method stub
		
	}

}
