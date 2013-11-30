
package com.carboncraft.freeze.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.carboncraft.freeze.Freeze;

public class DeleteSaveCommand extends CommandComponent {

    static {
        componentPriority = 1;
    }

    public DeleteSaveCommand(Freeze plugin, int index, String args[]) {
        super(plugin, index, args);
    }

    public void execute(CommandSender sender) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Delete takes exactly one argument.");
            return;
        }

        File playerListsFile = new File(plugin.getDataFolder(), "playerlists.yml");
        YamlConfiguration savedLists = YamlConfiguration.loadConfiguration(playerListsFile);
        if (savedLists.contains(args[1])) {
            savedLists.set(args[1], null);
            try {
                savedLists.save(playerListsFile);
                sender.sendMessage(ChatColor.GREEN + "Deleted list: " + ChatColor.AQUA + args[1]);
            }
            catch (IOException e) {
                Logger.getLogger("Minecraft.Freeze").severe("[Freeze] IOException: Could not save player list to file! Is plugins/Freeze/playerlists.yml writeable?");
                sender.sendMessage(ChatColor.RED + "The list could not be saved. Contact an administrator to resolve this issue.");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "The list " + ChatColor.DARK_RED + args[1] + ChatColor.RED  +" could not be found.");
        }
    }
}
