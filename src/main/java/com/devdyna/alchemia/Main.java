package com.devdyna.alchemia;

import com.devdyna.alchemia.events.BlockBreak;
import com.devdyna.alchemia.events.BlockClicked;
import com.devdyna.alchemia.events.PistonPush;
import com.devdyna.alchemia.init.Material;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "alchemia";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        
        Material.register(modEventBus);


        com.devdyna.alchemia.init.CreativeTab.register(modEventBus);


            NeoForge.EVENT_BUS.register(new BlockBreak());
            NeoForge.EVENT_BUS.register(new BlockClicked());
            NeoForge.EVENT_BUS.register(new PistonPush());
        

    }
}
