package com.devdyna.alchemia.init.builder.Sprinkler;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SprinklerBLK extends BaseEntityBlock {
    
    public SprinklerBLK(){
        super(BlockBehaviour.Properties.of());
    }

    public SprinklerBLK(BlockBehaviour.Properties p){
        super(p);
    }

    @SuppressWarnings("null")
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new SprinklerBE(pos, state);
    }

    @SuppressWarnings("null")
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return SprinklerBE::tick;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(SprinklerBLK::new);
    }

}
