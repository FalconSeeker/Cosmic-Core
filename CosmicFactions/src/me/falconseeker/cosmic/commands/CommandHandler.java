package me.falconseeker.cosmic.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.falconseeker.cosmic.Cosmic;
import net.md_5.bungee.api.ChatColor;
 
public class CommandHandler implements CommandExecutor
{
 
    private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();
    private Cosmic main;
    
    public CommandHandler(Cosmic main) {
    	this.main = main;
    }
    public void register(String name, CommandInterface cmd) {
        commands.put(name, cmd);
    }
 
    public boolean exists(String name) {
         return commands.containsKey(name);
    }
     public CommandInterface getExecutor(String name) {
         return commands.get(name);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
         if(sender instanceof Player) {
        	Player p = (Player) sender;
        	
            if(args.length == 0) {
                getExecutor("cosmic").onCommand(p, cmd, commandLabel, args, main);
                return true;
            }
             if(args.length > 0) {
                 if(exists(args[0])){
                     getExecutor(args[0]).onCommand(p, cmd, commandLabel, args, main);
                    return true;
                } else {
                     sender.sendMessage(ChatColor.RED + "This command was not found. Please try again!");
                    return true;
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only players may use this command!");
        	return true;
        }
        return false;
    }
 
}
 
