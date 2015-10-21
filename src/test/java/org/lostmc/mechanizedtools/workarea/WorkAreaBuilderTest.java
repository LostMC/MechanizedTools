package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Location;
import org.bukkit.Material;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class WorkAreaBuilderTest {
    private final WorkAreaBuilder builder = new WorkAreaBuilder();
    private final WorkAreaTestHelper helper = new WorkAreaTestHelper();

    @Test
    public void validArea() {
        helper.createValidArea();
        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getInvalidReason(), workArea.isValid(), equalTo(true));
    }

    @Test
    public void signLocationSet() {
        helper.createValidArea();
        WorkArea workArea = builder.build(helper.getSignBlock());

        Location location = workArea.getSignBlockLocation();

        assertThat(location, notNullValue());
        assertThat(location.getBlockX(), equalTo(-2));
        assertThat(location.getBlockY(), equalTo(64));
        assertThat(location.getBlockZ(), equalTo(-8));
    }

    @Test
    public void supplyChestLocationSet() {
        helper.createValidArea();
        WorkArea workArea = builder.build(helper.getSignBlock());

        Location location = workArea.getSupplyChestLocation();

        assertThat(location, notNullValue());
        assertThat(location.getBlockX(), equalTo(-2));
        assertThat(location.getBlockY(), equalTo(65));
        assertThat(location.getBlockZ(), equalTo(-7));
    }

    @Test
    public void setXZMinimums() {
        helper.createValidArea();
        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMinimumX(), equalTo(-8L));
        assertThat(workArea.getMinimumZ(), equalTo(-9L));
    }

    @Test
    public void setXZMaximums() {
        helper.createValidArea();
        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMaximumX(), equalTo(1L));
        assertThat(workArea.getMaximumZ(), equalTo(0L));
    }

    @Test
    public void setXZMinimumsWhenPositive() {
        helper.createValidArea(19, 15, 25);
        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMinimumX(), equalTo(1L));
        assertThat(workArea.getMinimumZ(), equalTo(2L));
    }

    @Test
    public void setXZMaximumsWhenPositive() {
        helper.createValidArea(19, 15, 25);
        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMaximumX(), equalTo(10L));
        assertThat(workArea.getMaximumZ(), equalTo(11L));
    }

    @Test
    public void whenSignIsNotAttachedToAnIronBlock() {
        helper.createValidArea();
        helper.getEngineBlock().setType(Material.COBBLESTONE);

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Engine missing"));
    }

    @Test
    public void whenSupplyChestIsNotAboveEngineBlock() {
        helper.createValidArea();
        helper.getSupplyChest().setType(Material.AIR);

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Chest missing"));

    }

    @Test
    public void setMinimumY() {
        helper.createValidArea();

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMinimumY(), equalTo(56));
    }

    @Test
    public void setMinimumYViaRange() {
        helper.createValidArea("Excavator", "60-65");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMinimumY(), equalTo(60));
    }

    @Test
    public void setMaximumYViaRange() {
        helper.createValidArea("Excavator", "60-65");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMaximumY(), equalTo(65));
    }

    @Test
    public void invalidRangeByOrder() {
        helper.createValidArea("Excavator", "65-60");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Depth too high"));
    }

    @Test
    public void invalidMinimumYByHeight() {
        helper.createValidArea("Excavator", "129");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Depth too high"));
    }

    @Test
    public void invalidMinimumYByContent() {
        helper.createValidArea("Excavator", "aa");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid depth"));
    }

    @Test
    public void invalidMinimumYInRangeByContent() {
        helper.createValidArea("Excavator", "aa-60");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid depth"));
    }

    @Test
    public void invalidMaximumYInRangeByContent() {
        helper.createValidArea("Excavator", "60-aa");

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.isValid(), equalTo(false));
        assertThat(workArea.getInvalidReason(), equalTo("Invalid height"));

    }

    @Test
    public void setMaximumY() {
        helper.createValidArea();

        WorkArea workArea = builder.build(helper.getSignBlock());

        assertThat(workArea.getMaximumY(), equalTo(128));
    }
}