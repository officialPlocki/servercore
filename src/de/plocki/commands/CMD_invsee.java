package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CMD_invsee
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".invsee")) {
        if (args.length == 1) {
          Player t = Bukkit.getPlayer(args[0]);
          if (t != null) {
            p.openInventory((Inventory)t.getInventory());
          } else {
            p.sendMessage(Settings.playernotonline);
          } 
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /invsee <Spieler>");
        } 
      } else {
        p.sendMessage(Settings.nopermission);
      } 
    } 
    return true;
  }
}