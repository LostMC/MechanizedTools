package org.lostmc.mechanizedtools;

import org.bukkit.Material;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ToolFinderParameterizedTest {
    @Test
    public void validateBreakingTimeLookup() {
        assertThat("Material: " + material, finder.supports(material), equalTo(supports));
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {Material.DIRT, true},
                {Material.GRASS, true},
                {Material.GRAVEL, true},
                {Material.IRON_ORE, true},
                {Material.SAND, true},
                {Material.SANDSTONE, true},
                {Material.STONE, true}
        });
    }

    public ToolFinderParameterizedTest(Material material, boolean supports) {
        this.material = material;
        this.supports = supports;
    }

    private final Material material;
    private final boolean supports;
    private final ToolFinder finder = new ToolFinder();
}
