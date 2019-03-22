package me.falconseeker.cosmic.enchantments;

import static org.bukkit.ChatColor.RESET;

public enum Tier {
	
	SIMPLE("&f"), 
	UNIQUE("&a"),
	ELITE("&b"), 
	ULTIMATE("&e"), 
	LEGENDARY("&6"), 
	SOUL("&c"), 
	HEROIC("&d");
	
    private final String color;
    
    Tier(String... tier)
    {
        if (tier == null || tier.length == 0) { color = ""; return; }
        StringBuilder builder = new StringBuilder();
        for (String m : tier) builder.append(RESET.toString()).append(m);
        this.color = builder.toString();
    }
    
    public String getColor() { return color; }
}
