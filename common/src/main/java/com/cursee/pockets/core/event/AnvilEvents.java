package com.cursee.pockets.core.event;

import com.cursee.pockets.core.util.event.Event;
import com.cursee.pockets.core.util.event.EventFactory;
import net.minecraft.world.level.block.AnvilBlock;

public class AnvilEvents {
    public static final Event<OnLandEvent> ON_LAND = EventFactory.createArrayBacked(OnLandEvent.class, events -> anvilBlock -> {
        for (OnLandEvent event : events) {
            event.onLand(anvilBlock);
        }
    });

    @FunctionalInterface
    public interface OnLandEvent {
        void onLand(AnvilBlock anvilBlock);
    }
}
