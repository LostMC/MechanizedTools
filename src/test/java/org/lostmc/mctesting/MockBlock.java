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
    private Material material;
    private BlockState state;
    private World world;
    private Location location;

    public MockBlock(Material material) {
        this.material = material;
        this.state = new MockBlockState(this);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + "): " + (material == null ? "" : material);
    }

    @Override
    public int getX() {
        return location.getBlockX();
    }

    @Override
    public int getY() {
        return location.getBlockY();
    }

    @Override
    public int getZ() {
        return location.getBlockZ();
    }

    @Override
    public Block getRelative(BlockFace face) {
        return getRelative(face, 1);
    }

    @Override
    public Block getRelative(BlockFace face, int distance) {
        int x = getX();
        int y = getY();
        int z = getZ();
        switch (face) {
            case NORTH:
                return world.getBlockAt(x, y, z - distance);
            case EAST:
                return world.getBlockAt(x + distance, y, z);
            case SOUTH:
                return world.getBlockAt(x, y, z + distance);
            case WEST:
                return world.getBlockAt(x - distance, y, z);
            case UP:
                return world.getBlockAt(x, y + distance, z);
            case DOWN:
                return world.getBlockAt(x, y - distance, z);
            case SELF:
                return this;
            default:
                throw new IllegalArgumentException("Invalid facing");
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

    public void setLocation(Location location) {
        this.location = location;
    }
}
