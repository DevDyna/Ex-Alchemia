package com.devdyna.alchemia.init.special;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PottedAzalea extends Block {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

    protected static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(5.0, 0.0, 5.0, 11.0, 12.0, 11.0),
            Block.box(5.0, 0.0, 5.0, 11.0, 12.0, 11.0),
            Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0),
            Block.box(4.5, 0.0, 4.5, 11.5, 15.0, 11.5),
            Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0),

    };

    @SuppressWarnings("null")
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    public PottedAzalea(BlockBehaviour.Properties prop) {
        super(prop);
        this.registerDefaultState(stateDefinition.any()
                .setValue(AGE, 0)

        );
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(AGE, Integer.valueOf(age));
    }

    @SuppressWarnings("null")
    protected void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        int stage = state.getValue(AGE);
        if (stage < 7) {
            world.setBlock(pos, getStateForAge(stage+1), 2);
        }
    }

    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

}
