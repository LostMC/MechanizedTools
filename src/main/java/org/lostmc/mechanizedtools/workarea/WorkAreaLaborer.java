package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class WorkAreaLaborer implements Runnable {
    private final WorkArea workArea;
    private final BukkitScheduler scheduler;
    private final JavaPlugin plugin;

    public WorkAreaLaborer(WorkArea workArea, BukkitScheduler scheduler, JavaPlugin plugin) {
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
