package org.lostmc.mechanizedtools.workarea;

import org.apache.commons.lang3.RandomStringUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockSign;
import org.lostmc.mctesting.MockWorld;
import org.lostmc.mctesting.MockWorldBuilder;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class WorkAreaSignUpdaterTest {
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();

    @Test
    public void showThatWorkAreaIsInvalid() {
        MockBlock block = new MockBlock(Material.WALL_SIGN);
        WorkArea workArea = createWorkArea(block, false, "");
        WorkAreaSignUpdater updater = new WorkAreaSignUpdater(workArea);

        updater.run();

        MockSign state = (MockSign) block.getState();
        assertThat(state.getLine(2), containsString("Invalid:"));
    }

    @Test
    public void showReasonThatWorkAreaIsInvalid() {
        String reason = RandomStringUtils.randomAlphabetic(15);
        MockBlock block = new MockBlock(Material.WALL_SIGN);
        WorkArea workArea = createWorkArea(block, false, reason);
        WorkAreaSignUpdater updater = new WorkAreaSignUpdater(workArea);

        updater.run();

        MockSign state = (MockSign) block.getState();
        assertThat(state.getLine(3), containsString(reason));
    }

    private WorkArea createWorkArea(MockBlock block, boolean valid, String reason) {
        MockWorld world = new MockWorldBuilder().build();
        Location location = new Location(world, 0, 0, 0);
        world.putBlockAt(location, block);
        WorkArea workArea = new WorkArea();
        workArea.setSignBlockLocation(location);
        workArea.setValid(valid);
        workArea.setInvalidReason(reason);
        helper.createSignBlock(block, BlockFace.NORTH, new ArrayList<>());
        return workArea;
    }
}