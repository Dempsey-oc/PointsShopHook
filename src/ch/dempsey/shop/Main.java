package ch.dempsey.shop;

import org.bukkit.plugin.java.JavaPlugin;

import ch.dempsey.shop.command.Shop;
import ch.dempsey.shop.gui.InventoryClick;
import ch.dempsey.shop.thread.FileLoader;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		
		new FileLoader(this).start();
		
		getServer().getPluginManager().registerEvents(new InventoryClick(), this);
		getCommand("shop").setExecutor(new Shop());
		
	}
	
}
