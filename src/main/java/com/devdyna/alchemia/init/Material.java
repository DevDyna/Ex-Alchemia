package com.devdyna.alchemia.init;

import java.util.function.Supplier;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.builder.MonoItem;
import com.devdyna.alchemia.init.builder.GhostBlock;
import com.devdyna.alchemia.init.builder.PottedAzalea;
import com.devdyna.alchemia.init.builder.Miner.ActiveMiner;
import com.devdyna.alchemia.init.builder.Miner.PassiveMiner;
import com.devdyna.alchemia.init.builder.Sieve.SieveBE;
import com.devdyna.alchemia.init.builder.Sieve.SieveBlock;

import net.minecraft.core.registries.BuiltInRegistries;
// import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Material {
        public static void register(IEventBus bus) {
                zBlock.register(bus);
                xItem.register(bus);
                cBE.register(bus);
        }

        public static final DeferredRegister<BlockEntityType<?>> cBE = DeferredRegister
                        .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.MODID);
        public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(Main.MODID);
        public static final DeferredRegister.Items xItem = DeferredRegister.createItems(Main.MODID);

        private static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        private static final Properties iProp = new Item.Properties();

        public static final DeferredBlock<Block> AZALEA_BLOCK = zBlock.register("azalea",
                        () -> new PottedAzalea(bProp));

        public static final DeferredBlock<Block> PASSIVE_MINER = registerItemBlock("passive_miner",
                        () -> new PassiveMiner(bProp));

        public static final DeferredBlock<Block> ACTIVE_MINER = registerItemBlock("active_miner",
                        () -> new ActiveMiner(bProp));

        public static final DeferredBlock<Block> GHOSTBLOCK = registerItemBlock("ghostblock",
                        () -> new GhostBlock(bProp, false, false, false));

        public static final DeferredBlock<Block> SIEVE_BLOCK = registerItemBlock("sieve", () -> new SieveBlock(bProp));

        @SuppressWarnings("null")
        public static final Supplier<BlockEntityType<SieveBE>> SIEVE_BE = cBE.register(
                        "sieve_be",
                        () -> BlockEntityType.Builder.of(SieveBE::new,
                        SIEVE_BLOCK.get()).build(null));

        private static DeferredBlock<Block> registerItemBlock(String blockname, Supplier<? extends Block> sup) {
                DeferredBlock<Block> a = zBlock.register(blockname, sup);
                xItem.registerSimpleBlockItem(a);
                return a;
        }

        public static final DeferredItem<Item> AZALEA_SEED = xItem.registerSimpleItem("azalea_seed",
                        iProp);

        public static final DeferredItem<Item> WOODEN_CROOK = xItem.register("wooden_crook",
                        () -> new MonoItem(iProp));

}
