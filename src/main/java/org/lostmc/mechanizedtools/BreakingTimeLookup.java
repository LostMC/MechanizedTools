package org.lostmc.mechanizedtools;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class BreakingTimeLookup {
    public boolean supports(Material material, BreakingMethod method) {
        return BREAKING_TIMES.containsKey(material) && BREAKING_TIMES.get(material).containsKey(method);
    }

    public long getBreakingTimeFor(Material material, BreakingMethod method) {
        Map<BreakingMethod, Long> materialTimes = BREAKING_TIMES.get(material);
        return materialTimes.get(method);
    }

    public BreakingTimeLookup() {
        BREAKING_TIMES.put(Material.DIRT, getDirtTimes());
        BREAKING_TIMES.put(Material.GRASS, getDirtTimes());
        BREAKING_TIMES.put(Material.GRAVEL, getGravelTimes());
        BREAKING_TIMES.put(Material.SAND, getSandTimes());
        BREAKING_TIMES.put(Material.SANDSTONE, getSandstoneTimes());
        BREAKING_TIMES.put(Material.STONE, getStoneTimes());
        BREAKING_TIMES.put(Material.IRON_ORE, getIronTimes());
    }

    private Map<BreakingMethod, Long> getIronTimes() {
        Map<BreakingMethod, Long> times = new HashMap<>();
        times.put(BreakingMethod.STONE, calculateTicks(1.15));
        times.put(BreakingMethod.IRON, calculateTicks(0.75));
        times.put(BreakingMethod.DIAMOND, calculateTicks(0.60));
        return times;
    }

    private Map<BreakingMethod, Long> getStoneTimes() {
        Map<BreakingMethod, Long> times = new HashMap<>();
        times.put(BreakingMethod.WOOD, calculateTicks(1.15));
        times.put(BreakingMethod.STONE, calculateTicks(0.60));
        times.put(BreakingMethod.IRON, calculateTicks(0.40));
        times.put(BreakingMethod.DIAMOND, calculateTicks(0.30));
        times.put(BreakingMethod.GOLD, calculateTicks(0.20));
        return times;
    }

    private Map<BreakingMethod, Long> getGravelTimes() {
        Map<BreakingMethod, Long> times = new HashMap<>();
        times.put(BreakingMethod.HAND, calculateTicks(0.90));
        times.put(BreakingMethod.WOOD, calculateTicks(0.45));
        times.put(BreakingMethod.STONE, calculateTicks(0.25));
        times.put(BreakingMethod.IRON, calculateTicks(0.15));
        times.put(BreakingMethod.DIAMOND, calculateTicks(0.15));
        times.put(BreakingMethod.GOLD, calculateTicks(0.10));
        return times;
    }

    private Map<BreakingMethod, Long> getSandTimes() {
        Map<BreakingMethod, Long> times = new HashMap<>();
        times.put(BreakingMethod.HAND, calculateTicks(0.75));
        times.put(BreakingMethod.WOOD, calculateTicks(0.40));
        times.put(BreakingMethod.STONE, calculateTicks(0.20));
        times.put(BreakingMethod.IRON, calculateTicks(0.15));
        times.put(BreakingMethod.DIAMOND, calculateTicks(0.10));
        times.put(BreakingMethod.GOLD, calculateTicks(0.10));
        return times;
    }

    private Map<BreakingMethod, Long> getDirtTimes() {
        Map<BreakingMethod, Long> times = new HashMap<>();
        times.put(BreakingMethod.HAND, calculateTicks(0.75));
        times.put(BreakingMethod.WOOD, calculateTicks(0.40));
        times.put(BreakingMethod.STONE, calculateTicks(0.20));
        times.put(BreakingMethod.IRON, calculateTicks(0.15));
        times.put(BreakingMethod.DIAMOND, calculateTicks(0.10));
        times.put(BreakingMethod.GOLD, calculateTicks(0.10));
        return times;
    }

    private Map<BreakingMethod, Long> getSandstoneTimes() {
        Map<BreakingMethod, Long> times = new HashMap<>();
        times.put(BreakingMethod.WOOD, calculateTicks(0.65));
        times.put(BreakingMethod.STONE, calculateTicks(0.35));
        times.put(BreakingMethod.IRON, calculateTicks(0.20));
        times.put(BreakingMethod.DIAMOND, calculateTicks(0.20));
        times.put(BreakingMethod.GOLD, calculateTicks(0.10));
        return times;
    }

    private long calculateTicks(double seconds) {
        return (long) (seconds * TICKS_PER_SECOND);
    }

    private static final int TICKS_PER_SECOND = 20;
    private final Map<Material, Map<BreakingMethod, Long>> BREAKING_TIMES = new HashMap<>();
}
