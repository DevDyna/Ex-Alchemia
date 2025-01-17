package com.devdyna.alchemia.events;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.PistonEvent;

public class PistonPush {
    @SubscribeEvent
    public void PistonPushEvent(PistonEvent.Pre event) {
        event.getLevel().setBlock(event.getFaceOffsetPos(), Blocks.STONE.defaultBlockState(), 32);
    }
}
