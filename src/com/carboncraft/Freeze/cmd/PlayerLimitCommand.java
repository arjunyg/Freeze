
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import com.carboncraft.freeze.Freeze;

public class PlayerLimitCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public PlayerLimitCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

	public void execute(CommandSender sender) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Add with limit takes exactly one argument.");
            return;
        }
        int pLimit = -1;
        try {
            pLimit = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Argument not an integer!");
            return;
        }
        if (pLimit > 0) {
            ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(plugin.getServer().getOnlinePlayers()));
            Collections.shuffle(players);
            int count = 0;
            for (Player p : players) {
                if (count >= pLimit) {
                    break;
                }
                if (!p.isWhitelisted()) {
                    p.setWhitelisted(true);
                    count++;
                }
            }
            sender.sendMessage(ChatColor.GREEN + "Whitelisted " + ChatColor.AQUA + Integer.toString(count) + ChatColor.GREEN + " player" + ((count!=1)?"s":"") + ".");
        }
        else {
            sender.sendMessage(ChatColor.RED + "Player limit must be at least 1!");
        }
    }
}
