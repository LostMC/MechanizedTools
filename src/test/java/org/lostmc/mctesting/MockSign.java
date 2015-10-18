package org.lostmc.mctesting;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class MockSign extends MockBlockState implements Sign {
    private String[] lines = new String[4];

    public MockSign(Block block) {
        super(block);
    }

    public String[] getLines() {
        return lines;
    }

    public String getLine(int index) throws IndexOutOfBoundsException {
        return lines[index];
    }

    public void setLine(int index, String line) throws IndexOutOfBoundsException {
        this.lines[index] = line;
    }
}
