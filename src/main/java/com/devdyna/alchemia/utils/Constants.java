package com.devdyna.alchemia.utils;

import java.util.ArrayList;
import com.devdyna.alchemia.init.*;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class Constants {

        public static final DeferredBlock<?>[] AllBlocks() {
                ArrayList<DeferredBlock<?>> i = new ArrayList<>();
                Material.BLOCKS.getEntries().forEach(e -> {
                        i.add((DeferredBlock<?>) e);
                });
                return (DeferredBlock<?>[]) i.toArray();
        };

        public static final DeferredItem<?>[] AllItems() {
                ArrayList<DeferredItem<?>> i = new ArrayList<>();
                Material.ITEMS.getEntries().forEach(e -> {
                        i.add((DeferredItem<?>) e);
                });
                return (DeferredItem<?>[]) i.toArray();
        };

}
