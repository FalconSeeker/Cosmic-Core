package me.falconseeker.cosmic;

import org.bukkit.plugin.java.JavaPlugin;

import me.falconseeker.cosmic.commands.BaseCommand;
import me.falconseeker.cosmic.commands.CommandHandler;
import me.falconseeker.cosmic.commands.subcommands.CommandSummon;
import me.falconseeker.cosmic.commands.subcommands.money.CommandBal;
import me.falconseeker.cosmic.commands.subcommands.money.CommandGiveMoney;
import me.falconseeker.cosmic.commands.subcommands.money.CommandWithdraw;
import me.falconseeker.cosmic.enchantments.EnchantmentManager;
import me.falconseeker.cosmic.enchantments.books.BookApply;
import me.falconseeker.cosmic.enchantments.books.BookRedeem;
import me.falconseeker.cosmic.end.endmonsters.*;
import me.falconseeker.cosmic.end.listeners.CustomMobs;
import me.falconseeker.cosmic.end.listeners.EndPortals;
import me.falconseeker.cosmic.end.listeners.MobHealth;
import me.falconseeker.cosmic.money.Money;
import me.falconseeker.cosmic.money.listeners.MoneyClick;
import me.falconseeker.util.events.ArmorListener;

public class Cosmic extends JavaPlugin {

	private Money money;
	private EnchantmentManager enchantmentProc;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);

		this.money = new Money(this);
		this.enchantmentProc = new EnchantmentManager(this);
		
		new EndPortals(this);
		new CustomMobs(this);
		new MoneyClick(this);
		new MobHealth(this);
		new BookApply(this);
		new BookRedeem(this);
		
		EntityRegister.registerCustomEntity(5, "EndMonster", EnderMonster.class);
		EntityRegister.registerCustomEntity(50, "EndCreeper", EnderCreeper.class);
		
        CommandHandler handler = new CommandHandler(this);

        handler.register("cosmic", new BaseCommand());
        handler.register("summon", new CommandSummon());
        handler.register("withdraw", new CommandWithdraw());
        handler.register("bal", new CommandBal());
        handler.register("givemoney", new CommandGiveMoney());

        getCommand("cosmic").setExecutor(handler);
        
	}
	@Override
	public void onDisable() {
		//TODO: Auto generated stub
	}
	public Money getMoney() {
		return money;
	}  
	public EnchantmentManager getEnchantManager() {
		return enchantmentProc;
	}
}
