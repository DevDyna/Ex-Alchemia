package com.devdyna.alchemia.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.devdyna.alchemia.Main;

public class CreativeTab {

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS
            .register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(Main.MODID+".tab"))
                                                                           
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> Items.WOODEN_CROOK.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        // output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For
                        // your own tabs, this method is preferred over the event
                    }).build());
}
