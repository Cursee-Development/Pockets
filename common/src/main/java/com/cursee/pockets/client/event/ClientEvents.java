package com.cursee.pockets.client.event;

import com.cursee.pockets.core.util.event.Event;
import com.cursee.pockets.core.util.event.EventFactory;
import net.minecraft.client.Minecraft;

public class ClientEvents {

    public static final Event<StartTickEvent> START_CLIENT_TICK = EventFactory.createArrayBacked(StartTickEvent.class, events -> instance -> {
        for (StartTickEvent event : events) {
            event.onStartTick(instance);
        }
    });

    @FunctionalInterface
    public interface StartTickEvent {
        void onStartTick(Minecraft client);
    }

    public static final Event<EndTickEvent> END_CLIENT_TICK = EventFactory.createArrayBacked(EndTickEvent.class, events -> instance -> {
        for (EndTickEvent event : events) {
            event.onEndTick(instance);
        }
    });

    @FunctionalInterface
    public interface EndTickEvent {
        void onEndTick(Minecraft client);
    }
}
