package me.falconseeker.cosmic;

import org.bukkit.plugin.java.JavaPlugin;

import me.falconseeker.cosmic.commands.BaseCommand;
import me.falconseeker.cosmic.commands.CommandHandler;
import me.falconseeker.cosmic.commands.subcommands.CommandSummon;
import me.falconseeker.cosmic.end.listeners.EndPortals;
import me.falconseeker.end.endmonsters.*;

public class Cosmic extends JavaPlugin {

	@Override
	public void onEnable() {
		new EndPortals(this);
		
		EntityRegister.registerCustomEntity(51, "EnderMonster", EMobEnderMonster.class);
		EntityRegister.registerCustomEntity(50, "EndCreeper", EMobCreepers.class);
		
        CommandHandler handler = new CommandHandler();

        handler.register("cosmic", new BaseCommand());
        handler.register("summon", new CommandSummon());
 
        getCommand("cosmic").setExecutor(handler);
        
	}
	@Override
	public void onDisable() {
		
	}
}
