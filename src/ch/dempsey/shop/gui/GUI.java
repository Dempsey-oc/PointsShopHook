package ch.dempsey.shop.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUI {

	public static void open(Player player) {
		int size;
		
		if(Cache.items.size() < 9) {
			size = 9;
		}else {
			size = Cache.items.size();
		}
		
		
		Inventory inv = Bukkit.createInventory(player, size, "�6Points Shop");
		
		
		
		for(int i : Cache.items.keySet()) {
			inv.setItem(i, Cache.items.get(i));
		}
		
		player.openInventory(inv);
		
	}
	
}
