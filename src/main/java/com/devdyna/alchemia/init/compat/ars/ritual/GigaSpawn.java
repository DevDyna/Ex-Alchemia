package com.devdyna.alchemia.init.compat.ars.ritual;

import com.devdyna.alchemia.Main;
import com.hollingsworth.arsnouveau.api.ritual.StructureRitual;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;

public class GigaSpawn extends StructureRitual {
    public GigaSpawn() {
        super(ResourceLocation.fromNamespaceAndPath(Main.MODID, "giga"),  new BlockPos(-62, -3, -62), 0, Biomes.MUSHROOM_FIELDS);
    }

    @Override
    public ResourceLocation getRegistryName() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, "giga");
    }
}