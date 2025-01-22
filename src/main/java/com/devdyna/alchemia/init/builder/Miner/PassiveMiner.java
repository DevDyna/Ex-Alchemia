package com.devdyna.alchemia.init.builder.Miner;

import java.util.List;

import com.devdyna.alchemia.init.Tags;
import com.devdyna.alchemia.utils.LevelUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Miner Passive Builder
 * it can generate resources at cost of time
 */
public class PassiveMiner extends CoreMiner {
    public PassiveMiner(BlockBehaviour.Properties prop) {
        super(prop.randomTicks());
    }

    @SuppressWarnings("null")
    protected void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        ServerLevel level = world.getLevel();
        BlockPos up = pos.above();
        BlockPos down = pos.below();

        if(!level.getBlockState(down).is(Tags.DEPOSIT))return;

        List<ItemStack> items = LevelUtil.getItemStackFromLootTable(level,
                level.getBlockState(down).getBlock().defaultBlockState());

        for (ItemStack items2 : items) {
            LevelUtil.popItemFromPos(level, up.getX() + 0.5, up.getY() + 0.25,
                    up.getZ() + 0.5, items2);
        }

    }

}
