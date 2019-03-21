package me.falconseeker.util;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Utils {

	private Utils() {}
	
	/**
	 * 
	 * Add color codes & to a String
	 * 
	 * @param s - String to be converted
	 * @return - Returns a String
	 */
	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	/**
	 * 
	 * Creates a randomed value note between min and max values
	 * 
	 * @param min - Minimum amount of money
	 * @param max - Max amount of money
	 * @param signer - Signer of the note
	 * @return - Returns an ItemStack
	 */
	public static ItemStack randomNote(int min, int max, String signer) {
		Random ran = new Random();
		int random_int = ran.nextInt((max-min) + 1) + min;
		
		return createNote(random_int, signer);
	}
	/**
	 * 
	 * Determines if chance procs (out of 100)
	 * 
	 * @param chance - int Percentage out of 100
	 * @return - Returns true if the chance procs and false if it didnt
	 */
	public static boolean random(int chance) {
		Random ran = new Random();
		int random_int = ran.nextInt((100-0) + 1) + 0;
		
		if (random_int <= chance) return true;
		
		return false;
	}
	/**
	 * 
	 * Creates a money note with specified value
	 * 
	 * @param value - Amount of money to be added to the note
	 * @param signer - Signer of the note
	 * @return - Returns an ItemStack
	 */
	public static ItemStack createNote(int value, String signer) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(color("&dValue &f" + String.valueOf(value)));
		lore.add(color("&dSigner &7" + signer));
		
		ItemStack untagged_item = ItemBuilder.createItem("&b&lCosmic Note &7(Right Click)", Material.PAPER, lore, 1);
		
		return XTags.setItemTag(untagged_item, value, "Value");
	}
	/**
	 * 
	 * Creates an Experience Bottle (Throwable)
	 * 
	 * @param value - Amount of EXP to be generated
	 * @param signer - Signer of EXP Bottle
	 * @return - Returns an ItemStack
	 */
	public static ItemStack createEXP(int value, String signer) {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(color("&dValue &f" + String.valueOf(value) + " XP"));
		lore.add(color("&dEnchanter &7" + signer));
		
		ItemStack untagged_item = ItemBuilder.createItem("&a&lExperience Bottle &7(Throw)", Material.EXP_BOTTLE, lore, 1);
		
		return XTags.setItemTag(untagged_item, value, "Value");
	}
}
