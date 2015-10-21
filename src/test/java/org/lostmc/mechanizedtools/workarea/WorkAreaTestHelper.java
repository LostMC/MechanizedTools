package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.Sign;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockSign;

import java.util.Arrays;
import java.util.List;

public class WorkAreaTestHelper {
    private MockBlock signBlock;
    private MockBlock engineBlock;
    private MockBlock supplyChest;

    public void createValidArea() {
        createValidArea("Excavator", "56");
    }

    public void createValidArea(int i, int j, int size) {
        createValidArea(i, j, size, "Excavator", "56");
    }

    public void createValidArea(String... lines) {
        createValidArea(8, 2, 20, lines);
    }

    private void createValidArea(int i, int j, int size, String... lines) {
        MockBlock[][][] array = MockBlock.createBlockArray(size, size);
        signBlock = array[i][j][64];
        engineBlock = (MockBlock) signBlock.getRelative(BlockFace.SOUTH);
        supplyChest = (MockBlock) engineBlock.getRelative(BlockFace.UP);
        createValidArea(signBlock, engineBlock, supplyChest, BlockFace.NORTH, Arrays.asList(lines));
    }

    public void createValidArea(MockBlock signBlock, MockBlock engineBlock, MockBlock chestBlock, BlockFace signFacing, List<String> signLines) {
        createSignBlock(signBlock, signFacing, signLines);
        createEngineBlock(engineBlock);
        createSupplyChest(chestBlock);
        addRedstone(engineBlock);
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
