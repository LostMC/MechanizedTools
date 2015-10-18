package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;

public class WorkArea {
    private boolean valid = true;
    private Location signBlockLocation;
    private Location supplyChestLocation;
    private long minimumX = Long.MAX_VALUE;
    private long minimumZ = Long.MAX_VALUE;
    private long maximumX = Long.MIN_VALUE;
    private long maximumZ = Long.MIN_VALUE;
    private int minimumY;
    private int maximumY;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setSupplyChestLocation(Location supplyChestLocation) {
        this.supplyChestLocation = supplyChestLocation;
    }

    public Location getSupplyChestLocation() {
        return supplyChestLocation;
    }

    public void setSignBlockLocation(Location signBlockLocation) {
        this.signBlockLocation = signBlockLocation;
    }

    public Location getSignBlockLocation() {
        return signBlockLocation;
    }

    public long getMinimumX() {
        return minimumX;
    }

    public void setMinimumX(long minimumX) {
        this.minimumX = minimumX;
    }

    public long getMinimumZ() {
        return minimumZ;
    }

    public void setMinimumZ(long minimumZ) {
        this.minimumZ = minimumZ;
    }

    public long getMaximumX() {
        return maximumX;
    }

    public void setMaximumX(long maximumX) {
        this.maximumX = maximumX;
    }

    public long getMaximumZ() {
        return maximumZ;
    }

    public void setMaximumZ(long maximumZ) {
        this.maximumZ = maximumZ;
    }

    public int getMinimumY() {
        return minimumY;
    }

    public void setMinimumY(int minimumY) {
        this.minimumY = minimumY;
    }

    public int getMaximumY() {
        return maximumY;
    }

    public void setMaximumY(int maximumY) {
        this.maximumY = maximumY;
    }
}
