package com.devdyna.alchemia.utils;

import com.devdyna.alchemia.events.BlockBreak;
import com.devdyna.alchemia.events.BlockClicked;
import com.devdyna.alchemia.events.PistonPush;
import com.devdyna.alchemia.init.*;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Constants {

        public static final Block[] AllBlocks = {
                        Blocks.AZALEA.get(),
                        Blocks.EXAMPLE_BLOCK.get()
        };

        public static final Item[] AllItems = {
                        Items.AZALEA.get(),
                        Items.WOODEN_CROOK.get(),
                        Items.BERRY.get()
        };

        public static final Object[] AllEvents = {
                        new BlockBreak(),
                        new BlockClicked(),
                        new PistonPush()
        };

}
