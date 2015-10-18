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
        return 0;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public Location getLocation(Location loc) {
        return null;
    }

    @Override
    public Chunk getChunk() {
        return null;
    }

    @Override
    public int getTypeId() {
        return 0;
    }

    @Override
    public boolean setTypeId(int type) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean update(boolean force) {
        return false;
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        return false;
    }

    @Override
    public byte getRawData() {
        return 0;
    }

    @Override
    public void setRawData(byte data) {

    }

    @Override
    public boolean isPlaced() {
        return false;
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {

    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return null;
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return false;
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {

    }
}
