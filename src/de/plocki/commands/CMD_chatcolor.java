package de.plocki.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_chatcolor implements CommandExecutor{
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] args) {
	    Player p = (Player)arg0;
	
	
	    
	    Inventory inv = Bukkit.createInventory(null, 9, "§aWähle deine Chat Farbe...");
	    
	    ItemStack green = new ItemStack(Material.GREEN_GLAZED_TERRACOTTA);
	    ItemStack blue = new ItemStack(Material.BLUE_GLAZED_TERRACOTTA);
	    ItemStack orange = new ItemStack(Material.ORANGE_GLAZED_TERRACOTTA);
	    ItemStack pink = new ItemStack(Material.PINK_GLAZED_TERRACOTTA);
	    ItemStack yellow = new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA);
	    ItemStack lightred = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
	    ItemStack red = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
	    ItemStack darkblue = new ItemStack(Material.BLUE_GLAZED_TERRACOTTA);
	    ItemStack gray = new ItemStack(Material.GRAY_GLAZED_TERRACOTTA);
	    
	    ItemMeta greenmeta = green.getItemMeta();
	    greenmeta.setDisplayName("§aGrün");
	    green.setItemMeta(greenmeta);
	
	    
	    ItemMeta bluemeta = blue.getItemMeta();
	    bluemeta.setDisplayName("§bBlau");
	    blue.setItemMeta(bluemeta);
	
	    
	    ItemMeta orangemeta = orange.getItemMeta();
	    orangemeta.setDisplayName("§6Orange");
	    orange.setItemMeta(orangemeta);
	
	    
	    ItemMeta pinkmeta = pink.getItemMeta();
	    pinkmeta.setDisplayName("§dPink");
	    pink.setItemMeta(pinkmeta);
	
	    
	    ItemMeta yellowmeta = yellow.getItemMeta();
	    yellowmeta.setDisplayName("§eGelb");
	    yellow.setItemMeta(yellowmeta);
	
	    
	    ItemMeta lightredmeta = lightred.getItemMeta();
	    lightredmeta.setDisplayName("§cHellrot");
	    lightred.setItemMeta(lightredmeta);
	
	    
	    ItemMeta redmeta = red.getItemMeta();
	    redmeta.setDisplayName("§4Rot");
	    red.setItemMeta(redmeta);
	
	    
	    ItemMeta darkbluemeta = darkblue.getItemMeta();
	    darkbluemeta.setDisplayName("§9Dunkelblau");
	    darkblue.setItemMeta(darkbluemeta);
	
	    
	    ItemMeta graymeta = gray.getItemMeta();
	    graymeta.setDisplayName("§7Grau");
	    gray.setItemMeta(graymeta);
	
	    
	    inv.setItem(0, green);
	    inv.setItem(1, blue);
	    inv.setItem(2, darkblue);
	    inv.setItem(3, orange);
	    inv.setItem(4, yellow);
	    inv.setItem(5, lightred);
	    inv.setItem(6, red);
	    inv.setItem(7, pink);
	    inv.setItem(8, gray);
	    p.openInventory(inv);
	    return false;
	  }
}