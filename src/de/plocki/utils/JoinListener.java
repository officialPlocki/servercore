package de.plocki.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.ehrengames.scoreboardaddon.utils.ScoreboardManager;




public class JoinListener
  implements Listener
{
  @EventHandler
  public static void onRespawn(PlayerRespawnEvent e) {
    Location loc = e.getPlayer().getLocation();
    double x = ConfigManager.cfg.getDouble("X");
    double y = ConfigManager.cfg.getDouble("Y");
    double z = ConfigManager.cfg.getDouble("Z");
    double yaw = ConfigManager.cfg.getDouble("Blickrichtung YAW");
    double pitch = ConfigManager.cfg.getDouble("Blickrichtung PITCH");
    String worldname = ConfigManager.cfg.getString("Weltname");
    
    World welt = Bukkit.getWorld(worldname);
    
    loc.setX(x);
    loc.setY(y);
    loc.setZ(z);
    loc.setYaw((float)yaw);
    loc.setPitch((float)pitch);
    loc.setWorld(welt);
    
    e.setRespawnLocation(loc);
  }
  
  @EventHandler
  public static void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
      ScoreboardManager.setScoreBoard(p);
    e.setJoinMessage("");
    if (!p.hasPlayedBefore()) {
      if (EconomyUtils.getCoins(p).intValue() == -1) {
        EconomyUtils.setCoins(p, Integer.valueOf(250));
      }
      if (VoteEconomyUtils.getvotecoins(p).intValue() == -1) {
        VoteEconomyUtils.setvotecoins(p, Integer.valueOf(250));
      }
    } 
    if (ConfigManager.cfg.getBoolean("force-spawn-onjoin")) {
      Location loc = p.getLocation();
      double x = ConfigManager.cfg.getDouble("X");
      double y = ConfigManager.cfg.getDouble("Y");
      double z = ConfigManager.cfg.getDouble("Z");
      double yaw = ConfigManager.cfg.getDouble("Blickrichtung YAW");
      double pitch = ConfigManager.cfg.getDouble("Blickrichtung PITCH");
      String worldname = ConfigManager.cfg.getString("Weltname");
      
      World welt = Bukkit.getWorld(worldname);
      
      loc.setX(x);
      loc.setY(y);
      loc.setZ(z);
      loc.setYaw((float)yaw);
      loc.setPitch((float)pitch);
      loc.setWorld(welt);
      
      e.getPlayer().teleport(loc);
    } 
  }
  @EventHandler
  public static void onQuit(PlayerQuitEvent e) {
    e.setQuitMessage("");
  }
}