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
            workArea.setInvalidReason("Engine missing");
        }

        Block supplyChestBlock = engineBlock.getRelative(BlockFace.UP);
        if (isAChest(supplyChestBlock)) {
            workArea.setValid(false);
            workArea.setInvalidReason("Chest missing");
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
            String[] split = sign.getLine(1).split("\\-");
            try {
                workArea.setMinimumY(Integer.parseInt(split[0]));
            } catch (NumberFormatException exception) {
                workArea.setValid(false);
                workArea.setInvalidReason("Invalid depth");
                return;
            }
            if (split.length == 2) {
                try {
                    workArea.setMaximumY(Integer.parseInt(split[1]));
                } catch (NumberFormatException exception) {
                    workArea.setValid(false);
                    workArea.setInvalidReason("Invalid height");
                    return;
                }
            } else {
                workArea.setMaximumY(signBlock.getWorld().getMaxHeight());
            }
            if (workArea.getMinimumY() > workArea.getMaximumY()) {
                workArea.setValid(false);
                workArea.setInvalidReason("Depth too high");
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
        workArea.setMaximumX(Integer.max(engineBlock.getX(), workArea.getMaximumX()));
        workArea.setMaximumZ(Integer.max(engineBlock.getZ(), workArea.getMaximumZ()));
    }

    private void updateMinimums(WorkArea workArea, Block block) {
        workArea.setMinimumX(Integer.min(block.getX(), workArea.getMinimumX()));
        workArea.setMinimumZ(Integer.min(block.getZ(), workArea.getMinimumZ()));
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
