package de.plocki.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.entity.Player;




public class VoteEconomyUtils{
  public static void checkExist() {
    try {
      MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS coinTable (UUID VARCHAR(100), coins INT(16))").executeUpdate();
      MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS VotecoinTable (UUID VARCHAR(100), votecoins INT(16))").executeUpdate();
      MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS BankTable (UUID VARCHAR(100), coins INT(16))").executeUpdate();
    } catch (SQLException e) {
      
      e.printStackTrace();
    } 
  }
  
  public static Integer getvotecoins(Player p) {
    checkExist();
    try {
      PreparedStatement st = MySQL.con.prepareStatement("SELECT votecoins FROM VotecoinTable WHERE UUID = ?");
      st.setString(1, p.getUniqueId().toString());
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        return Integer.valueOf(rs.getInt("votecoins"));
      }
    } catch (SQLException e) {
      
      e.printStackTrace();
    } 
    return Integer.valueOf(-1);
  }
  
  public static void setvotecoins(Player p, Integer arg) {
    if (getvotecoins(p).intValue() == -1) {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO VotecoinTable (UUID,votecoins) VALUES (?,?)");
        st.setString(1, p.getUniqueId().toString());
        st.setInt(2, arg.intValue());
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("UPDATE VotecoinTable SET votecoins = ? WHERE UUID = ?");
        st.setString(2, p.getUniqueId().toString());
        st.setInt(1, arg.intValue());
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
  }
  public static void addvotecoins(Player p, Integer arg) {
    checkExist();
    setvotecoins(p, Integer.valueOf(arg.intValue() + getvotecoins(p).intValue()));
  }
  public static void removevotecoins(Player p, Integer arg) {
    checkExist();
    setvotecoins(p, Integer.valueOf(getvotecoins(p).intValue() - arg.intValue()));
  }
  
  public static void resetvotecoins(Player p) {
    checkExist();
    if (getvotecoins(p).intValue() == -1) {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO VotecoinTable (UUID,votecoins) VALUES (?,?)");
        st.setString(1, p.getUniqueId().toString());
        st.setInt(2, 0);
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      try {
        PreparedStatement st = MySQL.con.prepareStatement("UPDATE VotecoinTable SET votecoins = ? WHERE UUID = ?");
        st.setString(2, p.getUniqueId().toString());
        st.setInt(1, 0);
        st.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
  }
}