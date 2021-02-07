package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_fly
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".fly")) {
      if (!p.getAllowFlight()) {
        p.setAllowFlight(true);
        p.sendMessage(String.valueOf(Settings.prefix) + "Du kannst nun Fliegen!");
        return false;
      } 
      p.setAllowFlight(false);
      p.sendMessage(String.valueOf(Settings.prefix) + "Du kannst nun nicht mehr Fliegen!");
    } else {
      
      p.sendMessage(Settings.nopermission);
    } 
    
    return false;
  }
}