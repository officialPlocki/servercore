package de.plocki.main;

import de.plocki.utils.EconomyUtils;
import org.bukkit.entity.Player;

public class Settings{
  public static String art = "extended";
  
  public static String prefix = "§c§lLarsodersaas §7| ";
  
  public static String version = "2 Build 103";
  
  public static Boolean owneconomy = true;

  public static String value = "€";
  
  public static String permissionprefix = "larsodersaas";
  
  public static String votecoinname = "Taler";
  
  public static String nopermission = String.valueOf(prefix) + "§cDu hast keine Rechte!";
  
  public static String playernotonline = String.valueOf(prefix) + "§cDer Spieler ist nicht online oder wurde nicht gefunden.";
  
  public static String moneyMessage(Player p) {
    return String.valueOf(prefix) + "§7Du bist im Besitz von §e" + EconomyUtils.getCoins(p) + "§7" + value;
  }
  public static String resetMoney(Player p) {
     return "§7Das Geld von §e" + p.getName() + "§c wurde zurückgesetzt!";
  }
  
  public static String setMoney(Player p, Integer i) {
    return String.valueOf(prefix) + "§7Das Geld von §e" + p.getName() + "§7 wurde auf §e" + i + value + "§7 gesetzt!";
  }
  public static String giveMoney(Player p, Integer i) {
    return String.valueOf(prefix) + "§e" + p.getName() + "§7 wurden §b" + i + value + " §7hinzugefügt!";
  }
  public static String takeMoney(Player p, Integer i) {
    return String.valueOf(prefix) + "§e" + p.getName() + "§7 wurden §e" + i + value + " §7entfernt!";
  }
}