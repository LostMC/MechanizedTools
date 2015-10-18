package org.lostmc.mechanizedtools.workarea;

import org.bukkit.block.Block;

public class WorkAreaStarter implements Runnable {
    private final WorkAreaBuilder builder;
    private final Block signBlock;

    public WorkAreaStarter(WorkAreaBuilder builder, Block signBlock) {
        this.builder = builder;
        this.signBlock = signBlock;
    }

    @Override
    public void run() {
        WorkArea workArea = builder.build(signBlock);
    }
}
