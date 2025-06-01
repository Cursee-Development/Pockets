package com.cursee.pockets;

import com.cursee.pockets.core.event.AnvilEvents;
import net.minecraft.resources.ResourceLocation;

public class Pockets {

    public static void init() {
        AnvilEvents.ON_LAND.register(anvilBlock -> {
            System.out.println("Landed");
        });
    }

    public static ResourceLocation identifier(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }
}