package de.plocki.commands;

import de.plocki.main.Main;
import de.plocki.main.Settings;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_forcefield
  implements CommandExecutor
{
  private final Main plugin;
  
  public CMD_forcefield(Main plugin) {
/* 19 */     this.plugin = plugin;
  }

  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player player = (Player)sender;
    if (sender instanceof Player) {
      
      if (player.hasPermission(String.valueOf(Settings.permissionprefix) + ".forcefield")) {
        if (!(getPlugin()).FORCE_FIELDS.contains(player)) {
          (getPlugin()).FORCE_FIELDS.add(player);
          
          player.sendMessage(String.valueOf(Settings.prefix) + "ForceField wurde aktiviert.");
        } else {
          (getPlugin()).FORCE_FIELDS.remove(player);
          
          player.sendMessage(String.valueOf(Settings.prefix) + "ForceField wurde deaktiviert.");
        } 
      } else {
        player.sendMessage(Settings.nopermission);
      } 
    } else {
      player.sendMessage(String.valueOf(Settings.prefix) + "Nur Spieler können diesen Befehl ausführen ...");
    } 
    return true;
  }
  
  public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
    return Collections.emptyList();
  }
  
  private Main getPlugin() {
    return this.plugin;
  }
}
