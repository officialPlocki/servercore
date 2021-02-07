package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.ConfigManager;
import de.plocki.utils.VoteEconomyUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class CMD_ecovote implements CommandExecutor{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".ecovote")) {
      if (args.length == 0) {
        p.sendMessage("§e§lEcoVote Hilfe");
        p.sendMessage("§c");
        p.sendMessage("§e/ecovote set <Spieler> <Geld>");
        p.sendMessage("§e/ecovote give <Spieler> <Geld>");
        p.sendMessage("§e/ecovote take <Spieler> <Geld>");
        p.sendMessage("§e/ecovote reset <Spieler>");
        p.sendMessage("§c");
        return false;
      }  if (args.length == 1) {
        p.sendMessage("§e§lEcoVote Hilfe");
        p.sendMessage("§c");
        p.sendMessage("§e/ecovote set <Spieler> <Geld>");
        p.sendMessage("§e/ecovote give <Spieler> <Geld>");
        p.sendMessage("§e/ecovote take <Spieler> <Geld>");
        p.sendMessage("§e/ecovote reset <Spieler>");
        p.sendMessage("§c");
        return false;
      }  if (args.length == 2) {
        if (args[0].equalsIgnoreCase("reset")) {
          if (Bukkit.getPlayer(args[1]).isOnline()) {
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.votecoinname + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden zurückgesetzt.");
            VoteEconomyUtils.resetvotecoins(Bukkit.getPlayer(args[1]));
            return false;
          } 
          p.sendMessage(Settings.playernotonline);
          return false;
        } 
        p.sendMessage("§e§lEcoVote Hilfe");
        p.sendMessage("§c");
        p.sendMessage("§e/ecovote set <Spieler> <Geld>");
        p.sendMessage("§e/ecovote give <Spieler> <Geld>");
        p.sendMessage("§e/ecovote take <Spieler> <Geld>");
        p.sendMessage("§e/ecovote reset <Spieler>");
        p.sendMessage("§c");
        return false;
      } 
      if (args.length == 3) {
        if (args[0].equalsIgnoreCase("set")) {
          if (Bukkit.getPlayer(args[1]).isOnline()) {
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.votecoinname + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden auf §e" + args[2] + " " + Settings.votecoinname + "§7 gesetzt.");
            ConfigManager.data.set("Player." + p.getUniqueId().toString() + ".VoteCoins", Integer.valueOf(args[2]));
            VoteEconomyUtils.setvotecoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
            return false;
          } 
          p.sendMessage(Settings.playernotonline);
          return false;
        } 
        if (args[0].equalsIgnoreCase("give")) {
           if (Bukkit.getPlayer(args[1]).isOnline()) {
             p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.votecoinname + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden " + args[2] + " " + Settings.votecoinname + " hinzugefügt.");
             VoteEconomyUtils.addvotecoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
             return false;
          } 
           p.sendMessage(Settings.playernotonline);
           return false;
        } 
         if (args[0].equalsIgnoreCase("take")) {
           if (Bukkit.getPlayer(args[1]).isOnline()) {
             p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.votecoinname + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden " + args[2] + " " + Settings.votecoinname + " entfernt.");
             VoteEconomyUtils.removevotecoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
             return false;
           }
          p.sendMessage(Settings.playernotonline);
          return false;
        } 
      } 
    } else {
      p.sendMessage(Settings.nopermission);
    } 
	return false;
}
}