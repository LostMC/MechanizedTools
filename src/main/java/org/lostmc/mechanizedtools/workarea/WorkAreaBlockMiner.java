package org.lostmc.mechanizedtools.workarea;

import org.bukkit.block.Block;

public class WorkAreaBlockMiner implements Runnable {
    private final Block blockToMine;

    public WorkAreaBlockMiner(Block blockToMine) {
        this.blockToMine = blockToMine;
    }

    @Override
    public void run() {

    }

    Block getBlockToMine() {
        return blockToMine;
    }
}
