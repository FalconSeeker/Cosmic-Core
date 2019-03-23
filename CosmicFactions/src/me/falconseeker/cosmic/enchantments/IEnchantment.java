package me.falconseeker.cosmic.enchantments;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IEnchantment {
	public int getMaxLevel();
	public String getName();
	public List<String> getDescription();
	/**
	 * 
	 * @param damager - Player who is dealing damage
	 * @param damaged - Player who is taking damage
	 * @param i - Armor from damager's being checked
	 * @param enchantment - Name of the enchantment
	 */
	public void onDamagerProc(Player damager, Player damaged, ItemStack i, String enchantment);
	public void onDamagedProc(Player damager, Player damaged, ItemStack i, String enchantment);
	public void onEquip(Player applier,ItemStack i, String enchantment, boolean unequip);
	public Tier getRarity();
	public EnchantType getType();
	public EnchantApplyType getApplyType();
}
