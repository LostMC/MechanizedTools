package org.lostmc.mctesting;

import com.avaje.ebean.EbeanServer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginLogger;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class MockJavaPlugin implements Plugin {
    private final String pluginName;
    private boolean enabled = true;

    public MockJavaPlugin(String pluginName) {
        this.pluginName = pluginName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return pluginName;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public PluginDescriptionFile getDescription() {
        return new PluginDescriptionFile(pluginName, "1.0", "test.test");
    }

    public File getDataFolder() {
        throw new UnsupportedOperationException();
    }

    public FileConfiguration getConfig() {
        throw new UnsupportedOperationException();
    }

    public InputStream getResource(String filename) {
        throw new UnsupportedOperationException();
    }

    public void saveConfig() {
        throw new UnsupportedOperationException();
    }

    public void saveDefaultConfig() {
        throw new UnsupportedOperationException();
    }

    public void saveResource(String resourcePath, boolean replace) {
        throw new UnsupportedOperationException();
    }

    public void reloadConfig() {
        throw new UnsupportedOperationException();
    }

    public PluginLogger getLogger() {
        throw new UnsupportedOperationException();
    }

    public PluginLoader getPluginLoader() {
        throw new UnsupportedOperationException();
    }

    public Server getServer() {
        throw new UnsupportedOperationException();
    }

    public void onDisable() {
        throw new UnsupportedOperationException();
    }

    public void onLoad() {
        throw new UnsupportedOperationException();
    }

    public void onEnable() {
        throw new UnsupportedOperationException();
    }

    public boolean isNaggable() {
        throw new UnsupportedOperationException();
    }

    public void setNaggable(boolean canNag) {
        throw new UnsupportedOperationException();
    }

    public EbeanServer getDatabase() {
        throw new UnsupportedOperationException();
    }

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        throw new UnsupportedOperationException();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        throw new UnsupportedOperationException();
    }
}
