package com.devdyna.alchemia.init.builder.Sieve;

import com.devdyna.alchemia.init.Material;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SieveBE extends BlockEntity {

    public SieveBE(BlockPos pos, BlockState state) {
        super(Material.SIEVE_BE.get(), pos, state);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T ignoredT) {
        level.setBlockAndUpdate(pos.above(), Blocks.STONE_BRICKS.defaultBlockState());
        
        int a = new Scheduled(server.getickCount() + 20 /*1s delay*/, () -> null);
    
    }

}
