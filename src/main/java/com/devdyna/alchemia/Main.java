package com.devdyna.alchemia;

import com.devdyna.alchemia.utils.Constants;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "alchemia";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        com.devdyna.alchemia.init.Blocks.register(modEventBus);

        com.devdyna.alchemia.init.Items.register(modEventBus);

        com.devdyna.alchemia.init.CreativeTab.register(modEventBus);

        for (Object obj : Constants.AllEvents) {
            NeoForge.EVENT_BUS.register(obj);
        }

    }
}
