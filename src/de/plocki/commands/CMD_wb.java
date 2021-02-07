package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class CMD_wb
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!sender.hasPermission(String.valueOf(Settings.permissionprefix) + ".workbench")) {
      sender.sendMessage(Settings.nopermission);
      return false;
    } 
    
    Player p = (Player)sender;
    
    p.openWorkbench(null, true);
    
    return false;
  }
}