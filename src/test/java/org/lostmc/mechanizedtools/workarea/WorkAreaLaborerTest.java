package org.lostmc.mechanizedtools.workarea;

import org.bukkit.block.BlockFace;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockBukkitScheduler;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class WorkAreaLaborerTest {
    private final MockBukkitScheduler scheduler = new MockBukkitScheduler();
    private final JavaPlugin plugin = mock(JavaPlugin.class);
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();

    @Test
    public void startMiningTask() {
        MockBlock[][][] array = MockBlock.createBlockArray(20, 20, 128, 0);
        MockBlock signBlock = array[3][1][64];
        MockBlock engineBlock = (MockBlock) signBlock.getRelative(BlockFace.SOUTH);
        MockBlock chestBlock = (MockBlock) engineBlock.getRelative(BlockFace.UP);
        helper.createValidArea(signBlock, engineBlock, chestBlock, BlockFace.NORTH,
                Arrays.asList("Excavator", "56"));
        MockBlock targetBlock = (MockBlock) engineBlock.getRelative(BlockFace.SOUTH).getRelative(BlockFace.DOWN);

        WorkArea workArea = new WorkAreaBuilder().build(signBlock);

        WorkAreaLaborer laborer = new WorkAreaLaborer(workArea, scheduler, plugin);

        laborer.run();

        Runnable runnable = scheduler.getRunnable();
        assertThat(runnable, instanceOf(WorkAreaBlockMiner.class));
        assertThat(((WorkAreaBlockMiner)runnable).getBlockToMine(), equalTo(targetBlock));
        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
        assertThat(scheduler.getPlugin(), equalTo(plugin));
    }
}