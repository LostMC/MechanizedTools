package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;

public class WorkArea {
    private boolean valid = true;
    private Location signBlockLocation;
    private Location supplyChestLocation;
    private int minimumX = Integer.MAX_VALUE;
    private int minimumZ = Integer.MAX_VALUE;
    private int maximumX = Integer.MIN_VALUE;
    private int maximumZ = Integer.MIN_VALUE;
    private int minimumY;
    private int maximumY;
    private String invalidReason;

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

    public int getMinimumX() {
        return minimumX;
    }

    public void setMinimumX(int minimumX) {
        this.minimumX = minimumX;
    }

    public int getMinimumZ() {
        return minimumZ;
    }

    public void setMinimumZ(int minimumZ) {
        this.minimumZ = minimumZ;
    }

    public int getMaximumX() {
        return maximumX;
    }

    public void setMaximumX(int maximumX) {
        this.maximumX = maximumX;
    }

    public int getMaximumZ() {
        return maximumZ;
    }

    public void setMaximumZ(int maximumZ) {
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

    public void setInvalidReason(String invalidReason) {
        this.invalidReason = invalidReason;
    }

    public String getInvalidReason() {
        return invalidReason;
    }
}
