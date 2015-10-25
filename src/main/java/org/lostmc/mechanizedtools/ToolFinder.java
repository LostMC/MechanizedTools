package org.lostmc.mechanizedtools;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolFinder {
    public boolean supports(Material material) {
        return TOOL_PREFERENCES.containsKey(material);
    }

    public ItemStack findToolFor(Material material, Inventory inventory) {
        for (Material tool : TOOL_PREFERENCES.get(material)) {
            if (tool == Material.AIR) {
                return new ItemStack(Material.AIR);
            }
            if (inventory.contains(tool)) {
                return inventory.getItem(inventory.first(tool));
            }
        }
        return null;
    }

    public ToolFinder() {
        List<Material> handAndSpade = Arrays.asList(Material.AIR, Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE, Material.GOLD_SPADE);
        TOOL_PREFERENCES.put(Material.GRAVEL, handAndSpade);
        TOOL_PREFERENCES.put(Material.DIRT, handAndSpade);
        TOOL_PREFERENCES.put(Material.GRASS, handAndSpade);
        TOOL_PREFERENCES.put(Material.SAND, handAndSpade);

        List<Material> pick = Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE, Material.GOLD_PICKAXE);
        TOOL_PREFERENCES.put(Material.STONE, pick);
        TOOL_PREFERENCES.put(Material.SANDSTONE, pick);

        List<Material> pickSmaller = Arrays.asList(Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE);
        TOOL_PREFERENCES.put(Material.IRON_ORE, pickSmaller);
    }

    private final Map<Material, List<Material>> TOOL_PREFERENCES = new HashMap<>();
}
