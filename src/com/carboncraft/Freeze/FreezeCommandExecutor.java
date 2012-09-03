
package com.carboncraft.Freeze;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.ChatColor;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.ArrayList;
import java.util.Scanner;

import org.bukkit.OfflinePlayer;

public class FreezeCommandExecutor implements CommandExecutor {

    private final Logger log = Logger.getLogger("Minecraft.Freeze");

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        FreezeCommand freezeCmd = new FreezeCommand((Freeze)((PluginCommand)cmd).getPlugin(), sender);
        for (int c = 0; c < args.length; c++) {
            String[] split = args[c].split(":");
            if (args[c].length() > 0) {
                switch (args[c].charAt(0)) {
                    case 'c':
                        if (args[c].length() > 1 && !args[c].equals("clear")) {
                            helpMessage(sender);
                            return true;
                        }
                        freezeCmd.setClear();
                        break;
                    case 'e':
                        if (args[c].length() > 1 && !args[c].equals("enable")) {
                            helpMessage(sender);
                            return true;
                        }
                        freezeCmd.setCheckWhitelistEnabled();
                        break;
                    case 'p':
                        if (split.length != 2) {
                            helpMessage(sender);
                            return true;
                        }

                        if (!stringMatches(split[0], "p", "plimit", "playerlimit")) {
                            helpMessage(sender);
                            return true;
                        }

                        Scanner scanner = new Scanner(split[1]);
                        if (!scanner.hasNextInt()) {
                            helpMessage(sender);
                            return true;
                        }
                        freezeCmd.setPlayerLimit(scanner.nextInt());
                        break;
                    case 's':
                        if (split.length != 2) {
                            helpMessage(sender);
                            return true;
                        }
     
                        if (!stringMatches(split[0], "s", "save")) {
                            helpMessage(sender);
                            return true;
                        }

                        if (!split[1].matches("[[a-z][A-Z][0-9][_|/<>]]+?")) {
                            sender.sendMessage(ChatColor.RED + "Invalid list name.");
                            return true;
                        }

                        freezeCmd.setSaveName(split[1]);

                        break;
                        
                    default:
                        helpMessage(sender);
                        return true;
                }
            }
        }
        freezeCmd.execute();
        return true;
    }

/*    private int parseInt(String str) {
        final String digits = "1234567890";
        for (int i = str.length()-1; i >= 0; i--) {
            if ( digits.indexOf( (int)str.charAt(i) ) == -1 ) {
                return (str.charAt(i) == '-') ? i : i+1;
            }
        }
        return i;
    }
*/
    private boolean stringMatches(String target, String ... strings) {
        for (String s : strings)
            if (target.equalsIgnoreCase(s))
                return true;
        return false;
    }

    private void helpMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.YELLOW+"------------------ " + ChatColor.DARK_RED + "Usage for freeze" + ChatColor.YELLOW + " ------------------");
        sender.sendMessage(ChatColor.GOLD+"/freeze [arguments ...]: " + ChatColor.WHITE + "Add all online users to the whitelist.");
        sender.sendMessage(ChatColor.DARK_RED + "Arguments:");
        sender.sendMessage(ChatColor.GOLD+"c " + ChatColor.WHITE + "Clear the whitelist (ignores other arguments).");
        sender.sendMessage(ChatColor.GOLD+"e " + ChatColor.WHITE + "Enable the whitelist.");
        sender.sendMessage(ChatColor.GOLD+"p:<limit> " + ChatColor.WHITE + "Randomly select the number of players specified by <limit> and add them to the whitelist.");
    }
}
