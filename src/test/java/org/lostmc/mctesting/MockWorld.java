package org.lostmc.mctesting;

import org.bukkit.BlockChangeDelegate;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MockWorld implements World {
    private int maxHeight;

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public Block getBlockAt(int x, int y, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Block getBlockAt(Location location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockTypeIdAt(int x, int y, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockTypeIdAt(Location location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getHighestBlockYAt(Location location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Block getHighestBlockAt(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Block getHighestBlockAt(Location location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk getChunkAt(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk getChunkAt(Location location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk getChunkAt(Block block) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isChunkLoaded(Chunk chunk) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk[] getLoadedChunks() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadChunk(Chunk chunk) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isChunkInUse(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadChunk(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean loadChunk(int x, int z, boolean generate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadChunk(Chunk chunk) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadChunk(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadChunk(int x, int z, boolean save) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadChunkRequest(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadChunkRequest(int x, int z, boolean safe) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean regenerateChunk(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean refreshChunk(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Item dropItem(Location location, ItemStack item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Item dropItemNaturally(Location location, ItemStack item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Arrow spawnArrow(Location location, Vector direction, float speed, float spread) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean generateTree(Location location, TreeType type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Entity spawnEntity(Location loc, EntityType type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LivingEntity spawnCreature(Location loc, EntityType type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LivingEntity spawnCreature(Location loc, @SuppressWarnings("deprecation") CreatureType type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LightningStrike strikeLightning(Location loc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LightningStrike strikeLightningEffect(Location loc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Entity> getEntities() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<LivingEntity> getLivingEntities() {
        throw new UnsupportedOperationException();
    }

    @SafeVarargs
    @Override
    public final <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Player> getPlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Entity> getNearbyEntities(Location location, double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public UUID getUID() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Location getSpawnLocation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setSpawnLocation(int x, int y, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTime(long time) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getFullTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFullTime(long time) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasStorm() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setStorm(boolean hasStorm) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWeatherDuration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWeatherDuration(int duration) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isThundering() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setThundering(boolean thundering) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getThunderDuration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setThunderDuration(int duration) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createExplosion(Location loc, float power) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createExplosion(Location loc, float power, boolean setFire) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Environment getEnvironment() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getSeed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getPVP() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPVP(boolean pvp) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChunkGenerator getGenerator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BlockPopulator> getPopulators() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void playEffect(Location location, Effect effect, int data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void playEffect(Location location, Effect effect, int data, int radius) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data, int radius) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getAllowAnimals() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getAllowMonsters() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Biome getBiome(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setBiome(int x, int z, Biome bio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getTemperature(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getHumidity(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSeaLevel() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setKeepSpawnInMemory(boolean keepLoaded) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAutoSave() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setAutoSave(boolean value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Difficulty getDifficulty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getWorldFolder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public WorldType getWorldType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canGenerateStructures() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMonsterSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMonsterSpawnLimit(int limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAnimalSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setAnimalSpawnLimit(int limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWaterAnimalSpawnLimit(int limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAmbientSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setAmbientSpawnLimit(int limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String[] getGameRules() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getGameRuleValue(String rule) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setGameRuleValue(String rule, String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isGameRule(String rule) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WorldBorder getWorldBorder() {
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

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        throw new UnsupportedOperationException();
    }
}
