package com.devdyna.alchemia.init.builder.Miner;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

/**
 * Miner Core Builder
 */
public class CoreMiner extends Block {
    public CoreMiner(BlockBehaviour.Properties prop) {
        super(prop.sound(SoundType.METAL).destroyTime(20).pushReaction(PushReaction.BLOCK));
    }
}
