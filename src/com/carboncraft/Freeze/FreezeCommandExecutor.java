
package com.carboncraft.Freeze;

import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Logger;
import java.util.logging.Level;

public class FreezeCommandExecutor implements CommandExecutor {

    private Freeze plugin;
    private Server server;
    private final Logger log = Logger.getLogger("Minecraft.Freeze");

    public FreezeCommandExecutor(Freeze plugin) {
        this.plugin = plugin;
        server = plugin.getServer();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        log.info(cmd.getName());
        int count = 0;
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN+"Whitelisted "+ChatColor.AQUA+Integer.toString(plugin.freeze())+ChatColor.GREEN+" players.");
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
                sender.sendMessage(ChatColor.GREEN+"Whitelisted "+ChatColor.AQUA+Integer.toString(plugin.freeze())+ChatColor.GREEN+" players.");
            }
            return true;
        }
        return false;
    }
}
