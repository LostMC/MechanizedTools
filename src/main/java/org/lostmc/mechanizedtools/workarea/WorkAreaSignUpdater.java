package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class WorkAreaSignUpdater implements Runnable {
    private final WorkArea workArea;

    public WorkAreaSignUpdater(WorkArea workArea) {
        this.workArea = workArea;
    }

    @Override
    public void run() {
        Location location = workArea.getSignBlockLocation();
        Block block = location.getWorld().getBlockAt(location);
        Sign sign = (Sign)block.getState();
        sign.setLine(2, "Invalid:");
        sign.setLine(3, workArea.getInvalidReason());
        sign.update(true);
    }
}
