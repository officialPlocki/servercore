package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;




public class CMD_kopf
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    Player p = (Player)sender;
    
    if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".skull")) {
      if (args.length == 0) {
        p.sendMessage(String.valueOf(Settings.prefix) + "Bitte verwende: §e/kopf <Spieler>");
        return false;
      }  if (args.length == 1) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullmeta = (SkullMeta)skull.getItemMeta();
        skullmeta.setOwner(Bukkit.getPlayer(args[0]).getName());
        skull.setItemMeta((ItemMeta)skullmeta);
        p.getInventory().addItem(new ItemStack[] { skull });
        return true;
      } 
      p.sendMessage(String.valueOf(Settings.prefix) + "Bitte verwende: §e/kopf <Spieler>");
      return false;
    } 
    
    p.sendMessage(Settings.nopermission);

    
    return false;
  }
}