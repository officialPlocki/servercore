package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.EconomyUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_pay
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      if (args.length == 0) {
        p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /pay <Spieler> <Anzahl>");
        return false;
      }  if (args.length == 1) {
        p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /pay <Spieler> <Anzahl>");
        return false;
      }  if (args.length == 2) {
        if (args[0].equalsIgnoreCase("*")) {
          if (EconomyUtils.getCoins(p).intValue() == Bukkit.getOnlinePlayers().size() * Integer.valueOf(args[1]).intValue() || EconomyUtils.getCoins(p).intValue() >= Bukkit.getOnlinePlayers().size() * Integer.valueOf(args[1]).intValue()) {
            p.sendMessage(String.valueOf(Settings.prefix) + "Du hast erfolgreich §e" + args[1] + Settings.value + "§7 an jeden Spieler gegeben!");
            EconomyUtils.removeCoins(p, Integer.valueOf(Bukkit.getOnlinePlayers().size() * Integer.valueOf(args[1]).intValue()));
            for (Player all : Bukkit.getOnlinePlayers()) {
              EconomyUtils.addCoins(p, Integer.valueOf(args[1]));
              all.sendMessage(String.valueOf(Settings.prefix) + "Du hast von §b" + p.getName() + " §e" + args[1] + Settings.value + "§7 erhalten!");
            } 
            return true;
          } 
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast nicht genügend Geld!");
          return false;
        } 
        
        if (!Bukkit.getPlayer(args[0]).isOnline()) {
          p.sendMessage(Settings.playernotonline);
          return false;
        }  if (Bukkit.getPlayer(args[0]).isOnline()) {
          if (EconomyUtils.getCoins(p) == Integer.valueOf(args[1]) || EconomyUtils.getCoins(p).intValue() >= Integer.valueOf(args[1]).intValue()) {
            p.sendMessage(String.valueOf(Settings.prefix) + "Du hast erfolgreich §e" + args[1] + Settings.value + "§7 an §b" + args[0] + " §7gegeben!");
            Bukkit.getPlayer(args[0]).sendMessage(String.valueOf(Settings.prefix) + "Du hast von §b" + p.getName() + " §e" + args[1] + Settings.value + "§7 erhalten!");
            EconomyUtils.removeCoins(p, Integer.valueOf(args[1]));
            EconomyUtils.addCoins(Bukkit.getPlayer(args[0]), Integer.valueOf(args[1]));
            return true;
          } 
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast nicht genügend Geld!");
          return false;
        } 
        
        p.sendMessage(Settings.playernotonline);
        return false;
      } 
      
      p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /pay <Spieler> <Anzahl>");
      return false;
    } 
    
    return false;
  }
}