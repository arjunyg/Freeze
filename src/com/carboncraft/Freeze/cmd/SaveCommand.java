
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.OfflinePlayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.carboncraft.freeze.Freeze;

public class SaveCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public SaveCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

    public void execute(CommandSender sender) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Save takes exactly one argument.");
            return;
        }
        if (!args[1].matches("[[a-z][A-Z][0-9][_|/<>]]+?")) {
            sender.sendMessage(ChatColor.RED + "Invalid list name.");
            return;
        }

        File playerListsFile = new File(plugin.getDataFolder(), "playerlists.yml");
        YamlConfiguration savedLists = YamlConfiguration.loadConfiguration(playerListsFile);
        ArrayList<String> playerNames = new ArrayList<String>();
        for (OfflinePlayer p : plugin.getServer().getWhitelistedPlayers()) {
            playerNames.add(p.getName());
        }
        savedLists.set(args[1], playerNames);
        try {
            savedLists.save(playerListsFile);
            sender.sendMessage(ChatColor.GREEN + "Saved " + ChatColor.AQUA + Integer.toString(playerNames.size()) + ChatColor.GREEN + " player" + ((playerNames.size()!=1)?"s":"") + " to " + ChatColor.AQUA + args[1] + ChatColor.GREEN + ".");
        }
        catch (IOException e) {
            Logger.getLogger("Minecraft.Freeze").severe("[Freeze] IOException: Could not save player list to file! Is plugins/Freeze/playerlists.yml writeable?");
            sender.sendMessage(ChatColor.RED + "The list could not be saved. Contact an administrator to resolve this issue.");
        }
    }
}
