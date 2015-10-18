package org.lostmc.mechanizedtools;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginEnabler {
    public void onEnable(JavaPlugin plugin, Server server) {
        SignInteractionListener listener = new SignInteractionListener(plugin, server.getScheduler());
        server.getPluginManager().registerEvents(listener, plugin);
    }
}
