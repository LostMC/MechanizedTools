package org.lostmc.mechanizedtools;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.lostmc.mechanizedtools.workarea.WorkAreaBuilder;
import org.lostmc.mechanizedtools.workarea.WorkAreaStarter;

public class SignInteractionListener implements Listener {
    private static final String SIGN_LABEL_EXCAVATOR = "excavator";
    private final Plugin plugin;
    private final BukkitScheduler scheduler;

    public SignInteractionListener(Plugin plugin, BukkitScheduler scheduler) {
        this.plugin = plugin;
        this.scheduler = scheduler;
    }

    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        BlockState state = block.getState();
        if (isRightHandClick(event) && wallSignWasClicked(state) && wallSignProperlyLabeled(state)) {
            WorkAreaStarter starter = new WorkAreaStarter(new WorkAreaBuilder(), block, scheduler, plugin);
            scheduler.runTaskAsynchronously(plugin, starter);
        }
    }

    private boolean isRightHandClick(PlayerInteractEvent event) {
        return event.getAction() == Action.RIGHT_CLICK_BLOCK;
    }

    private boolean wallSignWasClicked(BlockState state) {
        return state.getType() == Material.WALL_SIGN;
    }

    private boolean wallSignProperlyLabeled(BlockState state) {
        return SIGN_LABEL_EXCAVATOR.equalsIgnoreCase(((Sign) state).getLine(0));
    }
}
