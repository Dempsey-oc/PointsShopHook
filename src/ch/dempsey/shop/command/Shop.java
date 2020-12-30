package ch.dempsey.shop.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.dempsey.shop.gui.GUI;


public class Shop implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("shop")) {
			if(sender instanceof Player) {
				GUI.open((Player)sender);
			}
		}
		
		return true;
	}
	
}
