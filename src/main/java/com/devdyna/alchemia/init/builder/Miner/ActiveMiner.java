package com.devdyna.alchemia.init.builder.Miner;

import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Miner Core Builder
 * it can generate resources at cost of resources
 */
public class ActiveMiner extends CoreMiner {
    public ActiveMiner(BlockBehaviour.Properties prop) {
        super(prop);
    }
}
