package org.lostmc.mechanizedtools;

import org.apache.commons.lang3.RandomStringUtils;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.Before;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockBukkitScheduler;
import org.lostmc.mctesting.MockPlayer;
import org.lostmc.mctesting.MockSign;
import org.lostmc.mechanizedtools.workarea.WorkAreaStarter;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class SignInteractionListenerTest {
    private final MockBukkitScheduler scheduler = new MockBukkitScheduler();
    private final JavaPlugin plugin = mock(JavaPlugin.class);
    private final MockPlayer player = new MockPlayer();

    private final SignInteractionListener listener = new SignInteractionListener(plugin, scheduler);

    @Before
    public void beforeEach() {
        scheduler.reset();
    }

    @Test
    public void clickLaunchesWorkAreaBuilder() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        MockSign sign = new MockSign(signBlock);
        signBlock.setState(sign);
        sign.setLine(0, "excavator");
        sign.update(true);

        PlayerInteractEvent event = new PlayerInteractEvent(player, Action.RIGHT_CLICK_BLOCK, null, signBlock, BlockFace.DOWN);
        listener.playerInteract(event);

        assertThat(scheduler.getPlugin(), sameInstance(plugin));
        assertThat(scheduler.getRunnable(), instanceOf(WorkAreaStarter.class));
        assertThat(scheduler.getMethod(), containsString("Asynchronously"));
    }

    @Test
    public void launchRegardlessOfCaseOfLabel() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        MockSign sign = new MockSign(signBlock);
        signBlock.setState(sign);
        sign.setLine(0, "exCavAtor");
        sign.update(true);

        PlayerInteractEvent event = new PlayerInteractEvent(player, Action.RIGHT_CLICK_BLOCK, null, signBlock, BlockFace.DOWN);
        listener.playerInteract(event);

        assertThat(scheduler.getPlugin(), sameInstance(plugin));
        assertThat(scheduler.getRunnable(), instanceOf(WorkAreaStarter.class));
        assertThat(scheduler.getMethod(), containsString("Asynchronously"));
    }

    @Test
    public void doNotLaunchIfNotRightClickBlock() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        MockSign sign = new MockSign(signBlock);
        signBlock.setState(sign);
        sign.setLine(0, "excavator");
        sign.update(true);

        for (Action action : Action.values()) {
            if (action == Action.RIGHT_CLICK_BLOCK) {
                continue;
            }
            PlayerInteractEvent event = new PlayerInteractEvent(player, action, null, signBlock, BlockFace.DOWN);
            listener.playerInteract(event);
            assertThat(scheduler.getPlugin(), nullValue());
            assertThat(scheduler.getRunnable(), nullValue());
            assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
        }
    }

    @Test
    public void doNotLaunchIfBlockIsNotWallSign() {
        MockBlock signBlock = new MockBlock(Material.SIGN);
        MockSign sign = new MockSign(signBlock);
        signBlock.setState(sign);
        sign.setLine(0, "excavator");
        sign.update(true);

        PlayerInteractEvent event = new PlayerInteractEvent(player, Action.RIGHT_CLICK_BLOCK, null, signBlock, BlockFace.DOWN);

        listener.playerInteract(event);

        assertThat(scheduler.getPlugin(), nullValue());
        assertThat(scheduler.getRunnable(), nullValue());
        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
    }

    @Test
    public void doNotLaunchWithoutProperLabel() {
        MockBlock signBlock = new MockBlock(Material.WALL_SIGN);
        MockSign sign = new MockSign(signBlock);
        signBlock.setState(sign);
        sign.setLine(0, RandomStringUtils.randomAlphabetic(13));
        sign.update(true);

        PlayerInteractEvent event = new PlayerInteractEvent(player, Action.RIGHT_CLICK_BLOCK, null, signBlock, BlockFace.DOWN);

        listener.playerInteract(event);

        assertThat(scheduler.getPlugin(), nullValue());
        assertThat(scheduler.getRunnable(), nullValue());
        assertThat(scheduler.getMethod(), not(containsString("Asynchronously")));
    }
}