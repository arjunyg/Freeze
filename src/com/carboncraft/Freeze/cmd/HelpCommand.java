
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.carboncraft.freeze.Freeze;

public class HelpCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public HelpCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

	public void execute(CommandSender sender) {
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Help takes no arguments.");
            return;
        }
        sender.sendMessage(ChatColor.YELLOW + "------------------ " + ChatColor.DARK_RED + "Usage for freeze" + ChatColor.YELLOW + " ------------------");
        sender.sendMessage(ChatColor.GOLD + "/freeze [arguments ...] ");
        sender.sendMessage(ChatColor.DARK_RED + "Arguments:");
        sender.sendMessage(ChatColor.GOLD + "addlimit:<limit> " + ChatColor.WHITE + "Randomly select the number of players specified by <limit> and add them to the whitelist.");
        sender.sendMessage(ChatColor.GOLD + "clear " + ChatColor.WHITE + "Clear the whitelist (always is processed first, regardless of input order).");
        sender.sendMessage(ChatColor.GOLD + "enable " + ChatColor.WHITE + "Enable the whitelist.");
        sender.sendMessage(ChatColor.GOLD + "help " + ChatColor.WHITE + "Print this help message.");
    }
}