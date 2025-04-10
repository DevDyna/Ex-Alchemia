package com.devdyna.alchemia.init;

import java.util.function.Supplier;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.builder.ResourceGen.Deposit;
import com.devdyna.alchemia.init.builder.ResourceGen.Soil;
import com.devdyna.alchemia.init.types.BlockEntities;
import com.devdyna.alchemia.init.types.BlockTag;
import com.devdyna.alchemia.init.types.Blocks;
import com.devdyna.alchemia.init.types.CreativeTab;
import com.devdyna.alchemia.init.types.ItemTag;
import com.devdyna.alchemia.init.types.Items;
import com.devdyna.alchemia.utils.DataGenUtil;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Material {
        public static void register(IEventBus bus) {
                BlockEntities.register(bus);
                Blocks.register(bus);
                BlockTag.register(bus);
                CreativeTab.register(bus);
                Items.register(bus);
                ItemTag.register(bus);
        }

        public static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        public static final Properties iProp = new Item.Properties();

        /**
         * register an block item
         * 
         * @param sup () -> new Builder
         */
        public static DeferredHolder<Block, ?> registerItemBlock(String blockname, Supplier<? extends Block> sup) {
                return registerItemBlock(blockname, sup, Blocks.zBlockItem);
        }

        /**
         * register an block item
         * 
         * @param sup () -> new Builder
         * @param b   Blocks.zBlock
         */
        public static DeferredHolder<Block, ?> registerItemBlock(String blockname, Supplier<? extends Block> sup,
                        DeferredRegister.Blocks b) {
                DeferredHolder<Block, ?> block = b.register(blockname, sup);
                Items.zBlockItem.registerSimpleBlockItem(block);
                return block;
        }

        /**
         * create an itemtag
         */
        public static TagKey<Item> tagItem(String name) {
                return TagKey.create(BuiltInRegistries.ITEM.key(),
                                ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
        }

        /**
         * create an blocktag
         */
        public static TagKey<Block> tagBlock(String name) {
                return TagKey.create(BuiltInRegistries.BLOCK.key(),
                                ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
        }

        /**
         * create a blockitem deposit
         */
        public static void registerDeposit(String name) {
                registerItemBlock("deposit_" + name, () -> new Deposit(), Blocks.zBlockDeposit);
        }

        /**
         * create a blockitem soil
         */
        public static void registerSoil(String name, TagKey<Block> b) {
                registerItemBlock("soil_" + name, () -> new Soil(b), Blocks.zBlockSoil);
        }

        public static Block getSoil(String id) {
                return DataGenUtil.getBlock("soil_" + id);
        }

        public static Block getDeposit(String id) {
                return DataGenUtil.getBlock("deposit_" + id);
        }

}
