package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.Test;
import org.lostmc.mctesting.MockBlock;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class WorkAreaBuilderTest {
    private static final Material ENGINE_BLOCK_MATERIAL = Material.IRON_BLOCK;
    private final WorkAreaBuilder builder = new WorkAreaBuilder();
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();
    private MockBlock signBlock;
    private MockBlock engineBlock;
    private MockBlock supplyChest;

    @Test
    public void validArea() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 128, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(true));
    }

    @Test
    public void signLocationSet() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        WorkArea workArea = builder.build(signBlock);

        Location location = workArea.getSignBlockLocation();

        assertThat(location, notNullValue());
        assertThat(location.getBlockX(), equalTo(-4));
        assertThat(location.getBlockY(), equalTo(63));
        assertThat(location.getBlockZ(), equalTo(-6));
    }

    @Test
    public void supplyChestLocationSet() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        WorkArea workArea = builder.build(signBlock);

        Location location = workArea.getSupplyChestLocation();

        assertThat(location, notNullValue());
        assertThat(location.getBlockX(), equalTo(-4));
        assertThat(location.getBlockY(), equalTo(64));
        assertThat(location.getBlockZ(), equalTo(-5));
    }

    @Test
    public void setXZMinimums() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumX(), equalTo(-5L));
        assertThat(workArea.getMinimumZ(), equalTo(-5L));
    }

    @Test
    public void setXZMaximums() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumX(), equalTo(-3L));
        assertThat(workArea.getMaximumZ(), equalTo(-3L));
    }

    @Test
    public void setXZMinimumsWhenPositive() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 9, 7, 0);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumX(), equalTo(1L));
        assertThat(workArea.getMinimumZ(), equalTo(1L));
    }

    @Test
    public void setXZMaximumsWhenPositive() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 7, 7, 0);
        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumX(), equalTo(1L));
        assertThat(workArea.getMaximumZ(), equalTo(3L));
    }

    @Test
    public void whenSignIsNotAttachedToAnIronBlock() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        engineBlock.setType(Material.COBBLESTONE);

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Engine missing"));
    }

    @Test
    public void whenSupplyChestIsNotAboveEngineBlock() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);
        supplyChest.setType(Material.AIR);

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Chest missing"));

    }

    @Test
    public void setMinimumY() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumY(), equalTo(56));
    }

    @Test
    public void setMinimumYViaRange() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "60-65"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMinimumY(), equalTo(60));
    }

    @Test
    public void setMaximumYViaRange() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "60-65"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumY(), equalTo(65));
    }

    @Test
    public void invalidRangeByOrder() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "65-60"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Depth too high"));
    }

    @Test
    public void invalidMinimumYByHeight() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 128, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "129"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Depth too high"));
    }

    @Test
    public void invalidMinimumYByContent() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "aa"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid depth"));
    }

    @Test
    public void invalidMinimumYInRangeByContent() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "aa-60"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid depth"));
    }

    @Test
    public void invalidMaximumYInRangeByContent() {
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, 2, 63);
        insertValidAreaIntoArray(array, 3, 1, 0, Arrays.asList("Excavator", "60-aa"));

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid height"));

    }

    @Test
    public void setMaximumY() {
        int height = new Random().nextInt(128) + 128;
        MockBlock[][][] array = MockBlock.createBlockArray(15, 15, height, 63);
        insertValidAreaIntoArray(array, 3, 1, 0);

        WorkArea workArea = builder.build(signBlock);

        assertThat(workArea.getMaximumY(), equalTo(height));
    }

    private void insertValidAreaIntoArray(MockBlock[][][] array, int signI, int signJ, int signK) {
        insertValidAreaIntoArray(array, signI, signJ, signK, Arrays.asList("Excavator", "56"));
    }

    private void insertValidAreaIntoArray(MockBlock[][][] array, int signI, int signJ, int signK, List<String> signLines) {
        createSign(array, signI, signJ, signK, signLines);
        createEngineBlock();
        createSupplyChest();
        addRedstone();

    }

    private void addRedstone() {
        MockBlock rt = (MockBlock) engineBlock.getRelative(BlockFace.WEST);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.SOUTH);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.SOUTH);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.EAST);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.EAST);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.NORTH);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.NORTH);
        rt.setType(Material.REDSTONE_WIRE);
    }

    private void createSign(MockBlock[][][] array, int signI, int signJ, int signK, List<String> signLines) {
        signBlock = array[signI][signJ][signK];
        helper.createSignBlock(signBlock, BlockFace.NORTH, signLines);
    }

    private void createEngineBlock() {
        engineBlock = (MockBlock) signBlock.getRelative(BlockFace.SOUTH);
        engineBlock.setType(ENGINE_BLOCK_MATERIAL);
    }

    private void createSupplyChest() {
        supplyChest = (MockBlock) engineBlock.getRelative(BlockFace.UP);
        supplyChest.setType(Material.CHEST);
    }

}