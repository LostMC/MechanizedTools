package org.lostmc.mechanizedtools;

import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class MechanizedTools extends JavaPlugin {
    private final PluginEnabler enabler = new PluginEnabler();

    @Override
    public void onEnable() {
        enabler.onEnable(this, getServer());
    }
}
