package com.devdyna.alchemia.init.special;

import net.minecraft.world.item.Item;

public class Crook extends Item{
    
    public Crook(Properties prop,int durability){
        super(prop.durability(durability).stacksTo(1));
    }

}
