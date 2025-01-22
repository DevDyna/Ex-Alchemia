package com.devdyna.alchemia.init.builder;

import net.minecraft.world.item.Item;

public class MonoItem extends Item{
    
    public MonoItem(Properties prop){
        super(prop.stacksTo(1));
    }

}
