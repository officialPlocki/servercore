package de.plocki.commands;

import de.plocki.main.Settings;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class CMD_freeze
  implements CommandExecutor, Listener
{
  public static ArrayList<String> freeze = new ArrayList<>();
  
  @EventHandler
  public static void onMove(PlayerMoveEvent e) {
    if (freeze.contains(e.getPlayer().getName())) {
      e.setCancelled(true);
    }
  }


  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".freeze")) {
        if (args.length == 0) {
          p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /freeze <Spieler>");
        } else if (args.length == 1) {
          Player z = Bukkit.getPlayer(args[0]);
          if (freeze.contains(z.getName())) {
            freeze.remove(z.getName());
            z.sendTitle("§c§lAchtung", "§6Du bist nun nicht mehr eingefrohren!");
            z.sendMessage(String.valueOf(Settings.prefix) + "§7Du kannst dich nun wieder bewegen!");
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Der Spieler ist nun nicht mehr §eeingefrohren");
          } else {
            freeze.add(z.getName());
            z.sendTitle("§c§lAchtung", "§6Du wurdest eingefrohren!");
            z.sendMessage(String.valueOf(Settings.prefix) + "Du kannst dich nicht mehr bewegen!");
            p.sendMessage(String.valueOf(Settings.prefix) + "Der Spieler ist nun §eeingefrohren");
          } 
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Benutze: /freeze <Spieler>");
        }
      
      } else {
        
        p.sendMessage(Settings.nopermission);
      } 
    } 
    return true;
  }
}