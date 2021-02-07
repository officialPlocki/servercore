package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.EconomyUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD_eco implements CommandExecutor{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".eco")) {
      if (args.length == 0) {
        p.sendMessage("§e§lEco Hilfe");
        p.sendMessage("§c");
        p.sendMessage("§e/eco set <Spieler> <Geld>");
        p.sendMessage("§e/eco give <Spieler> <Geld>");
        p.sendMessage("§e/eco take <Spieler> <Geld>");
        p.sendMessage("§e/eco reset <Spieler>");
        p.sendMessage("§c");
        return false;
      }  if (args.length == 1) {
        p.sendMessage("§e§lEco Hilfe");
        p.sendMessage("§c");
        p.sendMessage("§e/eco set <Spieler> <Geld>");
        p.sendMessage("§e/eco give <Spieler> <Geld>");
        p.sendMessage("§e/eco take <Spieler> <Geld>");
        p.sendMessage("§e/eco reset <Spieler>");
        p.sendMessage("§c");
        return false;
      }  if (args.length == 2) {
        if (args[0].equalsIgnoreCase("reset")) {
          p.sendMessage(Settings.resetMoney(Bukkit.getPlayer(args[1])));
          EconomyUtils.resetCoins(Bukkit.getPlayer(args[1]));
          return false;
        } 
        p.sendMessage("§e§lEco Hilfe");
        p.sendMessage("§c");
        p.sendMessage("§e/eco set <Spieler> <Geld>");
        p.sendMessage("§e/eco give <Spieler> <Geld>");
        p.sendMessage("§e/eco take <Spieler> <Geld>");
        p.sendMessage("§e/eco reset <Spieler>");
        p.sendMessage("§c");
        return false;
      } 
      if (args.length == 3) {
        if (args[0].equalsIgnoreCase("set")) {
          p.sendMessage(Settings.setMoney(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2])));
          EconomyUtils.setCoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
          return false;
        }  if (args[0].equalsIgnoreCase("give")) {
          p.sendMessage(Settings.giveMoney(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2])));
          EconomyUtils.addCoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
          return false;
        }  if (args[0].equalsIgnoreCase("take")) {
          p.sendMessage(Settings.takeMoney(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2])));
          EconomyUtils.removeCoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
          return false;
        } 
      } 
    } else {
      p.sendMessage(Settings.nopermission);
    } 
    return false;
  }
}
