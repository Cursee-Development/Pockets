package com.cursee.pockets;

import com.cursee.pockets.client.event.ClientEvents;
import com.cursee.pockets.client.event.ScreenEvents;

// Registers to events

public class PocketsClient {

    public static void init() {

        ScreenEvents.PRE_SCREEN_INIT.register(screen -> {
            Constants.LOG.info("PreScreenInitEvent: {}", screen.getClass().getSimpleName());
        });

        ScreenEvents.POST_SCREEN_INIT.register(screen -> {
            Constants.LOG.info("PostScreenInitEvent: {}", screen.getClass().getSimpleName());
        });

        // console log spam
//        ScreenEvents.RENDER_SCREEN.register(screen -> {
//            Constants.LOG.info("RenderScreenEvent: {}", screen.getClass().getSimpleName());
//        });

        ScreenEvents.ON_CLICK.register(screen -> {
            Constants.LOG.info("OnClickEvent: {}", screen.getClass().getSimpleName());
        });

        // console log spam
//        ClientEvents.START_CLIENT_TICK.register(instance -> {
//            Constants.LOG.info("StartTickEvent");
//        });

        // console log spam
//        ClientEvents.END_CLIENT_TICK.register(instance -> {
//            Constants.LOG.info("EndTickEvent");
//        });
        
    }
}
