package de.plocki.utils;

import com.nametagedit.plugin.NametagEdit;
import de.Herbystar.TTA.TTA_Methods;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;



public class TablistUtils
{
  public static void setScoreboard() {
    for (Player p : Bukkit.getOnlinePlayers()) {
      if (p.hasPermission("group.owner")) {
        NametagEdit.getApi().setPrefix(p, "§4§lOwner §8» §7");
      } else if (p.hasPermission("group.leitung")) {
        NametagEdit.getApi().setPrefix(p, "§4§lLeitung §8» §7");
      } else if (p.hasPermission("group.admin")) {
        NametagEdit.getApi().setPrefix(p, "§4§lAdmin §8» §7");
      } else if (p.hasPermission("group.dev")) {
        NametagEdit.getApi().setPrefix(p, "§b§lDeveloper §8» §7");
      } else if (p.hasPermission("group.mod+")) {
        NametagEdit.getApi().setPrefix(p, "§c§lModerator+ §8» §7");
      } else if (p.hasPermission("group.mod")) {
        NametagEdit.getApi().setPrefix(p, "§c§lModerator §8» §7");
      } else if (p.hasPermission("group.builder")) {
        NametagEdit.getApi().setPrefix(p, "§e§lBuilder §8» §7");
      } else if (p.hasPermission("group.sup+")) {
        NametagEdit.getApi().setPrefix(p, "§a§lSupporter+ §8» §7");
      } else if (p.hasPermission("group.sup")) {
        NametagEdit.getApi().setPrefix(p, "§a§lSupporter §8» §7");
      } else if (p.hasPermission("group.tsup")) {
        NametagEdit.getApi().setPrefix(p, "§aT-Supporter §8» §7");
      } else if (p.hasPermission("group.premium+")) {
        NametagEdit.getApi().setPrefix(p, "§6Premium+ §8» §7");
      } else if (p.hasPermission("group.premium")) {
        NametagEdit.getApi().setPrefix(p, "§6Premium §8» §7");
      } else if (p.hasPermission("group.ultra+")) {
        NametagEdit.getApi().setPrefix(p, "§bUltra+ §8» §7");
      } else if (p.hasPermission("group.ultra")) {
        NametagEdit.getApi().setPrefix(p, "§bUltra §8» §7");
      } else if (p.hasPermission("group.default")) {
        NametagEdit.getApi().setPrefix(p, "§7Spieler §8» §7");
      } 
      TTA_Methods.sendTablist(p, "\n§c§lLarsodersaas.de\n\n     §aTeamSpeak§7: §cts.larsodersaas.de\n\n", "\n\n§7Spieler online:\n§e" + Bukkit.getOnlinePlayers().size() + "§8/§a" + Bukkit.getMaxPlayers() + "\n");
    } 
  }
}