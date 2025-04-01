package com.devdyna.alchemia.init.builder.Sprinkler;

import com.devdyna.alchemia.init.types.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SprinklerBE extends BlockEntity {

    private static int radius = 5;

    public SprinklerBE(BlockPos pos, BlockState state) {
        super(BlockEntities.SPRINKLER.get(), pos, state);
    }

    public static <T extends BlockEntity> void tick(Level l, BlockPos p, BlockState s, T i) {
        if (!l.isClientSide)
            BlockPos.randomBetweenClosed(l.random, 3,
                    p.getX() - radius, p.getY(), p.getZ() - radius,
                    p.getX() + radius, p.getY() + 2, p.getZ() + radius)
                    .forEach(pos -> {
                        BlockState st = l.getBlockState(pos);
                        if (st.isRandomlyTicking() && l instanceof ServerLevel) {
                            st.randomTick((ServerLevel) l, pos, l.random);
                        }
                    });

    }

}
