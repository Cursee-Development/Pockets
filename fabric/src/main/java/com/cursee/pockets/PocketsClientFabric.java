package com.cursee.pockets;

import net.fabricmc.api.ClientModInitializer;

public class PocketsClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        PocketsClient.init();
    }
}
