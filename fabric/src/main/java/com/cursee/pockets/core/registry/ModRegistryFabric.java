package com.cursee.pockets.core.registry;

import com.cursee.pockets.core.registry.ModBlocks;
import com.cursee.pockets.core.registry.ModItems;
import net.minecraft.core.Registry;
// import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public class ModRegistryFabric {

    public static void register() {
        ModBlocks.register(bind(Registry.BLOCK));
        ModItems.register(bind(Registry.ITEM));
    }

    private static <T> BiConsumer<T, ResourceLocation> bind(Registry<? super T> registry) {
        return (t, id) -> Registry.register(registry, id, t);
    }
}
