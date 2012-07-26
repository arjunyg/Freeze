
package com.carboncraft.Freeze;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Freeze extends JavaPlugin {

    private final Logger log = Logger.getLogger("Minecraft.Freeze");
    private Server server;
   
    public void onEnable() {
        log.setLevel(Level.INFO);
        PluginDescriptionFile pdFile = this.getDescription();
        log.info("[Freeze] " + pdFile.getName() + " v" + pdFile.getVersion() + " enabled.");
        server = getServer();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("freeze")) {
            int count = 0;
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN+"Whitelisted "+ChatColor.AQUA+Integer.toString(freeze())+ChatColor.GREEN+" players.");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equals("-e")) {
                    if (server.hasWhitelist()) {
                        sender.sendMessage(ChatColor.RED+"Server already whitelisted!");
                    }
                    else {
                        server.setWhitelist(true);
                        sender.sendMessage(ChatColor.GREEN+"Enabled whitelist.");
                    }
                    sender.sendMessage(ChatColor.GREEN+"Whitelisted "+ChatColor.AQUA+Integer.toString(freeze())+ChatColor.GREEN+" players.");
                }
                return true;
            }
        }
        return false; 
    }

    public int freeze() {
        int count = 0;
        for ( Player p : server.getOnlinePlayers() ) {
            if (!p.isWhitelisted()) {
                p.setWhitelisted(true);
                count++;
            }
        }
        return count;
    }

    public void onDisable() {
        log.info("[Freeze] Freeze plugin shutting down. The whitelist will be saved.");
    }
}
