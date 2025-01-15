package com.devdyna.alchemia.events;

import com.devdyna.alchemia.init.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class BlockClicked {

    @SubscribeEvent
    public void BlockClickedEvent(PlayerInteractEvent.RightClickBlock event) {
        BlockPos pos = event.getPos();
        ItemStack stack = event.getItemStack();
        Level level = event.getLevel();
        BlockState block = level.getBlockState(pos);

        if (stack.is(com.devdyna.alchemia.init.Tags.AZALEA) && block.is(BlockTags.FLOWER_POTS)) {
            level.setBlockAndUpdate(pos, Blocks.AZALEA.get().defaultBlockState());
        }

    }
}
