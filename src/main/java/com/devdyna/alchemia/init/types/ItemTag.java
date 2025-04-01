package com.devdyna.alchemia.init.types;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

import static com.devdyna.alchemia.init.Material.tagItem;

public class ItemTag {
    public static void register(IEventBus bus) {

    }

    public static final TagKey<Item> CROOKS = tagItem("crooks");





}
