package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_money
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (args.length == 0) {
      p.sendMessage(Settings.moneyMessage(p));
      return false;
   }
    if ((((args.length == 1) ? 1 : 0) | ((args.length >= 1) ? 1 : 0)) != 0) {
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".money.other")) {
    	  if (Bukkit.getPlayer(args[0]).isOnline()) {
          p.sendMessage(Settings.moneyMessage(Bukkit.getPlayer(args[0])));
          return false;
        } 
        p.sendMessage(Settings.playernotonline);
      } else {
        
        p.sendMessage(Settings.nopermission);
      } 
    }
    return false;
  }
}