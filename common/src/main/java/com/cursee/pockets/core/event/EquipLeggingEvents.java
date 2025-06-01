package com.cursee.pockets.core.event;

import com.cursee.pockets.core.util.event.Event;
import com.cursee.pockets.core.util.event.EventFactory;
import net.minecraft.world.entity.player.Player;

public class EquipLeggingEvents {
    public static final Event<OnEquipEvent> ON_EQUIP = EventFactory.createArrayBacked(OnEquipEvent.class, events -> player -> {
        for (OnEquipEvent event : events) {
            event.onEquip(player);
        }
    });

    @FunctionalInterface
    public interface OnEquipEvent {
        void onEquip(Player player);
    }
}
