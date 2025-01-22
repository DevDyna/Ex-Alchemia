package com.devdyna.alchemia.init.builder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class GhostBlock extends Block {

    private Boolean validSpawn;
    private Boolean pathFindable;

    public GhostBlock(BlockBehaviour.Properties s, Boolean isValidSpawn, Boolean isPathFindable, Boolean isSolid) {
        super(s.instabreak().noCollission());
        this.validSpawn = isValidSpawn;
        this.pathFindable = isPathFindable;
    }

    public boolean isValidSpawn(BlockGetter level, BlockPos pos, EntityType<?> entityType) {
        return validSpawn;
    }

    @SuppressWarnings("null")
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return pathFindable;
    }
}
