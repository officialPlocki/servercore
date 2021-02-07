package de.plocki.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class MySQL {
  public static Connection con;
  static String host = ConfigManager.cfg.getString("Host");
  static String db = ConfigManager.cfg.getString("Database");
  static String user = ConfigManager.cfg.getString("User");
  static String pw = ConfigManager.cfg.getString("Password");
  
  public static void connect() {
    if (!isConnected()) {
      try {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db + "?autoReconnect=true", user, pw);
        System.out.println("MySQL verbunden!");
      } catch (SQLException e) {
        
        e.printStackTrace();
      } 
    }
  }
  
  public static void disconnect() {
    if (!isConnected()) {
      try {
        con.close();
        System.out.println("MySQL gentrennt!");
      } catch (SQLException e) {
        
        e.printStackTrace();
      } 
    }
  }
  
  public static void createTable() {
    try {
      con.prepareStatement("CREATE TABLE IF NOT EXISTS coinTable (UUID VARCHAR(100), coins INT(16))").executeUpdate();
    } catch (SQLException e) {
      
      e.printStackTrace();
    } 
    try {
      con.prepareStatement("CREATE TABLE IF NOT EXISTS VotecoinTable (UUID VARCHAR(100), votecoins INT(16))").executeUpdate();
    } catch (SQLException e) {
      
      e.printStackTrace();
    } 
  }
  
  private static boolean isConnected() {
    return (con != null);
  }
}