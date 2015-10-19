package org.lostmc.mctesting;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class MockBlock implements Block {
    private static MockBlock[][][] blockArray;
    private int x;
    private int y;
    private int z;
    private Material material;
    private int j;
    private int i;
    private int k;
    private BlockState state;
    private World world;

    public MockBlock(Material material) {
        this.material = material;
        this.state = new MockBlockState(this);
    }

    public static MockBlock[][][] createBlockArray(int width, int length, int height, int baseHeight) {
        int baseWidth = -(width / 2);
        int baseLength = -(length / 2);
        MockWorld world = new MockWorld();
        world.setMaxHeight(height);
        blockArray = new MockBlock[width][length][height];
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    MockBlock block = new MockBlock(Material.AIR);
                    block.setWorld(world);
                    block.x = baseWidth + i;
                    block.y = baseHeight + k;
                    block.z = baseLength + j;
                    block.i = i;
                    block.j = j;
                    block.k = k;
                    blockArray[i][j][k] = block;
                }
            }
        }
        return blockArray;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public Block getRelative(BlockFace face) {
        switch (face) {
            case NORTH:
                if (j == 0) throw new IllegalArgumentException("Accessing invalid block");
                return blockArray[i][j - 1][k];
            case NORTH_EAST:
                if (j == 0) throw new IllegalArgumentException("Accessing invalid block");
                return blockArray[i + 1][j - 1][k];
            case EAST:
                return blockArray[i + 1][j][k];
            case SOUTH:
            if (j == 1000) throw new IllegalArgumentException("Accessing invalid block");
            return blockArray[i][j + 1][k];
            case WEST:
            if (i == 0) throw new IllegalArgumentException("Accessing invalid block");
            return blockArray[i - 1][j][k];
            case UP:
                return blockArray[i][j][k+1];
            case DOWN:
                return blockArray[i][j][k-1];
            case SELF:
                return this;
            default:
                throw new IllegalArgumentException("Accessing invalid block");
        }
    }

    @Override
    public Material getType() {
        return material;
    }

    @Override
    public void setType(Material material) {
        this.material = material;
    }

    @Override
    public BlockState getState() {
        return state;
    }

    public void setState(BlockState state) {
        this.state = state;
    }

    @Override
    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public byte getData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Block getRelative(BlockFace face, int distance) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getTypeId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getLightLevel() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getLightFromSky() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getLightFromBlocks() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Location getLocation() {
        Location location = new Location(getWorld(), x, y, z);
        ((MockWorld)getWorld()).putBlockAt(location, this);
        return location;
    }

    @Override
    public Location getLocation(Location loc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk getChunk() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Block getRelative(int modX, int modY, int modZ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setData(byte data) {
        throw new UnsupportedOperationException();
    }


    @Override
    public void setData(byte data, boolean applyPhysics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setType(Material type, boolean applyPhysics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setTypeId(int type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setTypeId(int type, boolean applyPhysics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BlockFace getFace(Block block) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Biome getBiome() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setBiome(Biome bio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isBlockPowered() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockPower(BlockFace face) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockPower() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLiquid() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getTemperature() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getHumidity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean breakNaturally() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean breakNaturally(ItemStack tool) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<ItemStack> getDrops() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<ItemStack> getDrops(ItemStack tool) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new UnsupportedOperationException();
    }
}
