/*
 * Copyright (C) 2012 Arjun Govindjee.
 */

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
        //log.info("[Freeze] " + pdFile.getName() + " v" + pdFile.getVersion() + " enabled.");

        server = getServer();

        FreezeCommandExecutor cmdX = new FreezeCommandExecutor(this);
        getCommand("freeze").setExecutor(cmdX);
    }

    public void onDisable() {
        log.info("[Freeze] Freeze plugin shutting down. The whitelist will be saved.");
    }
}
