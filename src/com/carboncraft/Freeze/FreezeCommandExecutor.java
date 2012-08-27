
package com.carboncraft.Freeze;

import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.Scanner;

public class FreezeCommandExecutor implements CommandExecutor {

    private Freeze plugin;
    private final Logger log = Logger.getLogger("Minecraft.Freeze");

    public FreezeCommandExecutor(Freeze plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        FreezeCommand freezeCmd = new FreezeCommand(plugin, sender);
        for (int c = 0; c < args.length; c++) {
            switch (args[c].charAt(0)) {
				case 'c':
					if (args[c].length() > 1) {
						helpMessage(sender);
						return true;
					}
					freezeCmd.setClear();
					break;
				case 'e':
					if (args[c].length() > 1) {
						helpMessage(sender);
						return true;
					}
					freezeCmd.setCheckWhitelistEnabled();
					break;
				case 'p':
					Scanner scanner = new Scanner(args[c]).useDelimiter("[a-z]");
					if (!scanner.hasNextInt()) {
						helpMessage(sender);
						return true;
					}
					freezeCmd.setPlayerLimit(scanner.nextInt());
					break;
                default:
                    helpMessage(sender);
                    return true;
            }
        }
        freezeCmd.execute();
        return true;
    }

/*    private void freezeOnlinePlayers() {
        sender.sendMessage(ChatColor.GREEN+"Whitelisted "+ChatColor.AQUA+Integer.toString(freeze())+ChatColor.GREEN+" players.");
    }

    private void freezeWithWhitelistCheck(CommandSender sender) {
        if (server.hasWhitelist()) {
            sender.sendMessage(ChatColor.RED+"Server already whitelisted!");
        }
        else {
            server.setWhitelist(true);
            sender.sendMessage(ChatColor.GREEN+"Enabled whitelist.");
        }
    }
*/
    private void helpMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.YELLOW+"------------------ " + ChatColor.DARK_RED + "Usage for freeze" + ChatColor.YELLOW + " ------------------");
		sender.sendMessage(ChatColor.GOLD+"/freeze [arguments ...]: " + ChatColor.WHITE + "Add all online users to the whitelist.");
		sender.sendMessage(ChatColor.DARK_RED + "Arguments:");
		sender.sendMessage(ChatColor.GOLD+"c: " + ChatColor.WHITE + "Clear the whitelist (ignores other arguments).");
		sender.sendMessage(ChatColor.GOLD+"e: " + ChatColor.WHITE + "Enable the whitelist.");
		sender.sendMessage(ChatColor.GOLD+"p<limit>: " + ChatColor.WHITE + "Randomly select the number of players specified by <limit> and add them to the whitelist.");
    }
}
