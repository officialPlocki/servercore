package de.plocki.main;
import de.plocki.*;
import de.plocki.commands.*;
import de.plocki.utils.*;

import java.util.Date;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin {
  public HashSet<Player> FORCE_FIELDS = new HashSet<>();
  public void onEnable() {
    EconomyUtils.setupEconomy();
    MySQL.connect();
    MySQL.createTable();
    ConfigManager.data.set("last-restart", Integer.valueOf((new Date()).getDate()));
    ConfigManager.saveData();
     start();
    Bukkit.getPluginManager().registerEvents((Listener)new ChatInventoryUtils(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new DeathListener(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new CMD_freeze(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new CMD_jobs(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new CMD_globalmute(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new Listeners(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents((Listener)new InventoryClickListener(), (Plugin)this);
    if (Settings.art == "lite") {
      getCommand("money").setExecutor((CommandExecutor)new CMD_money());
      getCommand("coin").setExecutor((CommandExecutor)new CMD_money());
      getCommand("coins").setExecutor((CommandExecutor)new CMD_money());
      getCommand("geld").setExecutor((CommandExecutor)new CMD_money());
      getCommand("euro").setExecutor((CommandExecutor)new CMD_money());
      getCommand("dollar").setExecutor((CommandExecutor)new CMD_money());
      getCommand("gm").setExecutor((CommandExecutor)new CMD_gm());
      getCommand("gamemode").setExecutor((CommandExecutor)new CMD_gm());
      getCommand("eco").setExecutor((CommandExecutor)new CMD_eco());
      getCommand("globalmute").setExecutor((CommandExecutor)new CMD_globalmute());
      getCommand("gmute").setExecutor((CommandExecutor)new CMD_globalmute());
      getCommand("pay").setExecutor((CommandExecutor)new CMD_pay());
      getCommand("tp").setExecutor((CommandExecutor)new CMD_tp());
      getCommand("vanish").setExecutor((CommandExecutor)new CMD_vanish());
      getCommand("v").setExecutor((CommandExecutor)new CMD_vanish());
      getCommand("cc").setExecutor((CommandExecutor)new CMD_cc());
      getCommand("clearchat").setExecutor((CommandExecutor)new CMD_cc());
      getCommand("chatclear").setExecutor((CommandExecutor)new CMD_cc());
      getCommand("scv").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("servercoreversion").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("server-core-version").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("server-core-ver").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("servercorever").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("forcefield").setExecutor((CommandExecutor)new CMD_forcefield(this));
      getCommand("ff").setExecutor((CommandExecutor)new CMD_forcefield(this));
      getCommand("tphere").setExecutor((CommandExecutor)new CMD_tphere());
    } else if (Settings.art == "extended") {
      getCommand("clear").setExecutor(new CMD_clear());
      getCommand("ci").setExecutor(new CMD_clear());
      getCommand("chatcolor").setExecutor((CommandExecutor)new CMD_chatcolor());
      getCommand("forcefield").setExecutor((CommandExecutor)new CMD_forcefield(this));
      getCommand("feed").setExecutor((CommandExecutor)new CMD_feed());
      getCommand("kopf").setExecutor((CommandExecutor)new CMD_kopf());
      getCommand("skull").setExecutor((CommandExecutor)new CMD_kopf());
      getCommand("head").setExecutor((CommandExecutor)new CMD_kopf());
      getCommand("ff").setExecutor((CommandExecutor)new CMD_forcefield(this));
      getCommand("money").setExecutor((CommandExecutor)new CMD_money());
      getCommand("coin").setExecutor((CommandExecutor)new CMD_money());
      getCommand("coins").setExecutor((CommandExecutor)new CMD_money());
      getCommand("geld").setExecutor((CommandExecutor)new CMD_money());
      getCommand("euro").setExecutor((CommandExecutor)new CMD_money());
      getCommand("dollar").setExecutor((CommandExecutor)new CMD_money());
      getCommand("eco").setExecutor((CommandExecutor)new CMD_eco());
      getCommand("gm").setExecutor((CommandExecutor)new CMD_gm());
      getCommand("gamemode").setExecutor((CommandExecutor)new CMD_gm());
      getCommand("scv").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("servercoreversion").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("server-core-version").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("server-core-ver").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("servercorever").setExecutor((CommandExecutor)new CMD_scv());
      getCommand("msg").setExecutor((CommandExecutor)new CMD_msg());
      getCommand("votecoins").setExecutor((CommandExecutor)new CMD_votecoins());
      getCommand("votecoin").setExecutor((CommandExecutor)new CMD_votecoins());
      getCommand("vc").setExecutor((CommandExecutor)new CMD_votecoins());
      getCommand("ecovote").setExecutor((CommandExecutor)new CMD_ecovote());
      getCommand("dailyreward").setExecutor((CommandExecutor)new CMD_dailyreward());
      getCommand("dr").setExecutor((CommandExecutor)new CMD_dailyreward());
      getCommand("dailyr").setExecutor((CommandExecutor)new CMD_dailyreward());
      getCommand("reward").setExecutor((CommandExecutor)new CMD_dailyreward());
      getCommand("ec").setExecutor((CommandExecutor)new CMD_ec());
      getCommand("ec").setExecutor((CommandExecutor)new CMD_ec());
      getCommand("enderchest").setExecutor((CommandExecutor)new CMD_ec());
      getCommand("enderc").setExecutor((CommandExecutor)new CMD_ec());
      getCommand("fly").setExecutor((CommandExecutor)new CMD_fly());
      getCommand("flight").setExecutor((CommandExecutor)new CMD_fly());
      getCommand("freeze").setExecutor((CommandExecutor)new CMD_freeze());
      getCommand("f").setExecutor((CommandExecutor)new CMD_freeze());
      getCommand("globalmute").setExecutor((CommandExecutor)new CMD_globalmute());
      getCommand("wb").setExecutor((CommandExecutor)new CMD_wb());
      getCommand("workbench").setExecutor((CommandExecutor)new CMD_wb());
      getCommand("gmute").setExecutor((CommandExecutor)new CMD_globalmute());
      getCommand("heal").setExecutor((CommandExecutor)new CMD_heal());
      getCommand("invsee").setExecutor((CommandExecutor)new CMD_invsee());
      getCommand("inv").setExecutor((CommandExecutor)new CMD_invsee());
      getCommand("job").setExecutor((CommandExecutor)new CMD_jobs());
      getCommand("jobs").setExecutor((CommandExecutor)new CMD_jobs());
      getCommand("msg").setExecutor((CommandExecutor)new CMD_msg());
      getCommand("pay").setExecutor((CommandExecutor)new CMD_pay());
      getCommand("rename").setExecutor((CommandExecutor)new CMD_rename());
      getCommand("rep").setExecutor((CommandExecutor)new CMD_repair());
      getCommand("repair").setExecutor((CommandExecutor)new CMD_repair());
      getCommand("sign").setExecutor((CommandExecutor)new CMD_sign());
      getCommand("tp").setExecutor((CommandExecutor)new CMD_tp());
      getCommand("tpa").setExecutor((CommandExecutor)new CMD_tpa());
      getCommand("tpaall").setExecutor((CommandExecutor)new CMD_tpaall());
      getCommand("tphere").setExecutor((CommandExecutor)new CMD_tphere());
      getCommand("tpahere").setExecutor((CommandExecutor)new CMD_tpahere());
      getCommand("tpaccept").setExecutor((CommandExecutor)new CMD_tpaccept());
      getCommand("night").setExecutor((CommandExecutor)new CMD_night());
      getCommand("day").setExecutor((CommandExecutor)new CMD_day());
      getCommand("sun").setExecutor((CommandExecutor)new CMD_sun());
      getCommand("tpaaccept").setExecutor((CommandExecutor)new CMD_tpaccept());
      getCommand("vanish").setExecutor((CommandExecutor)new CMD_vanish());
      getCommand("v").setExecutor((CommandExecutor)new CMD_vanish());
      getCommand("cc").setExecutor((CommandExecutor)new CMD_cc());
      getCommand("clearchat").setExecutor((CommandExecutor)new CMD_cc());
      getCommand("chatclear").setExecutor((CommandExecutor)new CMD_cc());
    } 
  }
  public void start() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable()
        {
          public void run() {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
              if (Main.this.FORCE_FIELDS.contains(player)) {
                for (Player other : Bukkit.getServer().getOnlinePlayers()) {
                  Entity entity = null; if (player.equals(other))
                    continue; 
                  if (Main.this.offset((Entity)other, (Entity)player) > 5.0D)
                    continue; 
                  if (other.getGameMode() == GameMode.SPECTATOR)
                    return; 
                  if (other.hasPermission(Settings.permissionprefix+".forcefield.bypass"))
                    return; 
                  Player player1 = other;
                  while (player1.getVehicle() != null)
                    entity = player1.getVehicle(); 
                  Main.this.velocity(entity, Main.this.getTrajectory2d((Entity)player, entity), 1.6D, true, 0.8D, 0.0D, 10.0D);
                  other.getWorld().playSound(other.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0F, 0.0F);
                }
              
              }
            } 
          }
        }, 40, 40);
  }
  
  public double offset(Entity a, Entity b) {
    return a.getLocation().toVector().subtract(b.getLocation().toVector()).length();
  }
  public Vector getTrajectory2d(Entity from, Entity to) {
    return to.getLocation().toVector().subtract(from.getLocation().toVector()).setY(0).normalize();
  }
  public void velocity(Entity ent, Vector vec, double str, boolean ySet, double yBase, double yAdd, double yMax) {
    if (Double.isNaN(vec.getX()) || Double.isNaN(vec.getY()) || Double.isNaN(vec.getZ()) || vec.length() == 0.0D)
      return; 
    if (ySet)
      vec.setY(yBase); 
    vec.normalize();
    vec.multiply(str);
    vec.setY(vec.getY() + yAdd);
    if (vec.getY() > yMax)
      vec.setY(yMax); 
    ent.setFallDistance(0.0F);
    ent.setVelocity(vec);
  }



  
  public void onDisable() {
    MySQL.disconnect();
  }
}