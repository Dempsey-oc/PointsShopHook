package ch.dempsey.shop.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import ch.dempsey.pointsapi.Main;
import net.md_5.bungee.api.ChatColor;

public class InventoryClick implements Listener{

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if(e.getClickedInventory() != null) {
			if(e.getCurrentItem() != null) {
				
				if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Points")) {
					e.setCancelled(true);
					String command = Cache.commands.get(e.getSlot());
					String fin = command.replaceAll("%player%", ((Player)e.getWhoClicked()).getName());
					
					if(Main.getAPIInstance().getPoints((Player)e.getWhoClicked()) >= Cache.prices.get(e.getSlot())) {
						Main.getAPIInstance().takePoints((Player)e.getWhoClicked(), Cache.prices.get(e.getSlot()));
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), fin);
						((Player)e.getWhoClicked()).sendMessage(ChatColor.GREEN + "You just paid " + String.valueOf(Cache.prices.get(e.getSlot())) + " points!");
					} else {
						((Player)e.getWhoClicked()).sendMessage(ChatColor.RED + "You do not have enough points to purchase this item!");
					}
					
					
				}
				
			}
			
		}
		
	}
	
}