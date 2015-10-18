package org.lostmc.mctesting;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.BanList;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class MockServer implements Server {
    List<Recipe> recipes = new ArrayList<>();
    private PluginManager pluginManager;

    @Override
    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public void setPluginManager(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return true;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getBukkitVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Player[] _INVALID_getOnlinePlayers() {
        return new Player[0];
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMaxPlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPort() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getViewDistance() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getIp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getServerName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getServerId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getWorldType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getGenerateStructures() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getAllowEnd() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getAllowNether() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasWhitelist() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWhitelist(boolean value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reloadWhitelist() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int broadcastMessage(String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getUpdateFolder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getUpdateFolderFile() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getConnectionThrottle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Player getPlayer(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Player getPlayerExact(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Player> matchPlayer(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Player getPlayer(UUID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BukkitScheduler getScheduler() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ServicesManager getServicesManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<World> getWorlds() {
        throw new UnsupportedOperationException();
    }

    @Override
    public World createWorld(WorldCreator creator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadWorld(String name, boolean save) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean unloadWorld(World world, boolean save) {
        throw new UnsupportedOperationException();
    }

    @Override
    public World getWorld(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public World getWorld(UUID uid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapView getMap(short id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapView createMap(World world) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reload() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Logger getLogger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public PluginCommand getPluginCommand(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void savePlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void configureDbConfig(ServerConfig config) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Recipe> getRecipesFor(ItemStack result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Recipe> recipeIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearRecipes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void resetRecipes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, String[]> getCommandAliases() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSpawnRadius() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSpawnRadius(int value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getOnlineMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getAllowFlight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isHardcore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean useExactLoginLocation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int broadcast(String message, String permission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public OfflinePlayer getOfflinePlayer(UUID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> getIPBans() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void banIP(String address) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unbanIP(String address) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public BanList getBanList(BanList.Type type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameMode getDefaultGameMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDefaultGameMode(GameMode mode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getWorldContainer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public OfflinePlayer[] getOfflinePlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Messenger getMessenger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public HelpMap getHelpMap() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMonsterSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAnimalSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAmbientSpawnLimit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPrimaryThread() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getMotd() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getShutdownMessage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Warning.WarningState getWarningState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ItemFactory getItemFactory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CachedServerIcon getServerIcon() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CachedServerIcon loadServerIcon(File file) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public CachedServerIcon loadServerIcon(BufferedImage image) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setIdleTimeout(int threshold) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getIdleTimeout() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChunkGenerator.ChunkData createChunkData(World world) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("deprecation")
    @Override
    public UnsafeValues getUnsafe() {
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
