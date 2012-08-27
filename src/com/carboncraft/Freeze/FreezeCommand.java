
package com.carboncraft.Freeze;

import org.bukkit.Server;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FreezeCommand {
    
    private Server server;
    private Freeze plugin;
    private CommandSender sender;

    private boolean clear;
    private int playerLimit;
    private boolean checkWhitelistEnabled;

    public FreezeCommand(Freeze plugin, CommandSender sender) {
        this.plugin = plugin;
        this.server = plugin.getServer();
        this.sender = sender;
    }

    public void setClear() {
        this.clear = true;
    }

    public void setPlayerLimit(int playerLimit) {
        this.playerLimit = playerLimit;
    }

    public void setCheckWhitelistEnabled() {
        this.checkWhitelistEnabled = true;
    }

    public void execute() {
        int count = 0;
        
        if (clear) {
            for (OfflinePlayer p : server.getWhitelistedPlayers()) {
                p.setWhitelisted(false);
                count++;
            }
            sender.sendMessage(ChatColor.GREEN + "Removed " + ChatColor.AQUA + Integer.toString(count) + ChatColor.GREEN + " player" + ((count!=1)?"s":"") + " from the whitelist.");
            return;
        }

        if (checkWhitelistEnabled) {
            sender.sendMessage(ChatColor.GREEN + "Making sure the whitelist is enabled...");
            if (server.hasWhitelist()) {
                sender.sendMessage(ChatColor.RED + "The server already whitelisted!");
            }
            else {
                server.setWhitelist(true);
                sender.sendMessage(ChatColor.GREEN + "Enabled the whitelist.");
            }
        }

        ArrayList<OfflinePlayer> players = new ArrayList<OfflinePlayer>(Arrays.asList(server.getOnlinePlayers()));
        Collections.shuffle(players);
        for ( OfflinePlayer p : players ) {
            if (playerLimit > 0 && count == playerLimit) {
                break;
            }
            if (!p.isWhitelisted()) {
                p.setWhitelisted(true);
                count++; 
            }
        }
        sender.sendMessage(ChatColor.GREEN + "Whitelisted " + ChatColor.AQUA + Integer.toString(count) + ChatColor.GREEN + " player" + ((count!=1)?"s":"") + ".");
    }
}
