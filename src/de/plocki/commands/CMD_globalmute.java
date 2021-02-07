package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CMD_globalmute
  implements CommandExecutor, Listener
{
  @EventHandler
  public static void onChat2(AsyncPlayerChatEvent e) {
    if (ConfigManager.cfg.getBoolean("Globalmute")) {
      if (e.getPlayer().hasPermission(String.valueOf(Settings.permissionprefix) + ".globalmute.bypass")) {
        e.getPlayer().sendMessage(String.valueOf(Settings.prefix) + "Der Globalmute ist aktiviert. Du hast genügend Rechts um weiterhin zu schreiben.");
        return;
      } 
      e.setCancelled(true);
      e.getPlayer().sendMessage(String.valueOf(Settings.prefix) + "Der Globalmute ist aktiviert.");
    } 
  }


  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    Player p = (Player)sender;
    
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".globalmute")) {
      if (args.length == 0) {
        if (ConfigManager.cfg.getBoolean("Globalmute")) {
          ConfigManager.cfg.set("Globalmute", Boolean.valueOf(false));
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast den Chat deaktiviert!");
          Bukkit.broadcastMessage(String.valueOf(Settings.prefix) + "Der Globalmute wurde von §e" + p.getName() + " §cdeaktiviert!");
        } else {
          ConfigManager.cfg.set("Globalmute", Boolean.valueOf(true));
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast den Globalen-Chat aktiviert!");
          Bukkit.broadcastMessage(String.valueOf(Settings.prefix) + "Der Globalmute wurde von §e" + p.getName() + " §caktiviert!");
        } 
      } else {
        p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /globalmute");
      } 
    } else {
      p.sendMessage(Settings.nopermission);
    } 
    return true;
  }
}