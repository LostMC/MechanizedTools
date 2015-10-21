package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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
        Location signBlockLocation = workArea.getSignBlockLocation();
        Block block = signBlockLocation.getBlock();
        Block relative = block.getRelative(BlockFace.SOUTH);
        Block relative1 = relative.getRelative(BlockFace.SOUTH);
        Block blockToMine = relative1.getRelative(BlockFace.DOWN);
        if (blockToMine.getType() == Material.AIR) {
            blockToMine = blockToMine.getRelative(BlockFace.DOWN);
        }
        scheduler.runTask(plugin, new WorkAreaBlockMiner(blockToMine));
    }
}
