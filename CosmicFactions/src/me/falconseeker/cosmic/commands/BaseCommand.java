package me.falconseeker.cosmic.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
 
public class BaseCommand implements CommandInterface
{
 
    @Override
    public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args) {        
        p.sendMessage(ChatColor.GREEN + "Plugin made by Falcon_Seeker, premium download coming soon!");
        return true;
    }
}