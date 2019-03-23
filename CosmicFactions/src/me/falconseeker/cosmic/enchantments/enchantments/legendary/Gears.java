package me.falconseeker.cosmic.enchantments.enchantments.legendary;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.falconseeker.cosmic.enchantments.EnchantApplyType;
import me.falconseeker.cosmic.enchantments.EnchantType;
import me.falconseeker.cosmic.enchantments.IEnchantment;
import me.falconseeker.cosmic.enchantments.Tier;
import me.falconseeker.util.Utils;
import me.falconseeker.util.XTags;

public class Gears implements IEnchantment {

	@Override
	public int getMaxLevel() {
		return 3;
	}
	@Override
	public String getName() {
		return Utils.color("&6&l&nGears");
	}

	@Override
	public EnchantType getType() {
		return EnchantType.IDLE;
	}
	@Override
	public EnchantApplyType getApplyType() {
		return EnchantApplyType.BOOTS;
	}
	@Override
	public Tier getRarity() {
		return Tier.LEGENDARY;
	}
	@Override
	public List<String> getDescription() {
		List<String> list = Arrays.asList("&eAdded speed when equiped.");
		return list;
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
	public void onEquip(Player applier, ItemStack i, String enchantment, boolean unequip) {
		if (!unequip) {
		applier.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, (int) XTags.getItemTag(i, getName())));
	}
  }
}
