
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.carboncraft.freeze.Freeze;

public class FreezeCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public FreezeCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

	public void execute(CommandSender sender) {
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Freeze takes no arguments.");
            return;
        }
        Player[] players = plugin.getServer().getOnlinePlayers();
        int count = 0;
        for (Player p : players) {
            if (!p.isWhitelisted()) {
                p.setWhitelisted(true);
                count++;
            }
        }
        sender.sendMessage(ChatColor.GREEN + "Whitelisted " + ChatColor.AQUA + Integer.toString(count) + ChatColor.GREEN + " player" + ((count!=1)?"s":"") + ".");
    }
}
