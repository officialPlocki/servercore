package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_msg
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
    if (s instanceof Player) {
      Player p = (Player)s;
      if (args.length >= 2) {
        Player t = Bukkit.getPlayer(args[0]);
        String msg = "";
        for (int i = 1; i < args.length; i++) {
          msg = String.valueOf(msg) + args[i] + " ";
        }
        if (t != null) {
          p.sendMessage("§cMSG §7| §7Du §e" + args[0] + " §7 -> §c" + msg);
          t.sendMessage("§cMSG §7| §e" + p.getName() + "§7 -> §c" + msg);
        } else {
          p.sendMessage(Settings.playernotonline);
        } 
      } else {
        p.sendMessage("§6§lEhren§fGames §7| Bitte verwende: §7/msg <Spieler> <Nachricht>");
      } 
    } 
    return false;
  }
}