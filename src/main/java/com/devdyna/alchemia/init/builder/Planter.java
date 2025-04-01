package com.devdyna.alchemia.init.builder;

import com.devdyna.alchemia.init.types.Blocks;
import com.devdyna.alchemia.init.types.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Planter extends Block {

    public Planter() {
        super(BlockBehaviour.Properties.of());
    }

    @SuppressWarnings("null")
    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
            InteractionHand hand, BlockHitResult hitResult) {

        if (stack.is(Items.AZALEA_SEEDS)) {
            level.setBlockAndUpdate(pos,
                    Blocks.AZALEA.get().defaultBlockState().setValue(PottedAzalea.AGE, 0));

            if (!player.isCreative())
                stack.shrink(1);

            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }


    @SuppressWarnings("null")
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    }

}
