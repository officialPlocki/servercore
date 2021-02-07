package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_gm
  implements CommandExecutor
{
  private static String usage = String.valueOf(Settings.prefix) + "Bitte verwende: §e/gamemode <0, 1, 2, 3>";
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".gamemode")) {
      if (args.length == 0) {
        p.sendMessage(usage);
      } else if (args.length == 1) {
        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("Überleben")) {
          if (!p.hasPermission(String.valueOf(Settings.permissionprefix) + ".gamemode.survival")) {
            p.sendMessage(Settings.nopermission);
            return false;
          } 
          p.setGameMode(GameMode.SURVIVAL);
          p.sendMessage(String.valueOf(Settings.prefix) + "Dein Spielmodus wurde auf §eÜberlebens §7geändert.");
        } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("kreativ")) {
          if (!p.hasPermission(String.valueOf(Settings.permissionprefix) + ".gamemode.creative")) {
            p.sendMessage(Settings.nopermission);
            return false;
          } 
          p.setGameMode(GameMode.CREATIVE);
          p.sendMessage(String.valueOf(Settings.prefix) + "Dein Spielmodus wurde auf §eKreativ §7geändert.");
        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("abenteuer")) {
          if (!p.hasPermission(String.valueOf(Settings.permissionprefix) + ".gamemode.adventure")) {
            p.sendMessage(Settings.nopermission);
            return false;
          } 
          p.setGameMode(GameMode.ADVENTURE);
          p.sendMessage(String.valueOf(Settings.prefix) + "Dein Spielmodus wurde auf §eAbenteuer §7geändert.");
        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("zuschauer")) {
         if (!p.hasPermission(String.valueOf(Settings.permissionprefix) + ".gamemode.spectator")) {
            p.sendMessage(Settings.nopermission);
            return false;
          } 
          p.setGameMode(GameMode.SPECTATOR);
          p.sendMessage(String.valueOf(Settings.prefix) + "Dein Spielmodus wurde auf §eZuschauer Modus §7geändert.");
        } else {
          p.sendMessage(usage);
        } 
      } else if (args.length >= 1) {
        p.sendMessage(usage);
      } 
    } else {
      p.sendMessage(Settings.nopermission);
    } 
    
    return false;
  }
}