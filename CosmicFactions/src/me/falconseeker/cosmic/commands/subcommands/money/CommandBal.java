package me.falconseeker.cosmic.commands.subcommands.money;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.falconseeker.cosmic.Cosmic;
import me.falconseeker.cosmic.commands.CommandInterface;
import me.falconseeker.util.Utils;
import net.md_5.bungee.api.ChatColor;

public class CommandBal implements CommandInterface {

	@Override
	public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, Cosmic main) {
		if (!p.hasPermission("falconseeker.cosmic.bal")) {
			p.sendMessage(ChatColor.RED + "No permission!");
			return true;
		}
		if (args.length >= 2) {
			if (Bukkit.getPlayer(args[1]) == null) {
				p.sendMessage(ChatColor.RED + "This player is not online!");
				return true;
			}
			Player target = Bukkit.getPlayer(args[1]);
			p.sendMessage(ChatColor.GREEN + target.getName() + " has a balance of: " + String.valueOf(main.getMoney().getMoney(target)));
			return true;
		}
		p.sendMessage(ChatColor.GREEN + "Your current balance is: " + String.valueOf(main.getMoney().getMoney(p)));
		return true;
	}

}
