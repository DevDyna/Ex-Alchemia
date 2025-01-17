package com.devdyna.alchemia.init;


import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.special.Crook;
import com.devdyna.alchemia.init.special.PottedAzalea;
import com.devdyna.alchemia.init.special.Miner.ActiveMiner;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Material {
        public static void register(IEventBus bus) {
                BLOCKS.register(bus);
                ITEMS.register(bus);
        }

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);

        private static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        private static final Properties iProp = new Item.Properties();

        public static final DeferredBlock<Block> AZALEA_BLOCK = BLOCKS.register("azalea",
                        () -> new PottedAzalea(bProp));

        public static final DeferredBlock<Block> PASSIVE_MINER = BLOCKS.registerSimpleBlock("passive_miner",
                        bProp);

        public static final DeferredBlock<Block> ACTIVE_MINER = BLOCKS.register("active_miner", 
                       ()-> new ActiveMiner(bProp));

        public static final DeferredItem<BlockItem> ACTIVE_MINER_ITEM = ITEMS.registerSimpleBlockItem(ACTIVE_MINER);
        public static final DeferredItem<BlockItem> PASSIVE_MINER_ITEM = ITEMS.registerSimpleBlockItem(PASSIVE_MINER);

        public static final DeferredItem<Item> AZALEA_SEED = ITEMS.registerSimpleItem("azalea_seed",
                        iProp);

        public static final DeferredItem<Item> BERRY = ITEMS.registerSimpleItem("berry",
                        iProp);

        public static final DeferredItem<Item> WOODEN_CROOK = ITEMS.register("wooden_crook",
                        () -> new Crook(iProp, 2048));

}
