package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.material.Sign;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockSign;
import org.lostmc.mctesting.MockWorld;
import org.lostmc.mctesting.MockWorldBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkAreaTestHelper {
    private MockBlock signBlock;
    private MockBlock engineBlock;
    private MockBlock supplyChest;
    private Map<Integer, List<MockBlock>> blockListsByLayer = new HashMap<>();

    public void createValidArea() {
        createValidArea("Excavator", "56");
    }

    public void createValidArea(int x, int y, int size) {
        createValidArea(x, y, size, "Excavator", "56");
    }

    public void createValidArea(String... lines) {
        createValidArea(-2, -8, 20, lines);
    }

    private void createValidArea(int x, int y, int size, String... lines) {
        MockWorld world = new MockWorldBuilder().withSize(size).build();
        signBlock = (MockBlock) world.getBlockAt(x, 64, y);
        engineBlock = (MockBlock) signBlock.getRelative(BlockFace.SOUTH);
        supplyChest = (MockBlock) engineBlock.getRelative(BlockFace.UP);
        createValidArea(signBlock, engineBlock, supplyChest, BlockFace.NORTH, Arrays.asList(lines));
    }

    private void createValidArea(MockBlock signBlock, MockBlock engineBlock, MockBlock chestBlock, BlockFace signFacing, List<String> signLines) {
        createSignBlock(signBlock, signFacing, signLines);
        createEngineBlock(engineBlock);
        createSupplyChest(chestBlock);
        addRedstone(engineBlock);
        constructBlockLists(blockListsByLayer);
    }

    public void createSignBlock(MockBlock block, BlockFace facing, List<String> lines) {
        Sign data = new Sign(Material.WALL_SIGN);
        data.setFacingDirection(facing);

        block.setType(Material.WALL_SIGN);

        MockSign sign = new MockSign(block);
        sign.setData(data);
        int i = 0;
        for (String line : lines) {
            sign.setLine(i++, line);
        }
        sign.update(true);

        block.setState(sign);
    }

    private void createEngineBlock(MockBlock block) {
        block.setType(Material.IRON_BLOCK);
    }

    private void createSupplyChest(MockBlock block) {
        block.setType(Material.CHEST);
    }

    private void addRedstone(MockBlock engineBlock) {
        MockBlock block = setNextBlock(engineBlock, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.SOUTH);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.EAST);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.NORTH);
        block = setNextBlock(block, BlockFace.WEST);
        block = setNextBlock(block, BlockFace.WEST);
        setNextBlock(block, BlockFace.SOUTH);
    }

    private Map<Integer, List<MockBlock>> constructBlockLists(Map<Integer, List<MockBlock>> map) {
        List<MockBlock> firstLayer = constructFirstLayer();
        map.put(63, firstLayer);
        List<MockBlock> previous = firstLayer;
        for (int y = 62; y >= 0; y--) {
            List<MockBlock> blocks = new ArrayList<>();
            for (MockBlock block : previous) {
                blocks.add((MockBlock) block.getRelative(BlockFace.DOWN));
            }
            map.put(y, blocks);
            previous = blocks;
        }
        return map;
    }

    private List<MockBlock> constructFirstLayer() {
        List<MockBlock> blocks = new ArrayList<>();
        World world = signBlock.getWorld();
        blocks.add((MockBlock) world.getBlockAt(-5, 63, -8));
        blocks.add((MockBlock) world.getBlockAt(-5, 63, -7));
        blocks.add((MockBlock) world.getBlockAt(0, 63, -7));
        for (int i = 0; i < 6; i++) {
            blocks.add((MockBlock) world.getBlockAt(-5 + i, 63, -6));
        }
        for (int i = 0; i < 6; i++) {
            blocks.add((MockBlock) world.getBlockAt(-7 + i, 63, -5));
        }
        for (int i = 0; i < 6; i++) {
            blocks.add((MockBlock) world.getBlockAt(-7 + i, 63, -4));
        }
        blocks.add((MockBlock) world.getBlockAt(-3, 63, -3));
        blocks.add((MockBlock) world.getBlockAt(-2, 63, -3));
        blocks.add((MockBlock) world.getBlockAt(-3, 63, -2));
        blocks.add((MockBlock) world.getBlockAt(-2, 63, -2));
        blocks.add((MockBlock) world.getBlockAt(-3, 63, -1));
        blocks.add((MockBlock) world.getBlockAt(-2, 63, -1));

        return blocks;
    }

    private MockBlock setNextBlock(MockBlock block, BlockFace face) {

        MockBlock newBlock = (MockBlock) block.getRelative(face);
        newBlock.setType(Material.REDSTONE_WIRE);
        return newBlock;
    }

    public MockBlock getSignBlock() {
        return signBlock;
    }

    public MockBlock getEngineBlock() {
        return engineBlock;
    }

    public MockBlock getSupplyChest() {
        return supplyChest;
    }
}
