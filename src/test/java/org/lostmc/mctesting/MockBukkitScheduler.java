package org.lostmc.mctesting;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class MockBukkitScheduler implements BukkitScheduler {
    private Plugin plugin;
    private Runnable runnable;
    private long delay = -1;
    private String method;

    public void reset() {
        this.plugin = null;
        this.runnable = null;
        this.delay = -1;
        this.method = null;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getDelay() {
        return delay;
    }

    public String getMethod() {
        return method;
    }

    private void capture(Plugin plugin, Runnable runnable, long delay, String method) {
        this.delay = delay;
        this.runnable = runnable;
        this.plugin = plugin;
        this.method = method;
    }

    private void capture(Plugin plugin, Runnable runnable, String method) {
        this.delay = 0;
        this.runnable = runnable;
        this.plugin = plugin;
        this.method = method;
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        capture(plugin, task, delay, "scheduleSyncDelayedTask");
        return 0;
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return 0;
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return 0;
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return 0;
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return 0;
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return 0;
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return 0;
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return 0;
    }

    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return 0;
    }

    @Override
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        return null;
    }

    @Override
    public void cancelTask(int taskId) {

    }

    @Override
    public void cancelTasks(Plugin plugin) {

    }

    @Override
    public void cancelAllTasks() {

    }

    @Override
    public boolean isCurrentlyRunning(int taskId) {
        return false;
    }

    @Override
    public boolean isQueued(int taskId) {
        return false;
    }

    @Override
    public List<BukkitWorker> getActiveWorkers() {
        return null;
    }

    @Override
    public List<BukkitTask> getPendingTasks() {
        return null;
    }

    @Override
    public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
        capture(plugin, task, "runTaskAsynchronously");
        return null;
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
        return null;
    }
}
