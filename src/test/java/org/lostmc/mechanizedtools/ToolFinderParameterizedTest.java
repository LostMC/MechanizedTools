package org.lostmc.mechanizedtools;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.lostmc.mctesting.MockInventory;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ToolFinderParameterizedTest {
    @Test
    public void validateToolFinder() {
        Inventory inventory = new MockInventory();
        if (toolMaterial != null) {
            ItemStack stack = new ItemStack(toolMaterial);
            inventory.addItem(stack);
        }
        assertThat("Material: " + material, finder.supports(material), equalTo(supports));
        ItemStack tool = finder.findToolFor(material, inventory);
        if (returnMaterial == null) {
            assertThat("Material: " + material + "tool: " + toolMaterial + "return: " + returnMaterial,
                    tool, equalTo(returnMaterial));

        } else {
            assertThat(tool, notNullValue());
            assertThat("Material: " + material + "tool: " + toolMaterial + "return: " + returnMaterial,
                    tool.getType(), equalTo(returnMaterial));
        }
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {Material.AIR,       false, null,                   null},
                {Material.DIRT,      true,  null,                   Material.AIR},
                {Material.GRASS,     true,  null,                   Material.AIR},
                {Material.GRAVEL,    true,  null,                   Material.AIR},
                {Material.IRON_ORE,  true,  Material.STONE_PICKAXE, Material.STONE_PICKAXE},
                {Material.SAND,      true,  null,                   Material.AIR},
                {Material.SANDSTONE, true,  Material.WOOD_PICKAXE,  Material.WOOD_PICKAXE},
                {Material.STONE,     true,  Material.WOOD_PICKAXE,  Material.WOOD_PICKAXE}
        });
    }

    public ToolFinderParameterizedTest(Material material, boolean supports, Material toolMaterial, Material returnMaterial) {
        this.material = material;
        this.toolMaterial = toolMaterial;
        this.supports = supports;
        this.returnMaterial = returnMaterial;
    }

    private final ToolFinder finder = new ToolFinder();

    private final boolean supports;
    private final Material material;
    private final Material toolMaterial;
    private final Material returnMaterial;
}
