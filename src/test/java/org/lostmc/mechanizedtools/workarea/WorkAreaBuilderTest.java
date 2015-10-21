package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class WorkAreaBuilderTest {
    private final WorkAreaBuilder builder = new WorkAreaBuilder();
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();
    private MockBlock signBlock;
    private MockBlock engineBlock;
    private MockBlock supplyChest;

    @Test
    public void validArea() {
        insertValidAreaIntoArray();
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getInvalidReason(), workArea.isValid(), equalTo(true));
    }

    @Test
    public void signLocationSet() {
        insertValidAreaIntoArray();
        WorkArea workArea = builder.build(signBlock);

        Location location = workArea.getSignBlockLocation();

        assertThat(location, notNullValue());
        assertThat(location.getBlockX(), equalTo(-2));
        assertThat(location.getBlockY(), equalTo(64));
        assertThat(location.getBlockZ(), equalTo(-8));
    }

    @Test
    public void supplyChestLocationSet() {
        insertValidAreaIntoArray();
        WorkArea workArea = builder.build(signBlock);

        Location location = workArea.getSupplyChestLocation();

        assertThat(location, notNullValue());
        assertThat(location.getBlockX(), equalTo(-2));
        assertThat(location.getBlockY(), equalTo(65));
        assertThat(location.getBlockZ(), equalTo(-7));
    }

    @Test
    public void setXZMinimums() {
        insertValidAreaIntoArray();
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumX(), equalTo(-8L));
        assertThat(workArea.getMinimumZ(), equalTo(-9L));
    }

    @Test
    public void setXZMaximums() {
        insertValidAreaIntoArray();
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumX(), equalTo(1L));
        assertThat(workArea.getMaximumZ(), equalTo(0L));
    }

    @Test
    public void setXZMinimumsWhenPositive() {
        insertValidAreaIntoArray(19, 15, 25);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumX(), equalTo(1L));
        assertThat(workArea.getMinimumZ(), equalTo(2L));
    }

    @Test
    public void setXZMaximumsWhenPositive() {
        insertValidAreaIntoArray(19, 15, 25);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumX(), equalTo(10L));
        assertThat(workArea.getMaximumZ(), equalTo(11L));
    }

    @Test
    public void whenSignIsNotAttachedToAnIronBlock() {
        insertValidAreaIntoArray();
        engineBlock.setType(Material.COBBLESTONE);

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Engine missing"));
    }

    @Test
    public void whenSupplyChestIsNotAboveEngineBlock() {
        insertValidAreaIntoArray();
        supplyChest.setType(Material.AIR);

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Chest missing"));

    }

    @Test
    public void setMinimumY() {
        insertValidAreaIntoArray();

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumY(), equalTo(56));
    }

    @Test
    public void setMinimumYViaRange() {
        insertValidAreaIntoArray("Excavator", "60-65");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumY(), equalTo(60));
    }

    @Test
    public void setMaximumYViaRange() {
        insertValidAreaIntoArray("Excavator", "60-65");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumY(), equalTo(65));
    }

    @Test
    public void invalidRangeByOrder() {
        insertValidAreaIntoArray("Excavator", "65-60");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Depth too high"));
    }

    @Test
    public void invalidMinimumYByHeight() {
        insertValidAreaIntoArray("Excavator", "129");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Depth too high"));
    }

    @Test
    public void invalidMinimumYByContent() {
        insertValidAreaIntoArray("Excavator", "aa");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid depth"));
    }

    @Test
    public void invalidMinimumYInRangeByContent() {
        insertValidAreaIntoArray("Excavator", "aa-60");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid depth"));
    }

    @Test
    public void invalidMaximumYInRangeByContent() {
        insertValidAreaIntoArray("Excavator", "60-aa");

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid height"));

    }

    @Test
    public void setMaximumY() {
        insertValidAreaIntoArray();

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumY(), equalTo(128));
    }

    private void insertValidAreaIntoArray() {
        insertValidAreaIntoArray("Excavator", "56");
    }

    private void insertValidAreaIntoArray(int i, int j, int size) {
        insertValidAreaIntoArray(i, j, size, "Excavator", "56");
    }

    private void insertValidAreaIntoArray(String... lines) {
        insertValidAreaIntoArray(8, 2, 20, lines);
    }

    private void insertValidAreaIntoArray(int i, int j, int size, String... lines) {
        MockBlock[][][] array = MockBlock.createBlockArray(size, size);
        signBlock = array[i][j][64];
        engineBlock = (MockBlock) signBlock.getRelative(BlockFace.SOUTH);
        supplyChest = (MockBlock) engineBlock.getRelative(BlockFace.UP);
        helper.createValidArea(signBlock, engineBlock, supplyChest, BlockFace.NORTH, Arrays.asList(lines));
    }
}