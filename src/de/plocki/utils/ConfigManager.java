package de.plocki.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;



public class ConfigManager
{
  private static File datafile = new File("plugins//API//data.yml");
  public static YamlConfiguration data = YamlConfiguration.loadConfiguration(datafile);
  
  private static File cfgfile = new File("plugins//API//config.yml");
  public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cfgfile);
  
  private static File tmpfile = new File("plugins//API//tmp.yml");
  public static YamlConfiguration tmp = YamlConfiguration.loadConfiguration(tmpfile);

  
  public static void saveData() {
    try {
      data.save(datafile);
    } catch (IOException e) {
      
      e.printStackTrace();
    } 
  }
  public static void saveTmp() {
    try {
      tmp.save(tmpfile);
    } catch (IOException e) {
      
      e.printStackTrace();
    } 
  }
  public static void saveConfig() {
    try {
      cfg.save(cfgfile);
    } catch (IOException e) {
      
      e.printStackTrace();
    } 
  }
}