package com.cursee.pockets;

import com.cursee.pockets.core.registry.ModRegistryFabric;
import net.fabricmc.api.ModInitializer;

public class PocketsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Pockets.init();
        ModRegistryFabric.register();
    }
}
