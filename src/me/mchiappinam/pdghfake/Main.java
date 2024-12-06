package me.mchiappinam.pdghfake;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginCommand("fake").setExecutor(new Comando(this));

		getServer().getConsoleSender().sendMessage("§3[PDGHFake] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHFake] §2Acesse: http://pdgh.com.br/");
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHFake] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHFake] §2Acesse: http://pdgh.com.br/");
	}
  
  
  
  
  
  
  
  
  
  
}