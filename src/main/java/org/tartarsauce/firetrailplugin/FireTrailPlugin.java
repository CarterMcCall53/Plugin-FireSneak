package org.tartarsauce.firetrailplugin;

import org.bukkit.Bukkit;
import org.bukkit.block.data.type.Fire;
import org.bukkit.plugin.java.JavaPlugin;

public final class FireTrailPlugin extends JavaPlugin {

    public static FireTrailPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
