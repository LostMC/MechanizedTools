package org.lostmc.mechanizedtools;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.junit.Test;
import org.lostmc.mctesting.MockJavaPlugin;
import org.lostmc.mctesting.MockServer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PluginEnablerTest {
    private final MockServer server = new MockServer();
    private final PluginManager pluginManager = mock(PluginManager.class);
    private final Plugin plugin = new MockJavaPlugin("");
    private final PluginEnabler enabler = new PluginEnabler();

    @Test
    public void registerSignInteractionListener() {
        server.setPluginManager(pluginManager);

        enabler.onEnable(plugin, server);

        verify(pluginManager).registerEvents(any(SignInteractionListener.class), eq(plugin));
    }
}
