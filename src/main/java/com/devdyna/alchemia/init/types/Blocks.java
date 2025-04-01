package com.devdyna.alchemia.init.types;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.builder.Planter;
import com.devdyna.alchemia.init.builder.PottedAzalea;
import com.devdyna.alchemia.init.builder.ResourceGen.Deposit;
import com.devdyna.alchemia.init.builder.ResourceGen.Soil;
import com.devdyna.alchemia.init.builder.Sprinkler.SprinklerBLK;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import static com.devdyna.alchemia.init.Material.registerItemBlock;
import static com.devdyna.alchemia.init.Material.registerDeposit;
import static com.devdyna.alchemia.init.Material.registerSoil;

import java.util.List;

public class Blocks {
        public static void register(IEventBus bus) {
                registerLists();
                zBlock.register(bus);
                zBlockItem.register(bus);
                zBlockDeposit.register(bus);
                zBlockSoil.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(Main.MODID);
        public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(Main.MODID);
        public static final DeferredRegister.Blocks zBlockDeposit = DeferredRegister.createBlocks(Main.MODID);
        public static final DeferredRegister.Blocks zBlockSoil = DeferredRegister.createBlocks(Main.MODID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<Block, PottedAzalea> AZALEA = zBlock.register("azalea",
                        () -> new PottedAzalea());

        public static final DeferredHolder<Block, ?> PLANTER = registerItemBlock("planter",
                        () -> new Planter());

        public static final DeferredHolder<Block, ?> SPRINKLER = registerItemBlock("sprinkler",
                        () -> new SprinklerBLK());
        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

                List.of(
                                Deposit.COPPER,
                                Deposit.GOLD,
                                Deposit.IRON,
                                Deposit.PLATINUM,
                                Deposit.SAND,
                                Deposit.STONE,
                                Deposit.URANIUM).forEach(dep -> registerDeposit(dep));

                registerSoil(Soil.I0, BlockTag.Deposit_0);
                registerSoil(Soil.I1, BlockTag.Deposit_1);
                registerSoil(Soil.I2, BlockTag.Deposit_2);
                registerSoil(Soil.I3, BlockTag.Deposit_3);
                registerSoil(Soil.I4, BlockTag.Deposit_4);
                registerSoil(Soil.I5, BlockTag.Deposit_5);
                registerSoil(Soil.I6, BlockTag.Deposit_6);
                registerSoil(Soil.I7, BlockTag.Deposit_7);
                registerSoil(Soil.I8, BlockTag.Deposit_8);
        }

}
