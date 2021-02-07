package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CMD_tpaall
  implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".tpall")) {
        if (args.length == 0) {
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.teleport((Entity)p);
            all.sendMessage(String.valueOf(Settings.prefix) + "§7Alle Spieler wurden von §e" + p.getName() + " §7teleportiert.");
          } 
          int spieler = Bukkit.getOnlinePlayers().size() - 1;
          p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast §c" + spieler + " §7zu dir teleportiert.");
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "§cBenutze: /tpall");
        } 
      } else {
        p.sendMessage(Settings.nopermission);
      } 
    } 
    return true;
  }
}