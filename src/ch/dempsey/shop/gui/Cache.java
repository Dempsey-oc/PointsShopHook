package ch.dempsey.shop.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

public class Cache {

	protected static HashMap<Integer, ItemStack> items = new HashMap<Integer, ItemStack>();
	protected static ArrayList<File> files = new ArrayList<File>();
	protected static HashMap<Integer, String> commands = new HashMap<Integer, String>();
	protected static HashMap<Integer, String> permissions = new HashMap<Integer, String>();
	protected static HashMap<Integer, Integer> prices = new HashMap<Integer, Integer>();
	
	
	protected static boolean debug = true;
	
}
