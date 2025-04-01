package com.devdyna.alchemia.init.types;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.builder.CroockItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    public static void register(IEventBus bus) {
        zItem.register(bus);
        zTool.register(bus);
        zBlockItem.register(bus);
    }
    // ---------------------------------------------------------------------------------------//
    public static final DeferredRegister.Items zTool = DeferredRegister.createItems(Main.MODID);
    public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(Main.MODID);
    public static final DeferredRegister.Items zItem = DeferredRegister.createItems(Main.MODID);
    // ---------------------------------------------------------------------------------------//

    public static final DeferredHolder<Item, Item> AZALEA_SEEDS = zItem.registerSimpleItem("azalea_seeds");

    public static final DeferredHolder<Item, Item> SMALL_AZALEA_LEAF = zItem.registerSimpleItem("small_azalea_leaf");

    public static final DeferredHolder<Item, Item> SMALL_AZALEA_ROOTS = zItem.registerSimpleItem("small_azalea_roots");


    public static final DeferredHolder<Item, CroockItem> WOODEN_CROOK = zTool.register("wooden_crook",
            () -> new CroockItem(BlockTag.LEAVES, Tiers.NETHERITE));

}
