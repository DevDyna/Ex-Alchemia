package com.devdyna.alchemia.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.alchemia.init.types.ItemTag;
import com.devdyna.alchemia.init.types.Items;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")

public class DataItemTag extends ItemTagsProvider {

    public DataItemTag(PackOutput o, CompletableFuture<Provider> p, CompletableFuture<TagLookup<Block>> b) {
        super(o, p, b);
    }

    @Override
    protected void addTags(Provider p) {
        tag(ItemTag.CROOKS)
                .add(Items.WOODEN_CROOK.getKey());
    }

}