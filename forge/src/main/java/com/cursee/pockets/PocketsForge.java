package com.cursee.pockets;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Constants.MOD_ID)
public class PocketsForge {

    public static IEventBus EVENT_BUS;

    public PocketsForge(FMLJavaModLoadingContext context) {
        Pockets.init();
        EVENT_BUS = context.getModEventBus();
        if (FMLEnvironment.dist == Dist.CLIENT) new PocketsClientForge(EVENT_BUS);
    }

    @SuppressWarnings("removal")
    public PocketsForge() {
        this(FMLJavaModLoadingContext.get());
    }
}