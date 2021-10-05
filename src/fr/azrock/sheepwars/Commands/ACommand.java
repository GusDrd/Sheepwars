package fr.azrock.sheepwars.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ACommand implements CommandExecutor {
	
	public String name;
	
	public abstract void execute(Player player, String[] args);
	
	private static JavaPlugin plugin;
	
	
	
	public ACommand(String name) {
		this.name = name;
		
		plugin.getCommand(name).setExecutor(this);
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		
		if(!(sender instanceof Player)) return false;
		
		if(!(cmd.getLabel().equalsIgnoreCase(name))) return false;
						
		
		execute(player, args);
		return true;
	}
	
	
	
	public static void registerCommands(JavaPlugin pl) {
		plugin = pl;
		
		new SWCommand();
	}
}
