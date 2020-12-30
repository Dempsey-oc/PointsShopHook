package ch.dempsey.shop.thread;

import org.bukkit.plugin.Plugin;

import ch.dempsey.shop.gui.FileManager;

public class FileLoader extends Thread{
	
	private Plugin p;
	
	public FileLoader(Plugin p) {
		this.p = p;
	}
	
	public void run() {
		FileManager.loadFiles(p);
	}
	
}
