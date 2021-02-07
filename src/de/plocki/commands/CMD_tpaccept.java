package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.BackEnd;
import de.plocki.utils.TeleportType;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CMD_tpaccept
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(String.valueOf(Settings.prefix) + "§7Du darfst dies nur als Spieler Ausführen!");
      return true;
    } 
    Player p = (Player)sender;
    if (!BackEnd.tpRequest.containsKey(p.getUniqueId())) {
      p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast keine Anfrage erhalten.");
      return true;
    } 
    
    Player t = Bukkit.getPlayer((UUID)BackEnd.tpRequest.get(p.getUniqueId()));
    
    if (t == null) {
      p.sendMessage(String.valueOf(Settings.prefix) + "§7Dieser Spieler ist offline.");
      BackEnd.tpRequest.remove(p.getUniqueId());
      BackEnd.tpType.remove(p.getUniqueId());
      return true;
    } 
    
    TeleportType tpType = (TeleportType)BackEnd.tpType.get(p.getUniqueId());
    
    if (tpType == TeleportType.Normal) {
      t.teleport((Entity)p);
    } else {
      p.teleport((Entity)t);
    } 
    
    BackEnd.tpRequest.remove(p.getUniqueId());
    BackEnd.tpType.remove(p.getUniqueId());
    
    return true;
  }
}