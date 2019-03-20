package me.falconseeker.cosmic.enchantments.enchantments;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.falconseeker.cosmic.enchantments.EnchantApplyType;
import me.falconseeker.cosmic.enchantments.EnchantType;
import me.falconseeker.cosmic.enchantments.EnchantmentInterface;
import me.falconseeker.util.XTags;

public class Gears implements EnchantmentInterface {

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
		return EnchantType.IDLE;
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
		//Will not be called since this is an idle enchantment
		return;
	}
	@Override
	public void onDamagedProc(Player damager, Player damaged, ItemStack i, String enchantment) {
		//Will not be called since this is an idle enchantment	
		return;
	}
	@Override
	public void onIdleProc(Player applier, ItemStack i, String enchantment) {
		applier.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, (int) XTags.getItemTag(i, enchantment)));
	}

}
