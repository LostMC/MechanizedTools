package org.lostmc.mctesting;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class MockBlockState implements BlockState {
    private final Block block;
    private MaterialData data;

    public MockBlockState(Block block) {
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public Material getType() {
        return block.getType();
    }

    @Override
    public void setType(Material type) {
        this.block.setType(type);
    }

    @Override
    public int getX() {
        return block.getX();
    }

    @Override
    public int getY() {
        return block.getY();
    }

    @Override
    public int getZ() {
        return block.getZ();
    }

    @Override
    public void setData(MaterialData data) {
        this.data = data;
    }

    @Override
    public MaterialData getData() {
        return data;
    }

    @Override
    public byte getLightLevel() {
        throw new UnsupportedOperationException();
    }

    @Override
    public World getWorld() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Location getLocation() {
        throw new UnsupportedOperationException();
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
    public int getTypeId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setTypeId(int type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(boolean force) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getRawData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRawData(byte data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPlaced() {
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
