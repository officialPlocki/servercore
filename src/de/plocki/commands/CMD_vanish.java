package de.plocki.commands;

import de.plocki.main.Settings;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_vanish
  implements CommandExecutor
{
  public static ArrayList<Player> vanished = new ArrayList<>();
  public static ArrayList<Player> chat = new ArrayList<>();

  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".vanish")) {
        if (args.length == 0) {
          if (!vanished.contains(p)) {
            vanished.add(p);
            chat.add(p);
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Du bist nun im Vanish.");
            for (Player all : Bukkit.getOnlinePlayers()) {
              if (!all.hasPermission(String.valueOf(Settings.permissionprefix) + ".vanish.bypass")) {
                all.hidePlayer(p);
              }
            } 
          } else {
            vanished.remove(p);
            chat.remove(p);
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Du bist nun nicht mehr im Vanish.");
            for (Player all : Bukkit.getOnlinePlayers()) {
              all.showPlayer(p);
            }
          } 
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "§cBenutze: /vanish");
        } 
      } else {
        p.sendMessage(Settings.playernotonline);
      } 
    } 
    return true;
  }
}