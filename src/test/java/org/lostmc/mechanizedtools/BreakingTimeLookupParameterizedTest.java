package org.lostmc.mechanizedtools;

import org.bukkit.Material;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BreakingTimeLookupParameterizedTest {
    @Test
    public void validateBreakingTimeLookup() {
        assertThat("Material: " + material + " and Method: " + method,
                lookup.supports(material, method), equalTo(supports));
        assertThat("Material: " + material + " and Method: " + method,
                lookup.getBreakingTimeFor(material, method), equalTo(delay));
    }

    @Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {
                {Material.GRAVEL,      BreakingMethod.HAND,    true, (long)(0.90 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.WOOD,    true, (long)(0.45 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.STONE,   true, (long)(0.25 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.IRON,    true, (long)(0.15 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.DIAMOND, true, (long)(0.15 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.GOLD,    true, (long)(0.10 * TICKS_PER_SECOND)},

                {Material.SAND,        BreakingMethod.HAND,    true, (long)(0.75 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.WOOD,    true, (long)(0.40 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.STONE,   true, (long)(0.20 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.IRON,    true, (long)(0.15 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.DIAMOND, true, (long)(0.10 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.GOLD,    true, (long)(0.10 * TICKS_PER_SECOND)},

                {Material.DIRT,        BreakingMethod.HAND,    true, (long)(0.75 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.WOOD,    true, (long)(0.40 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.STONE,   true, (long)(0.20 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.IRON,    true, (long)(0.15 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.DIAMOND, true, (long)(0.10 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.GOLD,    true, (long)(0.10 * TICKS_PER_SECOND)},

                {Material.GRASS,       BreakingMethod.HAND,    true, (long)(0.75 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.WOOD,    true, (long)(0.40 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.STONE,   true, (long)(0.20 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.IRON,    true, (long)(0.15 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.DIAMOND, true, (long)(0.10 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.GOLD,    true, (long)(0.10 * TICKS_PER_SECOND)},

                {Material.SANDSTONE,   BreakingMethod.WOOD,    true, (long)(0.65 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.STONE,   true, (long)(0.35 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.IRON,    true, (long)(0.20 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.DIAMOND, true, (long)(0.20 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.GOLD,    true, (long)(0.10 * TICKS_PER_SECOND)},

                {Material.STONE,       BreakingMethod.WOOD,    true, (long)(1.15 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.STONE,   true, (long)(0.60 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.IRON,    true, (long)(0.40 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.DIAMOND, true, (long)(0.30 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.GOLD,    true, (long)(0.20 * TICKS_PER_SECOND)},

                {Material.IRON_ORE,    BreakingMethod.STONE,   true, (long)(1.15 * TICKS_PER_SECOND)},
                {Material.IRON_ORE,    BreakingMethod.IRON,    true, (long)(0.75 * TICKS_PER_SECOND)},
                {Material.IRON_ORE,    BreakingMethod.DIAMOND, true, (long)(0.60 * TICKS_PER_SECOND)},
        });
    }

    public BreakingTimeLookupParameterizedTest(Material material, BreakingMethod method, boolean supports, long delay) {
        this.material = material;
        this.method = method;
        this.delay = delay;
        this.supports = supports;
    }

    private final BreakingTimeLookup lookup = new BreakingTimeLookup();

    private final Material material;
    private final BreakingMethod method;
    private final long delay;
    private static final long TICKS_PER_SECOND = 20;
    private final boolean supports;
}
