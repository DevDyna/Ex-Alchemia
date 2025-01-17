package com.devdyna.alchemia.init.special.Miner;

import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Miner Passive Builder
 * it can generate resources at cost of time
 */
public class PassiveMiner extends CoreMiner {
    public PassiveMiner(BlockBehaviour.Properties prop) {
        super(prop.randomTicks());
    }
}
