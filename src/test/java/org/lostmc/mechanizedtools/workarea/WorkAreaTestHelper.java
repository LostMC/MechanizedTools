package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.Sign;
import org.lostmc.mctesting.MockBlock;
import org.lostmc.mctesting.MockSign;

import java.util.List;

public class WorkAreaTestHelper {
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

        block.setState(sign);
    }
}
