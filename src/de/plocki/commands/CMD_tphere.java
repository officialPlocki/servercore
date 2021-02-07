package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CMD_tphere
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".tphere")) {
        if (args.length == 1) {
          Player t = Bukkit.getPlayer(args[0]);
          if (t != null) {
            t.teleport((Entity)p);
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast §e" + t.getName() + " §7zu dir teleportiert.");
            t.sendMessage(String.valueOf(Settings.prefix) + "§7Du wurdest zu §e" + p.getName() + " §7teleportiert.");
          } else {
            p.sendMessage(Settings.playernotonline);
          } 
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "§cBenutze: /tphere <Spieler>");
        } 
      } else {
        p.sendMessage(Settings.nopermission);
      } 
    } 
    return true;
  }
}


/* Location:              /home/plocki/Downloads/ServerCore.jar!/de/plocki/commands/CMD_tphere.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */