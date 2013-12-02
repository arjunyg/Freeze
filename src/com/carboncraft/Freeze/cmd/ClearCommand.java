
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.OfflinePlayer;

import com.carboncraft.freeze.Freeze;

public class ClearCommand extends CommandComponent {


    static {
        componentPriority = 1;
    }

    public ClearCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

	public void execute(CommandSender sender) {
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Clear takes no arguments.");
            return;
        }
        int count = 0;
        for (OfflinePlayer player : plugin.getServer().getWhitelistedPlayers()) {
            player.setWhitelisted(false);
            count++;
        }
        sender.sendMessage(ChatColor.GREEN + "Removed " + ChatColor.AQUA + Integer.toString(count) + ChatColor.GREEN + " player" + ((count!=1)?"s":"") + " from the whitelist.");
    }
}
