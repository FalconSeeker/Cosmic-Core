package me.falconseeker.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	public static int randomInt(int min, int max) {
		Random ran = new Random();
		int randomInt = ran.nextInt((max-min) + 1) + min;
		return randomInt;
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
	public static ItemStack randomNote(int min, int max, String signer) {		//Method being removed in future update
		return createNote(randomInt(min, max), signer);
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
		
		ItemStack untaggedItem = ItemBuilder.createItem("&b&lCosmic Note &7(Right Click)", Material.PAPER, lore, 1);
		
		return XTags.setItemTag(untaggedItem, value, "Value");
	}
	/**
	 * 
	 * Creates an Experience Bottle (Throwable)
	 * 
	 * @param value - Amount of EXP to be generated
	 * @param signer - Signer of EXP Bottle
	 * @return - Returns an ItemStack
	 */
	public static ItemStack createEXP(int value, String signer) { //I used color() so I can add future config support with ease
		ItemStack untaggedItem = ItemBuilder.createItem("&a&lExperience Bottle &7(Throw)", Material.EXP_BOTTLE, Arrays.asList(color("&dValue &f" + String.valueOf(value) + " XP"), color("&dEnchanter &7" + signer)), 1);
		return XTags.setItemTag(untaggedItem, value, "Value");
	}

    public static String numural(int number) {
        String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] numbers = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int i = 0; i < numbers.length; i++) {
            if (number >= numbers[i]) {
                return symbols[i] + numural(number - numbers[i]);
            }
        }
        return "";
    }
 
    public static int unnumural(String number) {
        String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] numbers = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int i = 0; i < symbols.length; i++) {
            if (number.startsWith(symbols[i])) {
                return numbers[i] + unnumural(number.replaceFirst(symbols[i], ""));
            }
        }
        return 0;
    }
    public static List<String> colorAll(List<String> s) {
    	List<String> colored = new ArrayList<>();
    	s.forEach(color -> colored.add(ChatColor.translateAlternateColorCodes('&', color)));
		return colored;
    	
    }
}
