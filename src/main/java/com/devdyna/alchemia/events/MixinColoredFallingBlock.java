package com.devdyna.alchemia.events;

import javax.annotation.Nonnull;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;

@Mixin(ColoredFallingBlock.class)
public class MixinColoredFallingBlock extends Block {

  public MixinColoredFallingBlock(ColorRGBA dustColor, BlockBehaviour.Properties properties) {
    super(properties);

  }

  @Override
  public boolean isRandomlyTicking(@Nonnull BlockState state) {
    return state.is(Tags.Blocks.GRAVELS);
  }

  @Inject(method = "randomTick", at = @At("HEAD"), require = 1)
  public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand, CallbackInfo info) {
    

  }



}