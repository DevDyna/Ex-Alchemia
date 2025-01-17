package com.devdyna.alchemia.init;

import com.devdyna.alchemia.Main;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static final TagKey<Item> CROOKS = tagItem("crook");

    public static final TagKey<Item> AZALEA = tagItem("azalea");

    public static final TagKey<Block> SIEVE = tagBlock("sieve");

    private static TagKey<Item> tagItem(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(),
                ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
    }

    private static TagKey<Block> tagBlock(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(),
                ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
    }

}
