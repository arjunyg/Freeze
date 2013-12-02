
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.Server;

import com.carboncraft.freeze.Freeze;

public class DisableCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public DisableCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

	public void execute(CommandSender sender) {
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Disable takes no arguments.");
            return;
        }
        Server server = plugin.getServer();
        if (!server.hasWhitelist()) {
            server.setWhitelist(false);
            sender.sendMessage(ChatColor.GREEN + "Disabled the whitelist.");
        }
        else {
            sender.sendMessage(ChatColor.RED + "The whitelist is already enabled!");
        }
    }
}
