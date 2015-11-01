package org.lostmc.mechanizedtools;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public class PluginEnabler {
    public void onEnable(Plugin plugin, Server server) {
        SignInteractionListener listener = new SignInteractionListener(plugin, server.getScheduler());
        server.getPluginManager().registerEvents(listener, plugin);
    }
}
