package org.lostmc.mctesting;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class MockSign extends MockBlockState implements Sign {
    private String[] lines = new String[4];
    private String[] newLines = new String[4];

    public MockSign(Block block) {
        super(block);
        for (int i = 0; i< 4;i++) {
            lines[i] = "";
            newLines[i] = "";
        }
    }

    public String[] getLines() {
        return lines;
    }

    public String getLine(int index) throws IndexOutOfBoundsException {
        return lines[index];
    }

    public void setLine(int index, String line) throws IndexOutOfBoundsException {
        this.newLines[index] = line;
    }

    @Override
    public boolean update(boolean force) {
        System.arraycopy(newLines, 0, lines, 0, 4);
        return super.update(force);
    }
}
