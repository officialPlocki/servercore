package de.plocki.commands;

import de.plocki.main.Settings;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_jobs
  implements CommandExecutor, Listener
{
  public static Inventory inv = Bukkit.createInventory(null, 9, "§3§lJob-Center");

  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      
      if (args.length == 0) {
        ItemStack Beenden = new ItemStack(Material.ANVIL);
        ItemMeta BeendenMeta = Beenden.getItemMeta();
        BeendenMeta.setDisplayName("§4Job beenden");
        ArrayList<String> BeendenLore = new ArrayList<>();
        BeendenLore.add("§7Beende deinen aktuellen Job.");
        BeendenMeta.setLore(BeendenLore);
        Beenden.setItemMeta(BeendenMeta);
        inv.setItem(0, Beenden);
        
        ItemStack Minenarbeiter = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta MinenarbeiterMeta = Minenarbeiter.getItemMeta();
        MinenarbeiterMeta.setDisplayName("§cMinenarbeiter");
        ArrayList<String> MinenarbeiterLore = new ArrayList<>();
        MinenarbeiterLore.add("§7Baue einen Stein ab, um §e1" + Settings.value + " §7zu bekommen.");
        MinenarbeiterMeta.setLore(MinenarbeiterLore);
        Minenarbeiter.setItemMeta(MinenarbeiterMeta);
        inv.setItem(3, Minenarbeiter);
        
        ItemStack Erzarbeiter = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta ErzarbeiterMeta = Erzarbeiter.getItemMeta();
        ErzarbeiterMeta.setDisplayName("§bErzarbeiter");
        ArrayList<String> ErzarbeiterLore = new ArrayList<>();
        ErzarbeiterLore.add("§7Baue einen Erz-Block ab, um §e3" + Settings.value + " §7zu bekommen.");
        ErzarbeiterMeta.setLore(ErzarbeiterLore);
        Erzarbeiter.setItemMeta(ErzarbeiterMeta);
        inv.setItem(5, Erzarbeiter);
        
        ItemStack Holzfäller = new ItemStack(Material.WOODEN_AXE);
        ItemMeta HolzfällerMeta = Holzfäller.getItemMeta();
        HolzfällerMeta.setDisplayName("§6Holzfäller");
        ArrayList<String> HolzfällerLore = new ArrayList<>();
        HolzfällerLore.add("§7Baue einen Holzstamm ab, um §e1" + Settings.value + " §7zu bekommen.");
        HolzfällerMeta.setLore(HolzfällerLore);
        Holzfäller.setItemMeta(HolzfällerMeta);
        inv.setItem(7, Holzfäller);
        
        p.openInventory(inv);
      } else {
        p.sendMessage(String.valueOf(Settings.prefix) + "Bitte benutze: /jobs");
      } 
    } 
    return true;
  }
}