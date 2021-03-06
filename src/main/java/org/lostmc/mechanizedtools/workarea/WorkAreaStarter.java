package org.lostmc.mechanizedtools.workarea;

import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class WorkAreaStarter implements Runnable {
    private final WorkAreaBuilder builder;
    private final Block signBlock;
    private final BukkitScheduler scheduler;
    private final Plugin plugin;

    public WorkAreaStarter(WorkAreaBuilder builder, Block signBlock, BukkitScheduler scheduler, Plugin plugin) {
        this.builder = builder;
        this.signBlock = signBlock;
        this.scheduler = scheduler;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        WorkArea workArea = builder.build(signBlock);
        if (workArea.isValid()) {
            scheduler.runTaskAsynchronously(plugin, new MineableBlockFinder(workArea, scheduler, plugin));
        } else {
            scheduler.runTask(plugin, new WorkAreaSignUpdater(workArea));
        }
    }
}
