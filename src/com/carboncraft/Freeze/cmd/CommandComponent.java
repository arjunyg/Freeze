package com.carboncraft.freeze.cmd;

import org.bukkit.command.CommandSender;

import com.carboncraft.freeze.Freeze;

public abstract class CommandComponent implements Comparable {
    
    protected static int componentPriority;

    protected Freeze plugin;
    protected String[] args;
    private int index;

    protected CommandComponent(Freeze plugin, int index, String[] args) {
        this.plugin = plugin;
        this.index = index;
        this.args = args;
    }

	public abstract void execute(CommandSender sender);

    public int compareTo(Object o) {
        CommandComponent component = (CommandComponent)o;
        if (this.componentPriority != component.componentPriority) {
            return this.componentPriority - component.componentPriority;
        }
        else {
            return this.index - component.index;
        }
    }
}
