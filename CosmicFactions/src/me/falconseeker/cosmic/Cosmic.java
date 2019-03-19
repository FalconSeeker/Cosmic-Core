package me.falconseeker.cosmic;

import org.bukkit.plugin.java.JavaPlugin;

import me.falconseeker.cosmic.commands.BaseCommand;
import me.falconseeker.cosmic.commands.CommandHandler;
import me.falconseeker.cosmic.commands.subcommands.CommandSummon;
import me.falconseeker.cosmic.end.listeners.CustomMobs;
import me.falconseeker.cosmic.end.listeners.EndPortals;
import me.falconseeker.cosmic.money.Money;
import me.falconseeker.cosmic.money.listeners.MoneyClick;
import me.falconseeker.end.endmonsters.*;

public class Cosmic extends JavaPlugin {

	private Money money;
	
	@Override
	public void onEnable() {
		this.money = new Money(this);
		
		new EndPortals(this);
		new CustomMobs(this);
		new MoneyClick(this);
		
		EntityRegister.registerCustomEntity(5, "EndMonster", EnderMonster.class);
		EntityRegister.registerCustomEntity(50, "EndCreeper", EnderCreeper.class);
		
        CommandHandler handler = new CommandHandler();

        handler.register("cosmic", new BaseCommand());
        handler.register("summon", new CommandSummon());
 
        getCommand("cosmic").setExecutor(handler);
        
	}
	@Override
	public void onDisable() {
		
	}
	public Money getMoney() {
		return money;
	}
}
