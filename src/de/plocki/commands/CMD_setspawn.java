package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.ConfigManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_setspawn
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (!ConfigManager.cfg.getBoolean("Command.Setspawn")) {
      return false;
    }
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".setspawn")) {
      Location loc = p.getLocation();
      
      double x = loc.getX();
      double y = loc.getY();
      double z = loc.getZ();
      double yaw = loc.getYaw();
      double pitch = loc.getPitch();
      String worldname = loc.getWorld().getName();
      
      ConfigManager.cfg.set("X", Double.valueOf(x));
      ConfigManager.cfg.set("Y", Double.valueOf(y));
      ConfigManager.cfg.set("Z", Double.valueOf(z));
      ConfigManager.cfg.set("Blickrichtung YAW", Double.valueOf(yaw));
      ConfigManager.cfg.set("Blickrichtung PITCH", Double.valueOf(pitch));
      ConfigManager.cfg.set("Weltname", worldname);
      ConfigManager.saveConfig();
    } else {
      p.sendMessage(Settings.nopermission);
    } 
    
    return false;
  }
}