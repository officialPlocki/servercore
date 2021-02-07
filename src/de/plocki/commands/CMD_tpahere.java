package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.BackEnd;
import de.plocki.utils.TeleportType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class CMD_tpahere
  implements CommandExecutor
{
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
    if (!(arg0 instanceof Player)) {
      arg0.sendMessage(String.valueOf(Settings.prefix) + "§7Du darfst dies nur als Spieler Ausführen!");
      return true;
    } 
    
    Player p = (Player)arg0;
    if (arg3.length == 0) {
      p.sendMessage(String.valueOf(Settings.prefix) + "§7Du musst einen Spieler Angeben!.");
      return true;
    } 
    
    Player t = Bukkit.getPlayer(arg3[0]);
    
    if (t == null) {
      p.sendMessage(String.valueOf(Settings.prefix) + "§7Spieler wurde nicht gefunden.");
      return true;
    } 
    
    BackEnd.tpRequest.put(t.getUniqueId(), p.getUniqueId());
    BackEnd.tpType.put(t.getUniqueId(), TeleportType.here);
    
    p.sendMessage(String.valueOf(Settings.prefix) + "§7Die Anfrage wurde versendet.");
    t.sendMessage(String.valueOf(Settings.prefix) + "§7" + p.getName() + " §7möchte dass du dich zu ihm teleportieren.");
    t.sendMessage(String.valueOf(Settings.prefix) + "§aNehme die Anfrage mit §e/tpaccept §aan.");
    return true;
  }
}