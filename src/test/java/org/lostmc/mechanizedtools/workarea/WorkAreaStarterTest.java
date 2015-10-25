package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockBukkitScheduler;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WorkAreaStarterTest {
    private final MockBukkitScheduler scheduler = new MockBukkitScheduler();
    private final JavaPlugin plugin = mock(JavaPlugin.class);

    @Test
    public void runnerLaunchesWorkAreaBuilder() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        WorkAreaBuilder builder = mock(WorkAreaBuilder.class);
        when(builder.build(signBlock)).thenReturn(new WorkArea());
        WorkAreaStarter starter = new WorkAreaStarter(builder, signBlock, scheduler, plugin);

        starter.run();

        verify(builder).build(signBlock);
    }

    @Test
    public void starterRunsSignUpdateTaskForInvalidArea() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        WorkAreaBuilder builder = mock(WorkAreaBuilder.class);
        WorkArea workArea = new WorkArea();
        workArea.setValid(false);
        when(builder.build(signBlock)).thenReturn(workArea);
        WorkAreaStarter starter = new WorkAreaStarter(builder, signBlock, scheduler, plugin);

        starter.run();

        assertThat(scheduler.getPlugin(), sameInstance(plugin));
        assertThat(scheduler.getRunnable(), instanceOf(WorkAreaSignUpdater.class));
        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
    }

    @Test
    public void startLaborTaskForValidArea() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        WorkAreaBuilder builder = mock(WorkAreaBuilder.class);
        WorkArea workArea = new WorkArea();
        workArea.setValid(true);
        when(builder.build(signBlock)).thenReturn(workArea);
        WorkAreaStarter starter = new WorkAreaStarter(builder, signBlock, scheduler, plugin);

        starter.run();

        assertThat(scheduler.getPlugin(), sameInstance(plugin));
        assertThat(scheduler.getRunnable(), instanceOf(MineableBlockFinder.class));
        assertThat(scheduler.getMethod(), containsString("Asynchronously"));
    }
}