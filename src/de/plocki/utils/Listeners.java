package de.plocki.utils;

import de.plocki.commands.CMD_vanish;
import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.ehrengames.bankaddon.utils.BankEconomy;






public class Listeners implements Listener{
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e) {
    e.setCancelled(true);
    //if (Bukkit.getPluginManager().getPlugin("BankAddon").isEnabled()) {
      if (ConfigManager.tmp.getBoolean("Einzahlen." + e.getPlayer().getName())) {
        if (EconomyUtils.getCoins(e.getPlayer()).intValue() >= Integer.valueOf(e.getMessage()).intValue() || EconomyUtils.getCoins(e.getPlayer()) == Integer.valueOf(e.getMessage())) {
          BankEconomy.addCoins(e.getPlayer(), Integer.valueOf(e.getMessage()));
          EconomyUtils.removeCoins(e.getPlayer(), Integer.valueOf(e.getMessage()));
          ConfigManager.tmp.set("Einzahlen." + e.getPlayer().getName(), Boolean.valueOf(false));
          e.getPlayer().sendMessage(String.valueOf(Settings.prefix) + "§aDu hast erfolgreich §e" + e.getMessage() + Settings.value + "§a eingezahlt!");
          return;
        } 
        e.getPlayer().sendMessage("§cDer eingegebene Betrag ist nicht gültig oder du hast nicht genügend Geld.");
      } 
      
      if (ConfigManager.tmp.getBoolean("Auszahlen." + e.getPlayer().getName())) {
        e.setCancelled(true);
        if (BankEconomy.getCoins(e.getPlayer()) == Integer.valueOf(e.getMessage()) || BankEconomy.getCoins(e.getPlayer()).intValue() >= Integer.valueOf(e.getMessage()).intValue()) {
          BankEconomy.removeCoins(e.getPlayer(), Integer.valueOf(e.getMessage()));
          EconomyUtils.addCoins(e.getPlayer(), Integer.valueOf(e.getMessage()));
          ConfigManager.tmp.set("Auszahlen." + e.getPlayer().getName(), Boolean.valueOf(false));
          e.getPlayer().sendMessage(String.valueOf(Settings.prefix) + "§aDu hast erfolgreich §e" + e.getMessage() + Settings.value + "§a ausgezahlt!");
          return;
        } 
        e.getPlayer().sendMessage("§cDer eingegebene Betrag ist nicht gültig oder du hast nicht genügend Geld auf deinem Konto.");
      } 
    //} 
    
    String msg = e.getMessage();
    
    Player p = e.getPlayer();
    
    String rang = "";
    if (p.hasPermission("group.owner")) {
      rang = "§4§lOwner §8» §7";
    } else if (p.hasPermission("group.leitung")) {
      rang = "§4§lLeitung §8» §7";
    } else if (p.hasPermission("group.admin")) {
      rang = "§4§lAdmin §8» §7";
    } else if (p.hasPermission("group.dev")) {
      rang = "§b§lDeveloper §8» §7";
    } else if (p.hasPermission("group.mod+")) {
       rang = "§c§lModerator§c§l+ §8» §7";
    } else if (p.hasPermission("group.mod")) {
      rang = "§c§lModerator §8» §7";
    } else if (p.hasPermission("group.builder")) {
      rang = "§e§lBuilder §8» §7";
    } else if (p.hasPermission("group.sup+")) {
      rang = "§a§lSupporter§a§l+ §8» §7";
    } else if (p.hasPermission("group.sup")) {
      rang = "§a§lSupporter §8» §7";
    } else if (p.hasPermission("group.tsup")) {
      rang = "§aT-Supporter §8» §7";
    } else if (p.hasPermission("group.premium+")) {
      rang = "§6Premium§6§l+ §8» §7";
    } else if (p.hasPermission("group.premium")) {
      rang = "§6Premium §8» §7";
    } else if (p.hasPermission("group.ultra+")) {
      rang = "§bUltra§b§l+ §8» §7";
    } else if (p.hasPermission("group.ultra")) {
      rang = "§bUltra §8» §7";
    } else if (p.hasPermission("group.default")) {
      rang = "§7Spieler §8» §7";
    } 
    
    if (CMD_vanish.chat.contains(p)) {
      if (!msg.equalsIgnoreCase("accept")) {
        e.setCancelled(true);
        p.sendMessage(String.valueOf(Settings.prefix) + "§7Schreibe §6'accept' §7in den Chat, um diesen benutzen zu können.");
        return;
      } 
      if (msg.equalsIgnoreCase("accept")) {
        CMD_vanish.chat.remove(p);
        p.sendMessage(String.valueOf(Settings.prefix) + "§aDu hast den Chat freigeschaltet.");
        
        return;
      } 
    } 
    if (!ConfigManager.data.isSet("ChatColor." + p.getName())) {
      ConfigManager.data.set("ChatColor." + p.getName(), "7");
      ConfigManager.saveData();
    } 
    
    if (msg.startsWith("!") && 
      p.hasPermission("chat.broadcast")) {
      msg.replaceFirst("!", "");
      Bukkit.broadcastMessage("§8»");
      Bukkit.broadcastMessage("");
      Bukkit.broadcastMessage("§8» §a§" + ConfigManager.data.getString("ChatColor." + p.getName()) + msg.replaceAll("&", "§").replaceAll("!", ""));
      Bukkit.broadcastMessage("");
      Bukkit.broadcastMessage("§8» §egesendet von " + rang + p.getName());
      
      return;
    } 
    if (p.hasPermission("chat.color.direct")) {
      Bukkit.broadcastMessage(String.valueOf(rang) + p.getName() + ": §" + ConfigManager.data.getString("ChatColor." + p.getName()) + msg.replaceAll("&", "§"));
      return;
    } 
    Bukkit.broadcastMessage(String.valueOf(rang) + p.getName() + ": §" + ConfigManager.data.getString("ChatColor." + p.getName()) + msg);
  }

  
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player players = e.getPlayer();
    
    if (!players.hasPlayedBefore()) {
      Player p = players;
      PlayerInventory playerInventory = p.getInventory();
      
      /*playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_HELMET) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_CHESTPLATE) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_LEGGINGS) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_BOOTS) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_SWORD) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_AXE) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_PICKAXE) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_SHOVEL) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.DIAMOND, 8) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.IRON_INGOT, 16) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.BREAD, 32) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.LAVA_BUCKET) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.WATER_BUCKET, 2) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.OAK_LOG, 64) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.FURNACE) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.WORKBENCH) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.CHEST, 4) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.SHEARS) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.WHEAT_SEEDS, 64) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.GOLDEN_APPLE) });
      playerInventory.addItem(new ItemStack[] { new ItemStack(Material.COAL, 32) });*/
    } 
    
    e.setJoinMessage(null);
    TablistUtils.setScoreboard();
    if (!ConfigManager.data.isSet("ChatColor." + players.getName())) {
      ConfigManager.data.set("ChatColor." + players.getName(), "7");
      ConfigManager.saveData();
    } 
  }
  
  @EventHandler
  public void onCMD(PlayerCommandPreprocessEvent e) {
    if (e.getMessage().contains("lp"))
      TablistUtils.setScoreboard(); 
  }
  
  @EventHandler
  public void onQuit(PlayerQuitEvent e) {
    e.setQuitMessage(null);
  }
}