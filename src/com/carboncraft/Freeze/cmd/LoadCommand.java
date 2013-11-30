
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.OfflinePlayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

import com.carboncraft.freeze.Freeze;

public class LoadCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public LoadCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

    public void execute(CommandSender sender) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Load takes exactly one argument.");
            return;
        }
        if (!args[1].matches("[[a-z][A-Z][0-9][_|/<>]]+?")) {
            sender.sendMessage(ChatColor.RED + "Invalid list name.");
            return;
        }

        File playerListsFile = new File(plugin.getDataFolder(), "playerlists.yml");
        YamlConfiguration savedLists = YamlConfiguration.loadConfiguration(playerListsFile);
        ArrayList list = null;
        try {
            list = (ArrayList)savedLists.get(args[1]);
        }
        catch (ClassCastException e) {
            sender.sendMessage(ChatColor.RED + "Saved whitelist format invalid!");
        }
        if (list == null) {
            sender.sendMessage(ChatColor.RED + "List not found!");
            return;
        }
        Set<OfflinePlayer> whitelist = plugin.getServer().getWhitelistedPlayers();
        for (OfflinePlayer p : whitelist) {
            p.setWhitelisted(false);
        }
        sender.sendMessage(ChatColor.GREEN + "Removed " + ChatColor.AQUA + Integer.toString(whitelist.size()) + ChatColor.GREEN + " player" + ((whitelist.size()!=1)?"s":"") + " from the whitelist.");
        try {
            for (Object o : list) {
                plugin.getServer().getOfflinePlayer((String)o).setWhitelisted(true);
            }
            sender.sendMessage(ChatColor.GREEN + "Loaded " + ChatColor.AQUA + Integer.toString(list.size()) + ChatColor.GREEN + " player" + ((list.size()!=1)?"s":"") + " to the whitelist.");
        }
        catch (ClassCastException e) {
            sender.sendMessage(ChatColor.RED + "Saved whitelist format invalid!");
        }
    }
}
