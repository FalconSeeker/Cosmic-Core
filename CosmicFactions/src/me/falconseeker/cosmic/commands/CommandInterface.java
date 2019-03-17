package me.falconseeker.cosmic.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
 
public interface CommandInterface  {
 
    public boolean onCommand(Player p, Command cmd, String commandLabel, String[] args);
 
}
