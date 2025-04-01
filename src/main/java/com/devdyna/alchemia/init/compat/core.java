package com.devdyna.alchemia.init.compat;

import com.devdyna.alchemia.init.compat.ars.ritual.GigaSpawn;
import com.hollingsworth.arsnouveau.api.registry.RitualRegistry;

import net.neoforged.fml.ModList;

public class core {

    public static void registerCompat() {
        if (checkMod("ars_nouveau"))
            RitualRegistry.registerRitual(new GigaSpawn());
    }

    public static boolean checkMod(String s) {
        return ModList.get().isLoaded(s);
    }
}
