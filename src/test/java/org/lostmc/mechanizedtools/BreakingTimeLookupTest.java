package org.lostmc.mechanizedtools;

import org.bukkit.Material;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BreakingTimeLookupTest {
    private final BreakingTimeLookup lookup = new BreakingTimeLookup();
    private final int TICKS_PER_SECOND = 20;

    @Test
    public void returnTrueForSupportedMaterial() {
        assertThat(lookup.supports(Material.GRAVEL, BreakingMethod.HAND), equalTo(true));
    }

    @Test
    public void returnFalseForUnsupportedMaterial() {
        assertThat(lookup.supports(Material.AIR, BreakingMethod.HAND), equalTo(false));
    }

    @Test
    public void returnFalseForUnsupportedMethodOnSupportedMaterial() {
        assertThat(lookup.supports(Material.SANDSTONE, BreakingMethod.HAND), equalTo(false));
    }
}