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
    private static final long TICKS_PER_SECOND = 20;

    @Test
    public void validateBreakingTimeLookup() {
        assertThat("Material: " + material + " and Method: " + method,
                lookup.supports(material, method), equalTo(true));
        assertThat("Material: " + material + " and Method: " + method,
                lookup.getBreakingTimeFor(material, method), equalTo(expected));
    }

    @Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {
                {Material.GRAVEL,      BreakingMethod.HAND,    (long)(0.90 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.WOOD,    (long)(0.45 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.STONE,   (long)(0.25 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.IRON,    (long)(0.15 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.DIAMOND, (long)(0.15 * TICKS_PER_SECOND)},
                {Material.GRAVEL,      BreakingMethod.GOLD,    (long)(0.10 * TICKS_PER_SECOND)},

                {Material.SAND,        BreakingMethod.HAND,    (long)(0.75 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.WOOD,    (long)(0.40 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.STONE,   (long)(0.20 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.IRON,    (long)(0.15 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.DIAMOND, (long)(0.10 * TICKS_PER_SECOND)},
                {Material.SAND,        BreakingMethod.GOLD,    (long)(0.10 * TICKS_PER_SECOND)},

                {Material.DIRT,        BreakingMethod.HAND,    (long)(0.75 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.WOOD,    (long)(0.40 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.STONE,   (long)(0.20 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.IRON,    (long)(0.15 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.DIAMOND, (long)(0.10 * TICKS_PER_SECOND)},
                {Material.DIRT,        BreakingMethod.GOLD,    (long)(0.10 * TICKS_PER_SECOND)},

                {Material.GRASS,       BreakingMethod.HAND,    (long)(0.75 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.WOOD,    (long)(0.40 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.STONE,   (long)(0.20 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.IRON,    (long)(0.15 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.DIAMOND, (long)(0.10 * TICKS_PER_SECOND)},
                {Material.GRASS,       BreakingMethod.GOLD,    (long)(0.10 * TICKS_PER_SECOND)},

                {Material.SANDSTONE,   BreakingMethod.WOOD,    (long)(0.65 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.STONE,   (long)(0.35 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.IRON,    (long)(0.20 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.DIAMOND, (long)(0.20 * TICKS_PER_SECOND)},
                {Material.SANDSTONE,   BreakingMethod.GOLD,    (long)(0.10 * TICKS_PER_SECOND)},

                {Material.STONE,       BreakingMethod.WOOD,    (long)(1.15 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.STONE,   (long)(0.60 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.IRON,    (long)(0.40 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.DIAMOND, (long)(0.30 * TICKS_PER_SECOND)},
                {Material.STONE,       BreakingMethod.GOLD,    (long)(0.20 * TICKS_PER_SECOND)},

                {Material.IRON_ORE,    BreakingMethod.STONE,   (long)(1.15 * TICKS_PER_SECOND)},
                {Material.IRON_ORE,    BreakingMethod.IRON,    (long)(0.75 * TICKS_PER_SECOND)},
                {Material.IRON_ORE,    BreakingMethod.DIAMOND, (long)(0.60 * TICKS_PER_SECOND)},
        });
    }

    public BreakingTimeLookupParameterizedTest(Material material, BreakingMethod method, long expected) {
        this.material = material;
        this.method = method;
        this.expected = expected;
    }

    private final BreakingTimeLookup lookup = new BreakingTimeLookup();
    private final Material material;
    private final BreakingMethod method;
    private final long expected;
}
