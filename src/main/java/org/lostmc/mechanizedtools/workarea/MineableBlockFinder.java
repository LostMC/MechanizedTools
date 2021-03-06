package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class MineableBlockFinder implements Runnable {
    private final WorkArea workArea;
    private final BukkitScheduler scheduler;
    private final Plugin plugin;

    public MineableBlockFinder(WorkArea workArea, BukkitScheduler scheduler, Plugin plugin) {
        this.workArea = workArea;
        this.scheduler = scheduler;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        int outlineLayer = workArea.getSignBlockLocation().getBlockY();
        World world = workArea.getSignBlockLocation().getWorld();
        boolean foundRedstone = false;
        for (int y = workArea.getMaximumY() - 1; y >= workArea.getMinimumY(); y--) {
            for (int z = workArea.getMinimumZ(); z < workArea.getMaximumZ(); z++) {
                if (isRowBounded(workArea, outlineLayer, z)) {
                    for (int x = workArea.getMinimumX(); x < workArea.getMaximumX(); x++) {
                        Block outlineBLock = world.getBlockAt(x, outlineLayer, z);
                        if (outlineBLock.getType() == Material.REDSTONE_WIRE) {
                            if (foundRedstone) {
                                foundRedstone = false;
                                break;
                            } else {
                                foundRedstone = true;
                            }
                        } else if (foundRedstone) {
                            Block block = world.getBlockAt(x, y, z);
                            if (block.getType() != Material.AIR) {
                                scheduler.runTask(plugin, new WorkAreaBlockMiner(block));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isRowBounded(WorkArea workArea, int y, int z) {
        Block left = findLeftBound(workArea, y, z);
        Block right = findRightBound(workArea, y, z);

        return !(left == null || right == null);
    }

    private Block findLeftBound(WorkArea workArea, int y, int z) {
        World world = workArea.getSignBlockLocation().getWorld();
        for (int x = workArea.getMinimumX(); x <= workArea.getMaximumX(); x++) {
            Block block = world.getBlockAt(x, y, z);
            if (block.getType() == Material.REDSTONE_WIRE) {
                return block;
            }
        }
        return null;
    }

    private Block findRightBound(WorkArea workArea, int y, int z) {
        World world = workArea.getSignBlockLocation().getWorld();
        for (int x = workArea.getMaximumX(); x >= workArea.getMinimumX(); x--) {
            Block block = world.getBlockAt(x, y, z);
            if (block.getType() == Material.REDSTONE_WIRE) {
                return block;
            }
        }
        return null;
    }
}
