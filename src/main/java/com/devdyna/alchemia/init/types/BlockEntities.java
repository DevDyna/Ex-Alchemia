package com.devdyna.alchemia.init.types;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.builder.Sprinkler.SprinklerBE;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("null")
public class BlockEntities {
    public static void register(IEventBus bus) {
        zBE.register(bus);
    }
    // ---------------------------------------------------------------------------------------//

    public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
            .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.MODID);
    // ---------------------------------------------------------------------------------------//

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SprinklerBE>> SPRINKLER = zBE
            .register(
                    "sprinkler_be",
                    () -> BlockEntityType.Builder.of(SprinklerBE::new,
                            Blocks.SPRINKLER.get()).build(null));

}
