package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_feed
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player p = (Player)sender;
    
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".feed")) {
      if (args.length == 0) {
        p.setFoodLevel(20);
        p.sendMessage(String.valueOf(Settings.prefix) + "Du wurdest gefüttert.");
      } else if (args.length == 1) {
        Bukkit.getPlayer(args[0]).setFoodLevel(20);
        p.sendMessage(String.valueOf(Settings.prefix) + "Du hast §b" + args[0] + "§7 gefüttert.");
      } else {
        p.sendMessage(String.valueOf(Settings.prefix) + "Bitte verwende: §e/feed <Spieler>");
      } 
    } else {
      p.sendMessage(Settings.nopermission);
    } 
    
    return false;
  }
}