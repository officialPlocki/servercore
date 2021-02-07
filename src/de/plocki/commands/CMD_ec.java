package de.plocki.commands;
import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_ec implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
      
            if (args.length == 0) {
		        if (!p.hasPermission(String.valueOf(Settings.permissionprefix) + ".ec")) {
		        	p.sendMessage(Settings.nopermission);
		        }
		        p.openInventory(p.getEnderChest());
            } else if (args.length == 1) {
            	if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".ec.other")) {
            		Player t = Bukkit.getPlayer(args[0]);
            		if (t != null) {
            			p.openInventory(t.getEnderChest());
            			p.sendMessage(String.valueOf(Settings.prefix) + "Du hast die Enderchest von §e" + t.getName() + " §7geöffnet.");
            		} else {
            			p.sendMessage(Settings.playernotonline);
            		} 
            	} else {
            		p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /ec");
            	} 
            } else {
            	p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /ec <Spieler>");
            } 
        } 
	    return true;
	}
}