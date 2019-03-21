package me.falconseeker.cosmic.commands.subcommands.money;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.commands.CommandInterface;
import me.falconseeker.util.Utils;
import net.md_5.bungee.api.ChatColor;

public class CommandGiveMoney implements CommandInterface {

	@Override
	public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, Cosmic main) {
		if (!p.hasPermission("falconseeker.cosmic.givemoney")) {
			p.sendMessage(ChatColor.RED + "No permission!");
			return true;
		}
		if (args.length < 2) {
			p.sendMessage(ChatColor.RED + "Not enough arguments!");
			return true;
		}
		int num = 0;

		try {
		  num = Integer.parseInt(args[1]);
		} catch (NumberFormatException ex){
		  p.sendMessage(ChatColor.RED + "Invalid Useage!");
		  return true;
		}
		p.getInventory().addItem(Utils.createNote(num, p.getName()));
		p.sendMessage(ChatColor.GREEN + "Note created!");
		return true;
	}

}
