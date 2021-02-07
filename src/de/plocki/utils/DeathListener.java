package de.plocki.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
  @EventHandler
  public static void onDeath(PlayerDeathEvent e) {
    e.setDeathMessage("");
  }
}