package me.falconseeker.cosmic.commands.subcommands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.commands.CommandInterface;
import me.falconseeker.util.EMobs;
import net.md_5.bungee.api.ChatColor;

public class CommandSummon implements CommandInterface {

	@Override
	public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, Cosmic main) {
		if (args.length < 2) {
			p.sendMessage(ChatColor.RED + "Not enough arguments!");
			return true;
		}
		if (args[1].equalsIgnoreCase("endermonster")) {
			EMobs.spawnEnderMonster(p.getLocation());
			p.sendMessage(ChatColor.GREEN + "Creature summoned!");
			return true;
		}
	    if (args[1].equalsIgnoreCase("creeper")){
			EMobs.spawnCreeper(p.getLocation());
			p.sendMessage(ChatColor.GREEN + "Creature summoned!");
			return true;
		}
		else {
			p.sendMessage(ChatColor.RED + "Valid end mob types are: 'endermonster' and 'creeper'!");
			return true;
		}
	}

}
