package com.devdyna.alchemia.init;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.special.Crook;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);

    public static final DeferredItem<Item> BERRY = ITEMS.registerSimpleItem("berry",
            new Item.Properties().food(new FoodProperties.Builder()
                    .alwaysEdible().nutrition(4).saturationModifier(4f).build()));

    public static final DeferredItem<Item> WOODEN_CROOK = ITEMS.register("wooden_crook",
            () -> new Crook(new Item.Properties().durability(128).stacksTo(1)));

    public static final DeferredItem<BlockItem> AZALEA = ITEMS
            .registerSimpleBlockItem(com.devdyna.alchemia.init.Blocks.AZALEA);
}
