package org.lostmc.mechanizedtools.workarea;

import org.bukkit.plugin.java.JavaPlugin;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockBukkitScheduler;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class WorkAreaLaborerTest {
    private final MockBukkitScheduler scheduler = new MockBukkitScheduler();
    private final JavaPlugin plugin = mock(JavaPlugin.class);
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();
    private Map<Integer, List<MockBlock>> blockLists;

    @Before
    public void beforeEach() {
        helper.createValidArea();
        blockLists = helper.getBlockListsByLayer();
    }

    @Test
    public void startMiningTask() {
        MockBlock signBlock = helper.getSignBlock();

        WorkArea workArea = new WorkAreaBuilder().build(signBlock);

        WorkAreaLaborer laborer = new WorkAreaLaborer(workArea, scheduler, plugin);

        laborer.run();

        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
        assertThat(scheduler.getPlugin(), equalTo(plugin));
    }

    @Test
    public void findCorrectFirstBlock() {
        MockBlock signBlock = helper.getSignBlock();

        WorkArea workArea = new WorkAreaBuilder().build(signBlock);

        WorkAreaLaborer laborer = new WorkAreaLaborer(workArea, scheduler, plugin);

        laborer.run();

        WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();

        assertThat(runnable.getBlockToMine(), equalTo(blockLists.get(63).get(0)));
    }
}