package me.mchiappinam.pdghfake;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {
	private Main plugin;

	public Comando(Main main) {
		plugin = main;
	}
	
  	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("fake")) {
			if(!sender.hasPermission("pdgh.moderador")) {
				sender.sendMessage("§cSem permissões");
				return true;
			}
			if(args.length>1) {
				sender.sendMessage("§cUse: /fake ou /fake <nick>");
				return true;
        	}else if(args.length==1) {
				if(plugin.getServer().getPlayer(args[0]) == null) {
					sender.sendMessage("§cO jogador §e"+args[0]+" §cnão está online.");
					sender.sendMessage("§cUse: /fake ou /fake <nick>");
					return true;
				}
				sender.sendMessage("§aVerificação para "+plugin.getServer().getPlayer(args[0]).getName()+" iniciada.");
		  		for (Player todos : plugin.getServer().getOnlinePlayers()) {
		  			if(plugin.getServer().getPlayer(args[0]).getAddress().getAddress().getHostAddress().replaceAll("/", "").contains(todos.getAddress().getAddress().getHostAddress().replaceAll("/", ""))) {
		  				if(plugin.getServer().getPlayer(args[0]).getName()!=todos.getName()) {
			  				sender.sendMessage("§c"+plugin.getServer().getPlayer(args[0]).getName()+" §etem o mesmo IP que o §c"+todos.getName()+" §e(§c"+plugin.getServer().getPlayer(args[0]).getAddress().getAddress().getHostAddress().replaceAll("/", "")+"§e)");
		  				}
		  			}
		  		}
				sender.sendMessage("§aVerificação para "+plugin.getServer().getPlayer(args[0]).getName()+" finalizada.");
				return true;
        	}
			if(args.length==0) {
				sender.sendMessage("§aVerificação global iniciada.");
		  		for (Player p : plugin.getServer().getOnlinePlayers()) {
			  		for (Player todos : plugin.getServer().getOnlinePlayers()) {
			  			if(p.getAddress().getAddress().getHostAddress().replaceAll("/", "").contains(todos.getAddress().getAddress().getHostAddress().replaceAll("/", ""))) {
			  				if(p.getName()!=todos.getName()) {
					  			sender.sendMessage("§c"+p.getName()+" §etem o mesmo IP que o §c"+todos.getName()+" §e(§c"+p.getAddress().getAddress().getHostAddress().replaceAll("/", "")+"§e)");
			  				}
			  			}
			  		}
		  		}
				sender.sendMessage("§aVerificação global finalizada.");
				return true;
        	}
        }
		return false;
    }
  	
}