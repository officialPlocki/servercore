package de.plocki.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ChatInventoryUtils implements Listener {
  @EventHandler
  public void onChatInventoryClick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    if (e.getView().getTitle().contains("Farbe...")) {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrün")) {
        if (p.hasPermission("chat.color.green")) {
           ConfigManager.data.set("ChatColor." + p.getName(), "a");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf Grün geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bBlau")) {
        if (p.hasPermission("chat.color.blue")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "b");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §bBlau§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Orange")) {
        if (p.hasPermission("chat.color.orange")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "6");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §6Orange§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dPink")) {
        if (p.hasPermission("chat.color.pink")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "d");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §dPink§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGelb")) {
        if (p.hasPermission("chat.color.yellow")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "e");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §eGelb§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHellrot")) {
        if (p.hasPermission("chat.color.green")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "c");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §cHellrot§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Rot")) {
        if (p.hasPermission("chat.color.green")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "4");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §4Rot§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Dunkelblau")) {
        if (p.hasPermission("chat.color.green")) {
          ConfigManager.data.set("ChatColor." + p.getName(), "9");
          ConfigManager.saveData();
          p.closeInventory();
          p.sendMessage("§aDeine Chatfarbe wurde auf §9Dunkelblau§a geändert!");
          return;
        } 
        p.sendMessage("§cDu hast keine Recht auf diese Farbe!");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Grau")) {
        ConfigManager.data.set("ChatColor." + p.getName(), "7");
        ConfigManager.saveData();
        p.closeInventory();
        p.sendMessage("§aDeine Chatfarbe wurde auf §7Grau§a geändert!");
        return;
      } 
    } 
  }
}