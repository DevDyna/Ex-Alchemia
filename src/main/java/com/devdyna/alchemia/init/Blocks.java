package com.devdyna.alchemia.init;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.special.PottedAzalea;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Blocks {
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block",
            BlockBehaviour.Properties.of());

    public static final DeferredBlock<Block> AZALEA = BLOCKS.register("azalea",
            () -> new PottedAzalea(BlockBehaviour.Properties.of().randomTicks().sound(SoundType.CROP).instabreak().noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

}
