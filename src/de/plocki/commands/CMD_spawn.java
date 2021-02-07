package de.plocki.commands;

import de.plocki.utils.ConfigManager;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_spawn
  implements CommandExecutor
{
  public HashMap<String, Long> cooldowns = new HashMap<>();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    
    int cooldownTime = 60;
    if (this.cooldowns.containsKey(sender.getName())) {
      long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
      if (secondsLeft > 0L) {
        sender.sendMessage("Du musst erst " + secondsLeft + " Sekunden warten, bevor du diesen Befehl erneut benutzen kannst!");
        return false;
      } 
      Location loc = p.getLocation();
      double x = ConfigManager.cfg.getDouble("X");
      double y = ConfigManager.cfg.getDouble("Y");
      double z = ConfigManager.cfg.getDouble("Z");
      double yaw = ConfigManager.cfg.getDouble("Blickrichtung YAW");
      double pitch = ConfigManager.cfg.getDouble("Blickrichtung PITCH");
      String worldname = ConfigManager.cfg.getString("Weltname");
      
      World welt = Bukkit.getWorld(worldname);
      
      loc.setX(x);
      loc.setY(y);
      loc.setZ(z);
      loc.setYaw((float)yaw);
      loc.setPitch((float)pitch);
      loc.setWorld(welt);
      p.teleport(loc);
      p.sendMessage("§7Du wurdest zum Spawn teleportiert!");
    } 

    
    return false;
  }
}