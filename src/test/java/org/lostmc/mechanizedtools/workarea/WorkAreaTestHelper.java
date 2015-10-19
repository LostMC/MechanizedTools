package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.Sign;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockSign;

import java.util.List;

public class WorkAreaTestHelper {
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
        MockBlock rt = (MockBlock) engineBlock.getRelative(BlockFace.WEST);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.SOUTH);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.SOUTH);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.EAST);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.EAST);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.NORTH);
        rt.setType(Material.REDSTONE_WIRE);
        rt = (MockBlock) rt.getRelative(BlockFace.NORTH);
        rt.setType(Material.REDSTONE_WIRE);
    }

}
