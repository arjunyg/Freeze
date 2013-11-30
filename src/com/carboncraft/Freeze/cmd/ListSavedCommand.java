
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Set;

import com.carboncraft.freeze.Freeze;

public class ListSavedCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public ListSavedCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

    public void execute(CommandSender sender) {
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "List takes no arguments.");
            return;
        }

        File playerListsFile = new File(plugin.getDataFolder(), "playerlists.yml");
        YamlConfiguration savedLists = YamlConfiguration.loadConfiguration(playerListsFile);
        Set<String> lists = savedLists.getKeys(false);
        if (lists.size() == 0) {
            sender.sendMessage(ChatColor.RED + "There are no saved whitelists!");
        }
        else {
            sender.sendMessage(ChatColor.GOLD + "Saved whitelists:");
            for (String s : lists) {
                sender.sendMessage(ChatColor.WHITE + s);
            }
        }
    }
}
