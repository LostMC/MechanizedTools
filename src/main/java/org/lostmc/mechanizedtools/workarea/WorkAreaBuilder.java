package org.lostmc.mechanizedtools.workarea;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.material.Attachable;
import org.bukkit.material.MaterialData;

import java.util.HashMap;
import java.util.Map;

public class WorkAreaBuilder {
    private static final BlockFace[] TRUE_COMPASS_FACES = new BlockFace[]
            {BlockFace.NORTH, BlockFace.EAST, BlockFace.WEST, BlockFace.SOUTH};
    private static final Map<BlockFace, BlockFace> oppositeFace = new HashMap<>();

    static {
        oppositeFace.put(BlockFace.NORTH, BlockFace.SOUTH);
        oppositeFace.put(BlockFace.SOUTH, BlockFace.NORTH);
        oppositeFace.put(BlockFace.WEST, BlockFace.EAST);
        oppositeFace.put(BlockFace.EAST, BlockFace.WEST);
    }

    public WorkArea build(Block signBlock) {
        WorkArea workArea = new WorkArea();
        workArea.setSignBlockLocation(signBlock.getLocation());
        setAltitudeValues(signBlock, workArea);

        BlockFace face = getAttachedFace(signBlock);
        Block engineBlock = signBlock.getRelative(face);
        if (isAnIronBlock(engineBlock)) {
            workArea.setValid(false);
        }

        Block supplyChestBlock = engineBlock.getRelative(BlockFace.UP);
        if (isAChest(supplyChestBlock)) {
            workArea.setValid(false);
        }

        workArea.setSupplyChestLocation(supplyChestBlock.getLocation());
        updateMinimums(workArea, engineBlock);
        updateMaximums(workArea, engineBlock);
        traceRedstone(workArea, face, engineBlock);

        return workArea;
    }

    private void setAltitudeValues(Block signBlock, WorkArea workArea) {
        BlockState state = signBlock.getState();
        if (state.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) state;
            String line = sign.getLine(1);
            String minimum = line;
            try {
                if (line.contains("-")) {
                    String[] split = line.split("\\-");
                    minimum = split[0];
                    int maximumY = Integer.parseInt(split[1]);
                    workArea.setMaximumY(maximumY);
                } else {
                    workArea.setMaximumY(signBlock.getWorld().getMaxHeight());
                }
                int minimumY = Integer.parseInt(minimum);
                workArea.setMinimumY(minimumY);
                if (workArea.getMinimumY() > workArea.getMaximumY()) {
                    workArea.setValid(false);
                }
            } catch (NumberFormatException exception) {
                workArea.setValid(false);
            }
        }
    }

    private void traceRedstone(WorkArea workArea, BlockFace face, Block engineBlock) {
        Block block = engineBlock;
        BlockFace previous = face;
        while (face != BlockFace.SELF) {
            previous = face;
            face = findAdjacentMaterial(block, Material.REDSTONE_WIRE, oppositeFace.get(face));
            block = block.getRelative(face);
            updateMinimums(workArea, block);
            updateMaximums(workArea, block);
        }

        if (findAdjacentMaterial(block, Material.IRON_BLOCK, oppositeFace.get(previous)) == BlockFace.SELF) {
            workArea.setValid(false);
        }
    }

    private BlockFace findAdjacentMaterial(Block locus, Material material, BlockFace faceToExclude) {
        for (BlockFace face : TRUE_COMPASS_FACES) {
            if (face != faceToExclude) {
                Block block = locus.getRelative(face);
                if (block.getState().getType() == material) {
                    return face;
                }
            }
        }
        return BlockFace.SELF;
    }

    private void updateMaximums(WorkArea workArea, Block engineBlock) {
        workArea.setMaximumX(Long.max(engineBlock.getX(), workArea.getMaximumX()));
        workArea.setMaximumZ(Long.max(engineBlock.getZ(), workArea.getMaximumZ()));
    }

    private void updateMinimums(WorkArea workArea, Block block) {
        workArea.setMinimumX(Long.min(block.getX(), workArea.getMinimumX()));
        workArea.setMinimumZ(Long.min(block.getZ(), workArea.getMinimumZ()));
    }

    private boolean isAChest(Block supplyChestBlock) {
        return supplyChestBlock.getState().getType() != Material.CHEST;
    }

    private boolean isAnIronBlock(Block engineBlock) {
        return engineBlock.getState().getType() != Material.IRON_BLOCK;
    }

    private BlockFace getAttachedFace(Block block) {
        MaterialData data = block.getState().getData();
        BlockFace face = BlockFace.DOWN;
        if (data instanceof Attachable) {
            face = ((Attachable) data).getAttachedFace();
        }
        return face;
    }
}
