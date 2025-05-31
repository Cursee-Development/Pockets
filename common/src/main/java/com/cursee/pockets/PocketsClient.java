package com.cursee.pockets;

import com.cursee.pockets.client.event.ScreenEvents;

public class PocketsClient {

    public static void init() {

        ScreenEvents.PRE_SCREEN_INIT.register(screen -> {
            Constants.LOG.info("PreScreenInitEvent: {}", screen.getClass().getSimpleName());
        });

        ScreenEvents.POST_SCREEN_INIT.register(screen -> {
            Constants.LOG.info("PostScreenInitEvent: {}", screen.getClass().getSimpleName());
        });

        ScreenEvents.ON_CLICK.register(screen -> {
            Constants.LOG.info("OnClickEvent: {}", screen.getClass().getSimpleName());
        });
    }
}
