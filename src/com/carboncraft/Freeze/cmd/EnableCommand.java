
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.Server;

import com.carboncraft.freeze.Freeze;

public class EnableCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public EnableCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

	public void execute(CommandSender sender) {
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Enable takes no arguments.");
            return;
        }
        Server server = plugin.getServer();
        if (!server.hasWhitelist()) {
            server.setWhitelist(true);
            sender.sendMessage(ChatColor.GREEN + "Enabled the whitelist.");
        }
        else {
            sender.sendMessage(ChatColor.RED + "The whitelist is already enabled!");
        }
    }
}
