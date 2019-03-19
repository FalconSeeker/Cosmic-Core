package me.falconseeker.cosmic.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.falconseeker.cosmic.Cosmic;
 
public class BaseCommand implements CommandInterface
{
 
    @Override
    public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args, Cosmic main) {        
        p.sendMessage(ChatColor.GREEN + "Plugin made by Falcon_Seeker, premium download coming soon!");
        return true;
    }
}