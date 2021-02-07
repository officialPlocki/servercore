package de.plocki.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.entity.Player;

import ch.dkrieger.coinsystem.core.CoinSystem;
import de.plocki.main.Settings;

public class EconomyUtils
{
  public static void setupEconomy() {
    if (!ConfigManager.cfg.isSet("Host")) {
      ConfigManager.cfg.set("Host", "localhost");
      ConfigManager.saveConfig();
    } 
    if (!ConfigManager.cfg.isSet("Database")) {
      ConfigManager.cfg.set("Database", "dbname");
      ConfigManager.saveConfig();
    } 
    if (!ConfigManager.cfg.isSet("User")) {
      ConfigManager.cfg.set("User", "dbuser");
      ConfigManager.saveConfig();
    } 
    if (!ConfigManager.cfg.isSet("Password")) {
      ConfigManager.cfg.set("Password", "dbpassword");
      ConfigManager.saveConfig();
    } 
  }
  
  public static Integer getCoins(Player p) {
				if(Settings.owneconomy==true) {
	    VoteEconomyUtils.checkExist();
	    try {
	      PreparedStatement st = MySQL.con.prepareStatement("SELECT coins FROM coinTable WHERE UUID = ?");
	      st.setString(1, p.getUniqueId().toString());
	      ResultSet rs = st.executeQuery();
	      if (rs.next()) {
	        return Integer.valueOf(rs.getInt("coins"));
	      }
	    } catch (SQLException e) {
	      
	      e.printStackTrace();
	    } 
	   return Integer.valueOf(-1);
	  } else if(Settings.owneconomy==false) {
		  return (int) CoinSystem.getInstance().getPlayerManager().getPlayer(p.getPlayer().getName()).getCoins();
	}

				return null;
				}
  public static void setCoins(Player p, Integer arg) {
			if(Settings.owneconomy==true) {
    VoteEconomyUtils.checkExist();
    
    if (getCoins(p).intValue() == -1) {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO coinTable (UUID,coins) VALUES (?,?)");
        st.setString(1, p.getUniqueId().toString());
        st.setInt(2, arg.intValue());
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("UPDATE coinTable SET coins = ? WHERE UUID = ?");
        st.setString(2, p.getUniqueId().toString());
        st.setInt(1, arg.intValue());
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
  } else if(Settings.owneconomy==false) {
	  CoinSystem.getInstance().getPlayerManager().getPlayer(p.getName()).setCoins(arg);
}
}
  public static void addCoins(Player p, Integer arg) {
    VoteEconomyUtils.checkExist();
    setCoins(p, Integer.valueOf(arg.intValue() + getCoins(p).intValue()));
  }
  public static void removeCoins(Player p, Integer arg) {
    VoteEconomyUtils.checkExist();
    setCoins(p, Integer.valueOf(getCoins(p).intValue() - arg.intValue()));
  }
  
  public static void resetCoins(Player p) {
	if(Settings.owneconomy==true) {
    VoteEconomyUtils.checkExist();
    if (getCoins(p).intValue() == -1) {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO coinTable (UUID,coins) VALUES (?,?)");
        st.setString(1, p.getUniqueId().toString());
        st.setInt(2, 0);
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("UPDATE coinTable SET coins = ? WHERE UUID = ?");
        st.setString(2, p.getUniqueId().toString());
        st.setInt(1, 0);
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
  } else if(Settings.owneconomy==false) {
	  CoinSystem.getInstance().getPlayerManager().getPlayer(p.getName()).removeCoins(getCoins(p));
}
}
}