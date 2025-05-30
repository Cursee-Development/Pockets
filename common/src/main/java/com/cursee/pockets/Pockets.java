package com.cursee.pockets;

import net.minecraft.resources.ResourceLocation;

public class Pockets {

    public static void init() {}

    public static ResourceLocation identifier(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }
}