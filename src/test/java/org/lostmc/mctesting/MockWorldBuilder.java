package org.lostmc.mctesting;

import org.bukkit.Location;
import org.bukkit.Material;

public class MockWorldBuilder {
    private int height = 128;
    private int width = 26;
    private int length = 26;

    public MockWorld build() {
        MockWorld world = new MockWorld();
        MockBlock[][][] array = new MockBlock[width + 1][height][length + 1];
        int baseX = width / 2;
        int baseZ = length / 2;
        world.setArray(array, baseX, baseZ);
        world.setMaxHeight(height);
        for (int y = 0; y < height; y++) {
            for (int x = -baseX; x < baseX; x++) {
                for (int z = -baseZ; z < baseZ; z++) {
                    MockBlock block = new MockBlock(Material.AIR);
                    if (y < 64) {
                        block = new MockBlock(Material.DIRT);
                    }
                    block.setWorld(world);
                    block.setLocation(new Location(world, x, y, z));
                    array[baseX + x][y][baseZ + z] = block;
                }
            }
        }
        return world;
    }

    public MockWorldBuilder withSize(int size) {
        this.width = size;
        this.length = size;
        return this;
    }

    public MockWorldBuilder withHeight(int height) {
        this.height = height;
        return this;
    }
}
