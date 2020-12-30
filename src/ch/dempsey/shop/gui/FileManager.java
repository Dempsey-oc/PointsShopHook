package ch.dempsey.shop.gui;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;



public class FileManager {

	
	
	public static void loadFiles(Plugin p) {
		
		
		
		File dir = new File(p.getDataFolder(), "items");
		
		if(!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		if(!dir.exists()) dir.mkdir();
		
		
		if(dir.list().length == 0) {
			loadExampleYaml(dir);
			System.out.println("[GUI] Loaded example.yml");
		} else {
			Cache.items.clear();
			Cache.files.clear();
			Cache.commands.clear();
			Cache.permissions.clear();
			Cache.prices.clear();
			for(String str : dir.list()) {
				if(str.contains(".yml")) {
					File f = new File(dir, str);
					FileConfiguration config = YamlConfiguration.loadConfiguration(f);
					
					String item = config.getString("id");
					int amount = config.getInt("amount");
					int meta = config.getInt("meta");
					int buy = config.getInt("buy_price");
					String displayname = config.getString("displayname");
					String command = config.getString("command");
					int slot = config.getInt("slot");
					String permission = config.getString("permission");
					
					ItemStack it = new ItemStack(Material.getMaterial(item), amount);
					ItemMeta im = it.getItemMeta();
					im.setCustomModelData(meta);
					ArrayList<String> lore = new ArrayList<String>();
					lore.add(ChatColor.translateAlternateColorCodes('&', "&a " + String.valueOf(buy)) + " Points");
					im.setLore(lore);
					im.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
					
					it.setItemMeta(im);
					
					Cache.items.put(slot, it);
					Cache.commands.put(slot, command);
					Cache.files.add(f);
					Cache.permissions.put(slot, permission);
					Cache.prices.put(slot, buy);
					
					if(Cache.debug) {
						System.out.println("[GUI] Loaded: " + f.getName());
					}
				}
			}
			
			if(Cache.debug) {
				System.out.println("[GUI] Finished Loading Files");
			}
		}
		
		
		
		
	}
	
	private static void loadExampleYaml(File baseDir) {
		File file = new File(baseDir, "example.yml");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		config.set("# Example item configuration for ShopGUI this is what they are supposed to contain or they will not work!", "");
		save(config, file);
		config.set("id", Material.COBWEB.toString());
		save(config, file);
		config.set("amount", 5);
		save(config, file);
		config.set("meta", 0);
		save(config, file);
		config.set("buy_price", 10);
		save(config, file);
		config.set("displayname", "&8CobWeb");
		save(config, file);
		config.set("command", "kit starter %player%");
		save(config, file);
		config.set("slot", 0);
		save(config, file);
		config.set("permission", "shop.web");
		save(config, file);
	}
	
	
	/*
	*  ID
	*  AMOUNT
	*  META 
	*  BUY_PRICE
	*  DISPLAYNAME
	*  COMMAND
	*  SLOT
	*/
	private static void save(FileConfiguration config, File file) {
		try {
			config.save(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
