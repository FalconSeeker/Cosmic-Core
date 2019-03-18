package me.falconseeker.util;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Utils {

	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static ItemStack randomNote(int min, int max, String signer) {
		Random ran = new Random();
		int random_int = ran.nextInt((max-min) + 1) + min;
		
		return createNote(random_int, signer);
	}
	public static ItemStack createNote(int value, String signer) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("&dValue &f" + String.valueOf(value));
		lore.add("&dSigner &7" + signer);
		
		return ItemBuilder.createItem("&b&lCosmic Note &7(Right Click)", Material.PAPER, lore, 1);
	}
	public static ItemStack createEXP(int value, String signer) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("&dValue &f" + String.valueOf(value) + " XP");
		lore.add("&dSigner &7" + signer);
		
		return ItemBuilder.createItem("&a&lExperience Bottle &7(Throw)", Material.EXP_BOTTLE, lore, 1);
	}
}
