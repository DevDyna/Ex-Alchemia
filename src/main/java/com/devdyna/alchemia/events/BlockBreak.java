package com.devdyna.alchemia.events;

import java.util.List;

import com.devdyna.alchemia.utils.LevelUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

public class BlockBreak {

    @SubscribeEvent
    public void CrookBreak(BlockEvent.BreakEvent event) {

        LevelAccessor levelAccessor = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getPlayer();
        BlockState state = event.getState();
        String blockname = state.getBlock().getDescriptionId();
        ItemStack stack = player.getMainHandItem();

        if (state.is(BlockTags.LEAVES) &&
                stack.is(com.devdyna.alchemia.init.Tags.CROOKS)) {

            for (int i = 0; i < 10; i++) {

                List<ItemStack> list = LevelUtil.getItemStackFromLootTable(levelAccessor, blockname, player);

                for (ItemStack itemStack : list) {
                    LevelUtil.popItemFromPos((Level) levelAccessor, pos.getX() + 0.25, pos.getY() + 0.25,
                            pos.getZ() + 0.25, itemStack);
                }
            }
        }

    }

}
