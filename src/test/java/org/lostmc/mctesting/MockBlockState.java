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
    private Material material;
    private MaterialData data;

    public MockBlockState(Block block) {
        this.block = block;
        this.material = block.getType();
    }

    @Override
    public boolean update() {
        return update(true);
    }

    @Override
    public boolean update(boolean force) {
        return update(force, true);
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        ((MockBlock)block).setMaterial(material);
        return true;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public Material getType() {
        return material;
    }

    @Override
    public void setType(Material type) {
        this.material = type;
    }

    public void setMaterial(Material material) {
        this.material = material;
        update();
    }

    @Override
    public World getWorld() {
        return block.getWorld();
    }

    @Override
    public Location getLocation() {
        return block.getLocation();
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
