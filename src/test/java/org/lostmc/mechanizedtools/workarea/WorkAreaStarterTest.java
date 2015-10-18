package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WorkAreaStarterTest {
    @Test
    public void runnerLaunchesWorkAreaBuilder() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        WorkAreaBuilder builder = mock(WorkAreaBuilder.class);
        WorkAreaStarter runner = new WorkAreaStarter(builder, signBlock);

        runner.run();

        verify(builder).build(signBlock);
    }
}