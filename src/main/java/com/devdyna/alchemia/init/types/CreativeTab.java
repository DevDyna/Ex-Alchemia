package com.devdyna.alchemia.init.types;

import com.devdyna.alchemia.Main;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTab {
        public static void register(IEventBus bus) {
                zCreative.register(bus);
        }

        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<CreativeModeTab> zCreative = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, Main.MODID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = zCreative
                        .register(Main.MODID, () -> CreativeModeTab.builder()
                                        .title(Component.translatable(Main.MODID + ".tab"))

                                        .withTabsBefore(CreativeModeTabs.COMBAT)
                                        .icon(() -> Items.WOODEN_CROOK.get().getDefaultInstance())
                                        .displayItems((parameters, output) -> {

                                                Items.zItem.getEntries().forEach(e -> {
                                                        output.accept((Item) e.get());
                                                });

                                                Items.zTool.getEntries().forEach(e -> {
                                                        output.accept((Item) e.get());
                                                });

                                        }).build());

}
