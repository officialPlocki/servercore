package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.VoteEconomyUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class CMD_votecoins
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (args.length == 0) {
      p.sendMessage(String.valueOf(Settings.prefix) + "Du hast aktuell §e" + VoteEconomyUtils.getvotecoins(p) + " §a" + Settings.votecoinname);
      return false;
    }  if (args.length == 1) {
      if (args[0].equalsIgnoreCase("menu")) {
        Inventory inv = Bukkit.createInventory(null, 45, "§aVote Menü");
        
        ItemStack coins = new ItemStack(Material.PAPER);
        ItemMeta coinsmeta = coins.getItemMeta();
        coinsmeta.setDisplayName("§aDu hast " + VoteEconomyUtils.getvotecoins(p) + " " + Settings.votecoinname + ".");
        coins.setItemMeta(coinsmeta);
        
        ItemStack premium = new ItemStack(Material.GOLD_INGOT);
        ItemMeta premiummeta = premium.getItemMeta();
        premiummeta.setDisplayName("§6Premium 14 Tage §8| §e200 " + Settings.votecoinname);
        premium.setItemMeta(premiummeta);
        
        ItemStack premiumplus = new ItemStack(Material.GOLD_INGOT);
        ItemMeta premiumplusmeta = premiumplus.getItemMeta();
        premiumplusmeta.setDisplayName("§6Premium+ 30 Tage §8| §e250 " + Settings.votecoinname);
        premiumplus.setItemMeta(premiumplusmeta);
        
        ItemStack ultra = new ItemStack(Material.DIAMOND);
        ItemMeta ultrameta = ultra.getItemMeta();
        ultrameta.setDisplayName("§bUltra 14 Tage §8| §e50 " + Settings.votecoinname);
        ultra.setItemMeta(ultrameta);
        
        ItemStack ultraplus = new ItemStack(Material.DIAMOND);
        ItemMeta ultraplusmeta = ultraplus.getItemMeta();
        ultraplusmeta.setDisplayName("§bUltra+ 30 Tage §8| §e100 " + Settings.votecoinname);
        ultraplus.setItemMeta(ultraplusmeta);
        
        inv.setItem(4, premium);
        
        inv.setItem(8, coins);
        
        inv.setItem(20, ultraplus);
        
        inv.setItem(24, premiumplus);
        
        inv.setItem(40, ultra);
        
        p.openInventory(inv);
        return false;
      }  if (args[0].equalsIgnoreCase("help")) {
        p.sendMessage("§e§lVoteCoin Hilfe");
        p.sendMessage("");
        p.sendMessage("§e/votecoin §8| §7Zeigt dir deine aktuellen " + Settings.votecoinname);
        p.sendMessage("§e/votecoin menu  §8| §7Zeigt dir das VoteCoin Menü");
        p.sendMessage("");
        return false;
      } 
      p.sendMessage("§e§lVoteCoin Hilfe");
      p.sendMessage("");
      p.sendMessage("§e/votecoin §8| §7Zeigt dir deine aktuellen " + Settings.votecoinname);
      p.sendMessage("§e/votecoin menu  §8| §7Zeigt dir das VoteCoin Menü");
      p.sendMessage("");
      return false;
    } 
    
    return false;
  }
}