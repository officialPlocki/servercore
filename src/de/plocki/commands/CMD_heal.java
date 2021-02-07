package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_heal
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".heal")) {
        if (args.length == 0) {
          p.setHealth(20.0D);
          p.setFoodLevel(20);
          p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast dich geheilt.");
        } else if (args.length == 1) {
          if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".heal.other")) {
            Player t = Bukkit.getPlayer(args[0]);
            if (t != null) {
              t.setHealth(20.0D);
              t.setFoodLevel(20);
              t.sendMessage(String.valueOf(Settings.prefix) + "§7Du wurdest geheilt.");
              p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast §e" + t.getName() + " §7geheilt.");
            } else {
              p.sendMessage(Settings.playernotonline);
            } 
          } else {
            p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /heal");
          } 
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /heal <Spieler>");
        } 
      } else {
        p.sendMessage(Settings.nopermission);
      } 
    } 
    return true;
  }
}