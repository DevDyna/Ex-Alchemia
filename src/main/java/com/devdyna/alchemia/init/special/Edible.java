package com.devdyna.alchemia.init.special;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Edible extends Item {

    /**
     * set the duration of the effect infinite
     */
    public int EFFECT_DURATION_INFINITE = -1;

    public Edible(Properties p, int nutrition, int saturation) {
        super(p.food(new FoodProperties.Builder()
                .nutrition(4).saturationModifier(4f).build()));
        /*
         * super(p.food(new FoodProperties.Builder().fast()
         * .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, duration, level),
         * chance)
         * .alwaysEdible().nutrition(nutrition).saturationModifier(saturation).build()))
         * ;
         */
    }
}
