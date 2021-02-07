package de.plocki.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.plocki.main.Settings;

public class CMD_clear implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player)sender;
		
		if(p.hasPermission(Settings.permissionprefix+".clear")) {
			if(args.length==0) {
				p.getInventory().clear();
				p.sendMessage(Settings.prefix+"Du hast dein Inventar geleert!");
				return true;
			} else if(args.length==2) {
				if(Bukkit.getPlayer(args[0]).hasPermission(Settings.permissionprefix+".clear.bypass")) {
					p.sendMessage(Settings.prefix+"Du kannst das Inventar von diesem Spieler nicht leeren!");
					return false;
				} else {
					p.sendMessage(Settings.prefix+"Du hast das Inventar von §e" + args[0] + " §7geleert!");
					Bukkit.getPlayer(args[0]).getInventory().clear();
				}
			}
		}
		
		return false;
	}

}
