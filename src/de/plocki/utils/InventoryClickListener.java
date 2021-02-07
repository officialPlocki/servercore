package de.plocki.utils;

import de.plocki.main.Settings;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClickListener
  implements Listener {
  @EventHandler
  public static void onClick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    ItemMeta item = e.getCurrentItem().getItemMeta();
    int coins = VoteEconomyUtils.getvotecoins(p).intValue();
    
    if (e.getView().getTitle().equalsIgnoreCase("§3§lJob-Center")) {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMinenarbeiter")) {
        if (ConfigManager.data.get("Job." + p.getUniqueId().toString()) == "no") {
          p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast den Job §cMinenarbeiter §aangenommen.");
          ConfigManager.data.set("Job." + p.getUniqueId().toString(), "miner");
          ConfigManager.saveData();
          p.closeInventory();
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Du bist bereits in einem Job.");
          p.closeInventory();
        } 
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bErzarbeiter")) {
        if (ConfigManager.data.get("Job." + p.getUniqueId().toString()).equals("no")) {
          p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast den Job §bErzarbeiter §aangenommen.");
          ConfigManager.data.set("Job." + p.getUniqueId().toString(), "ore");
          ConfigManager.saveData();
          p.closeInventory();
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Du bist bereits in einem Job.");
          p.closeInventory();
        } 
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Holzfäller")) {
        if (ConfigManager.data.get("Job." + p.getUniqueId().toString()) == "no") {
          p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast den Job §6Holzfäller §aangenommen.");
          ConfigManager.data.set("Job." + p.getUniqueId().toString(), "wood");
          ConfigManager.saveData();
          p.closeInventory();
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Du bist bereits in einem Job.");
          p.closeInventory();
        } 
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Job beenden")) {
        if (ConfigManager.data.get("Job." + p.getUniqueId().toString()) != "no") {
          ConfigManager.data.set("Job." + p.getUniqueId().toString(), "no");
          ConfigManager.saveData();
          p.sendMessage(String.valueOf(Settings.prefix) + "§7Du hast deinen aktuellen Job beendet!");
          p.closeInventory();
        } else {
          p.sendMessage(String.valueOf(Settings.prefix) + "Du bist in keinem Job.");
          p.closeInventory();
        } 
      } 
    } 
    if (e.getView().getTitle().equalsIgnoreCase("§aVote Menü")) {
      e.setCancelled(true);
      if (item.getDisplayName().equalsIgnoreCase("§6Premium 14 Tage §8| §e200 " + Settings.votecoinname)) {
        if (coins == 50 || coins >= 50) {
          p.closeInventory();
          VoteEconomyUtils.removevotecoins(p, Integer.valueOf(50));
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast dir erfolgreich den §6Premium §7Rang gekauft!");
          Bukkit.getConsoleSender().getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + p.getName().toString() + " parent addtemp premium 14d");
          return;
        } 
        p.sendMessage(String.valueOf(Settings.prefix) + "Du hast nicht genügend " + Settings.votecoinname + ".");
        return;
      } 
      if (item.getDisplayName().equalsIgnoreCase("§6Premium+ 30 Tage §8| §e250 " + Settings.votecoinname)) {
        if (coins == 100 || coins >= 100) {
          p.closeInventory();
          VoteEconomyUtils.removevotecoins(p, Integer.valueOf(100));
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast dir erfolgreich den §6Premium+ §7Rang gekauft!");
          Bukkit.getConsoleSender().getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + p.getName().toString() + " parent addtemp premium+ 30d");
          return;
        } 
        p.sendMessage(String.valueOf(Settings.prefix) + "Du hast nicht genügend " + Settings.votecoinname + ".");
        return;
      } 
      if (item.getDisplayName().equalsIgnoreCase("§bUltra 14 Tage §8| §e50 " + Settings.votecoinname)) {
        if (coins == 200 || coins >= 200) {
          p.closeInventory();
          VoteEconomyUtils.removevotecoins(p, Integer.valueOf(200));
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast dir erfolgreich den §bUltra §7Rang gekauft!");
          Bukkit.getConsoleSender().getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + p.getName().toString() + " parent addtemp ultra 14d");
          return;
        } 
        p.sendMessage(String.valueOf(Settings.prefix) + "Du hast nicht genügend " + Settings.votecoinname + ".");
        return;
      } 
      if (item.getDisplayName().equalsIgnoreCase("§bUltra+ 30 Tage §8| §e100 " + Settings.votecoinname)) {
        if (coins == 200 || coins >= 200) {
          p.closeInventory();
          VoteEconomyUtils.removevotecoins(p, Integer.valueOf(200));
          p.sendMessage(String.valueOf(Settings.prefix) + "Du hast dir erfolgreich den §bUltra+ §7Rang gekauft!");
          Bukkit.getConsoleSender().getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + p.getName().toString() + " parent addtemp ultra+ 30d");
          return;
        } 
        p.sendMessage(String.valueOf(Settings.prefix) + "Du hast nicht genügend " + Settings.votecoinname + ".");
        return;
      } 
    } 
  }


  
  @EventHandler
  public void onMinenarbeiter(BlockBreakEvent e) {
    Player p = e.getPlayer();
    
    if (ConfigManager.data.get("Job." + p.getUniqueId().toString()) == "miner" && 
      e.getBlock().getType().equals(Material.STONE)) {
      EconomyUtils.addCoins(p, Integer.valueOf(1));
      p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)new TextComponent("§a+ §e1" + Settings.value));
      p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5.0F, 5.0F);
    } 
  }

  
  @EventHandler
  public void onErzarbeiter(BlockBreakEvent e) {
    Player p = e.getPlayer();
    
    if (ConfigManager.data.get("Job." + p.getUniqueId().toString()) == "ore" && (
      e.getBlock().getType().equals(Material.DIAMOND_ORE) || e.getBlock().getType().equals(Material.GOLD_ORE) || 
      e.getBlock().getType().equals(Material.EMERALD_ORE) || e.getBlock().getType().equals(Material.COAL_ORE) || 
      e.getBlock().getType().equals(Material.LAPIS_ORE) || 
      e.getBlock().getType().equals(Material.REDSTONE_ORE) || e.getBlock().getType().equals(Material.REDSTONE_ORE) || 
      e.getBlock().getType().equals(Material.IRON_ORE))) {
      EconomyUtils.addCoins(p, Integer.valueOf(3));
      p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)new TextComponent("§a+ §e3" + Settings.value));
      p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5.0F, 5.0F);
    } 
  }

  
  @EventHandler
  public void onHolzfäller(BlockBreakEvent e) {
    Player p = e.getPlayer();
    
    if (ConfigManager.data.get("Job." + p.getUniqueId().toString()) == "wood" && (
      e.getBlock().getType().equals(Material.ACACIA_LOG) ||
      e.getBlock().getType().equals(Material.BIRCH_LOG) ||
      e.getBlock().getType().equals(Material.DARK_OAK_LOG) ||
      e.getBlock().getType().equals(Material.JUNGLE_LOG) ||
      e.getBlock().getType().equals(Material.OAK_LOG) ||
      e.getBlock().getType().equals(Material.SPRUCE_LOG))) {
      EconomyUtils.addCoins(p, Integer.valueOf(1));
      p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)new TextComponent("§a+ §e1" + Settings.value));
      p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5.0F, 5.0F);
    } 
  }
}