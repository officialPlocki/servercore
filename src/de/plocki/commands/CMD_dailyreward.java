package de.plocki.commands;

import de.plocki.main.Settings;
import de.plocki.utils.ConfigManager;
import de.plocki.utils.EconomyUtils;
import java.util.Date;
import java.util.HashMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_dailyreward implements CommandExecutor{
	public HashMap<String, Long> cooldowns = new HashMap<>();
  
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (!ConfigManager.data.isSet("Reward." + p.getName())) {
      ConfigManager.data.set("Reward." + p.getName(), Integer.valueOf((new Date()).getDate()));
      ConfigManager.saveData();
      EconomyUtils.addCoins(p, Integer.valueOf(250));
      p.giveExp(30);
      p.sendMessage(String.valueOf(Settings.prefix) + "Du hast deine Tägliche Belohnung in Höhe von 30 EXP und 250" + Settings.value + " erhalten.");
      return false;
    }  if (!ConfigManager.data.get("Reward." + p.getName()).equals(ConfigManager.data.get("last-restart"))) {
      ConfigManager.data.set("Reward." + p.getName(), Integer.valueOf((new Date()).getDate()));
      ConfigManager.saveData();
      EconomyUtils.addCoins(p, Integer.valueOf(250));
      p.giveExp(30);
      p.sendMessage(String.valueOf(Settings.prefix) + "Du hast deine Tägliche Belohnung in Höhe von 30 EXP und 250" + Settings.value + " erhalten.");
      return false;
    } 
     p.sendMessage(String.valueOf(Settings.prefix) + "Du musst bis Morgen warten um die Tägliche Belohnung abholen zu können!");
     return false;
  }
}