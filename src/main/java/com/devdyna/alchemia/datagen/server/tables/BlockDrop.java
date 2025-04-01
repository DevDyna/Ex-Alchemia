package com.devdyna.alchemia.datagen.server.tables;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devdyna.alchemia.init.types.Blocks;
import com.devdyna.alchemia.init.types.Items;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootPool.Builder;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockDrop extends BlockLootSubProvider {

        public BlockDrop(HolderLookup.Provider l) {
                super(Set.of(), FeatureFlags.DEFAULT_FLAGS, l);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
                List<Block> blocks = getList(Blocks.zBlock.getEntries());
                blocks.addAll(getList(Blocks.zBlockItem.getEntries()));
                blocks.addAll(getList(Blocks.zBlockDeposit.getEntries()));
                blocks.addAll(getList(Blocks.zBlockSoil.getEntries()));
                return blocks;
        }

        private List<Block> getList(Collection<DeferredHolder<Block, ? extends Block>> c) {
                return c.stream().map(e -> (Block) e.value()).toList();
        }

        @Override
        protected void generate() {
                Azalea(Blocks.AZALEA.get());
                dropSelf(Blocks.SPRINKLER.get());
                dropSelf(Blocks.PLANTER.get());

                Blocks.zBlockSoil.getEntries().forEach(soil -> dropSelf(soil.get()));

                Blocks.zBlockDeposit.getEntries().forEach(deposit -> dropSelf(deposit.get()));

        }

        private void Azalea(Block block) {
                LootItemBlockStatePropertyCondition.Builder cond = LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,
                                                7));

                Builder loot_leaf = LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.SMALL_AZALEA_LEAF.get()).when(cond)
                                                .apply(SetItemCountFunction
                                                                .setCount(UniformGenerator.between(1, 7)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(
                                                                registries.lookupOrThrow(Registries.ENCHANTMENT)
                                                                                .getOrThrow(Enchantments.FORTUNE))));

                Builder loot_roots = LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.SMALL_AZALEA_ROOTS.get()).when(cond)
                                                .apply(SetItemCountFunction
                                                                .setCount(UniformGenerator.between(1, 5)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(
                                                                registries.lookupOrThrow(Registries.ENCHANTMENT)
                                                                                .getOrThrow(Enchantments.FORTUNE))));

                Builder loot_sticks = LootPool.lootPool()
                                .add(LootItem.lootTableItem(net.minecraft.world.item.Items.STICK).when(cond)
                                                .apply(SetItemCountFunction
                                                                .setCount(UniformGenerator.between(1, 2)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(
                                                                registries.lookupOrThrow(Registries.ENCHANTMENT)
                                                                                .getOrThrow(Enchantments.FORTUNE))));

                Builder loot_seeds = LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.AZALEA_SEEDS.get()).when(cond)
                                                .apply(SetItemCountFunction
                                                                .setCount(UniformGenerator.between(1, 2)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(
                                                                registries.lookupOrThrow(Registries.ENCHANTMENT)
                                                                                .getOrThrow(Enchantments.FORTUNE)))
                                                .otherwise(LootItem.lootTableItem(Items.AZALEA_SEEDS.get())));

                add(block, applyExplosionDecay(block, LootTable.lootTable()
                                .withPool(loot_leaf)
                                .withPool(loot_roots)
                                .withPool(loot_sticks)
                                .withPool(loot_seeds)));
        }

}
