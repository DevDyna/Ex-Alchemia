package com.devdyna.alchemia.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.utils.Constants;

public class CreativeTab {

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS
            .register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(Main.MODID + ".tab"))

                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> Material.WOODEN_CROOK.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        for (DeferredItem<?> i : Constants.AllItems()) {
                            output.accept(i.get());
                        }

                    }).build());
}
