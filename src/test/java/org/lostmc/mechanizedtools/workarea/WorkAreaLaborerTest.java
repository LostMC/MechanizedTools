package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.Before;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockBukkitScheduler;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class WorkAreaLaborerTest {
    private final MockBukkitScheduler scheduler = new MockBukkitScheduler();
    private final JavaPlugin plugin = mock(JavaPlugin.class);
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();

    @Before
    public void beforeEach() {
        helper.createValidArea();
    }

    @Test
    public void startMiningTask() {
        MockBlock signBlock = helper.getSignBlock();
        MockBlock targetBlock = (MockBlock) helper.getEngineBlock().getRelative(BlockFace.SOUTH).getRelative(BlockFace.DOWN);

        WorkArea workArea = new WorkAreaBuilder().build(signBlock);

        WorkAreaLaborer laborer = new WorkAreaLaborer(workArea, scheduler, plugin);

        laborer.run();

        WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();
        assertThat(runnable.getBlockToMine(), equalTo(targetBlock));
        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
        assertThat(scheduler.getPlugin(), equalTo(plugin));
    }

    @Test
    public void doNotMineAirBlock() {
        MockBlock airBlock = (MockBlock) helper.getEngineBlock().getRelative(BlockFace.SOUTH).getRelative(BlockFace.DOWN);
        airBlock.setType(Material.AIR);
        MockBlock targetBlock = (MockBlock) airBlock.getRelative(BlockFace.DOWN);

        WorkArea workArea = new WorkAreaBuilder().build(helper.getSignBlock());

        WorkAreaLaborer laborer = new WorkAreaLaborer(workArea, scheduler, plugin);

        laborer.run();

        WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();
        assertThat(runnable.getBlockToMine(), equalTo(targetBlock));
    }
}