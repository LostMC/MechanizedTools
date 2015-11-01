package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockBukkitScheduler;
import org.lostmc.mctesting.MockJavaPlugin;
import org.lostmc.mctesting.MockWorld;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class MineableBlockFinderTest {
    private final MockBukkitScheduler scheduler = new MockBukkitScheduler();
    private final Plugin plugin = new MockJavaPlugin("");
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();
    private final WorkAreaBuilder builder = new WorkAreaBuilder();
    private Map<Integer, List<MockBlock>> blockLists;

    @Before
    public void beforeEach() {
        helper.createValidArea();
        blockLists = helper.getBlockListsByLayer();
    }

    @Test
    public void startMiningTask() {
        MockBlock signBlock = helper.getSignBlock();

        WorkArea workArea = builder.build(signBlock);

        MineableBlockFinder laborer = new MineableBlockFinder(workArea, scheduler, plugin);

        laborer.run();

        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
        assertThat(scheduler.getMethod(), containsString("runTask"));
        assertThat(scheduler.getPlugin(), equalTo(plugin));
    }

    @Test
    public void findCorrectFirstBlock() {
        MockBlock signBlock = helper.getSignBlock();

        WorkArea workArea = builder.build(signBlock);

        MineableBlockFinder laborer = new MineableBlockFinder(workArea, scheduler, plugin);

        laborer.run();

        WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();

        assertThat(runnable.getBlockToMine(), equalTo(blockLists.get(63).get(0)));
    }

    @Test
    public void doNotMineIfNoRedstone() {
        MockBlock signBlock = helper.getSignBlock();

        WorkArea workArea = builder.build(signBlock);

        MineableBlockFinder laborer = new MineableBlockFinder(workArea, scheduler, plugin);

        clearRedstone(signBlock.getWorld());

        laborer.run();

        WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();

        assertThat(runnable, nullValue());
    }

    @Ignore
    @Test
    public void doNotMineIfNoSecondRedstone() {
        MockBlock signBlock = helper.getSignBlock();
        WorkArea workArea = builder.build(signBlock);
        MineableBlockFinder laborer = new MineableBlockFinder(workArea, scheduler, plugin);

        MockWorld world = (MockWorld) signBlock.getWorld();
        MockBlock block = (MockBlock) world.getBlockAt(-4, 64, -8);
        block.setMaterial(Material.AIR);

        laborer.run();

        WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();
        assertThat(runnable, nullValue());
    }

    @Test
    public void findCorrectBlockOnOtherLayers() {
        MockBlock signBlock = helper.getSignBlock();
        WorkArea workArea = builder.build(signBlock);
        MineableBlockFinder laborer = new MineableBlockFinder(workArea, scheduler, plugin);
        for (int layer = 63; layer > workArea.getMinimumY(); layer--) {
            clearLayer(signBlock.getWorld(), layer);

            laborer.run();

            WorkAreaBlockMiner runnable = (WorkAreaBlockMiner) scheduler.getRunnable();
            List<MockBlock> mockBlocks = blockLists.get(layer - 1);

            assertThat(runnable, notNullValue());
            assertThat(mockBlocks, notNullValue());
            assertThat(runnable.getBlockToMine(), equalTo(mockBlocks.get(0)));
        }
    }


    private void clearRedstone(World world) {
        MockWorld mockWorld = (MockWorld) world;
        for (int x = mockWorld.getMinimumX(); x < mockWorld.getMaximumX(); x++) {
            for (int z = mockWorld.getMinimumZ(); z < mockWorld.getMaximumZ(); z++) {
                MockBlock block = (MockBlock) mockWorld.getBlockAt(x, 64, z);
                if (block.getType() == Material.REDSTONE_WIRE) {
                    block.setMaterial(Material.AIR);
                }
            }
        }
    }

    private void clearLayer(World world, int layer) {
        MockWorld mockWorld = (MockWorld) world;
        for (int x = mockWorld.getMinimumX(); x < mockWorld.getMaximumX(); x++) {
            for (int z = mockWorld.getMinimumZ(); z < mockWorld.getMaximumZ(); z++) {
                MockBlock block = (MockBlock) mockWorld.getBlockAt(x, layer, z);
                block.setMaterial(Material.AIR);
            }
        }
    }
}