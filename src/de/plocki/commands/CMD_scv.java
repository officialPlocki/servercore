package de.plocki.commands;

import de.plocki.main.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_scv
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    
    p.sendMessage("§8»«");
    p.sendMessage("§8»« §bServerCore v" + Settings.version + ", developed by§8»« \n§8»« §bplocki §8»«");
    p.sendMessage("§8»«");
    
    return false;
  }
}