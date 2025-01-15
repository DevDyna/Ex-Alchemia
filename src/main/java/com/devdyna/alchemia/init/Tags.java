package com.devdyna.alchemia.init;

import com.devdyna.alchemia.Main;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static final TagKey<Item> CROOKS = TagKey.create(BuiltInRegistries.ITEM.key(),
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "crooks"));

            public static final TagKey<Item> AZALEA = TagKey.create(BuiltInRegistries.ITEM.key(),
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "azalea"));

            public static final TagKey<Block> SIEVE = TagKey.create(BuiltInRegistries.BLOCK.key(),
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "sieve"));



           
}
