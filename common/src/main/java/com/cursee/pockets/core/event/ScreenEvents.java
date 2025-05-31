package com.cursee.pockets.core.event;

import com.cursee.pockets.core.util.event.Event;
import com.cursee.pockets.core.util.event.EventFactory;
import net.minecraft.client.gui.screens.Screen;

public class ScreenEvents {

    public static final Event<PreScreenInitEvent> PRE_SCREEN_INIT = EventFactory.createArrayBacked(PreScreenInitEvent.class, events -> screen -> {
        for (PreScreenInitEvent event : events) {
            event.onPreScreenInit(screen);
        }
    });

    @FunctionalInterface
    public interface PreScreenInitEvent {
        void onPreScreenInit(Screen screen);
    }

    public static final Event<PostScreenInitEvent> POST_SCREEN_INIT = EventFactory.createArrayBacked(PostScreenInitEvent.class, events -> screen -> {
        for (PostScreenInitEvent event : events) {
            event.onPostScreenInit(screen);
        }
    });

    @FunctionalInterface
    public interface PostScreenInitEvent {
        void onPostScreenInit(Screen screen);
    }

    public static final Event<RenderScreenEvent> RENDER_SCREEN = EventFactory.createArrayBacked(RenderScreenEvent.class, events -> screen -> {
        for (RenderScreenEvent event : events) {
            event.onRenderScreen(screen);
        }
    });

    @FunctionalInterface
    public interface RenderScreenEvent {
        void onRenderScreen(Screen screen);
    }

    public static final Event<OnClickEvent> ON_CLICK = EventFactory.createArrayBacked(OnClickEvent.class, events -> screen -> {
        for (OnClickEvent event : events) {
            event.onClick(screen);
        }
    });

    @FunctionalInterface
    public interface OnClickEvent {
        void onClick(Screen screen);
    }
}
