/*
 * Copyright (C) 2012 Arjun Govindjee.
 */

package com.carboncraft.freeze;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.carboncraft.metrics.Metrics;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.io.IOException;

public class Freeze extends JavaPlugin {

    private final Logger log = Logger.getLogger("Minecraft.Freeze");
    private Server server;
   
    public void onEnable() {
        log.setLevel(Level.INFO);

        server = getServer();

        FreezeCommandExecutor cmdX = new FreezeCommandExecutor(this);
        getCommand("freeze").setExecutor(cmdX);

        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDisable() {
        log.info("[Freeze] Freeze plugin shutting down. The whitelist will be saved.");
    }
}
