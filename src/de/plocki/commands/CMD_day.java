package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_day implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player)sender;
		if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".day")) {
		      p.sendMessage(String.valueOf(Settings.prefix) + "Die Zeit wurde auf Tag gestellt!");
		      p.getWorld().setTime(2000L);
		      return false;
		} 
	    p.sendMessage(Settings.nopermission);
	    return false;
	  }
}
