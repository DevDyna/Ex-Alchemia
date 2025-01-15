package com.devdyna.alchemia.events;

import com.devdyna.alchemia.init.Tags;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.PistonEvent;

public class PistonPush {
    @SubscribeEvent
    public void PistonPushEvent(PistonEvent.Post event) {
        if (event.getState().is(Tags.SIEVE)) {
        }

    }
}
