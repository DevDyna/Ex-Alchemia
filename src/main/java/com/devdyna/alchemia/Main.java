package com.devdyna.alchemia;

import com.devdyna.alchemia.events.block.broken;
import com.devdyna.alchemia.init.Material;
import com.devdyna.alchemia.init.compat.core;
import com.devdyna.alchemia.utils.LogUtil;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "alchemia";

    public Main(IEventBus bus, ModContainer mc) {

        new LogUtil();

        Material.register(bus);
        core.registerCompat();

        NeoForge.EVENT_BUS.register(new broken());

    }
}
