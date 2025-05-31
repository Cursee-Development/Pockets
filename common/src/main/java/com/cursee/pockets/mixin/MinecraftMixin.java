package com.cursee.pockets.mixin;

import com.cursee.pockets.Constants;
import com.cursee.pockets.client.event.ClientEvents;
import com.cursee.pockets.platform.Services;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    private void onStartTick(CallbackInfo info) {
        Minecraft minecraft = (Minecraft) (Object) this;
        ClientEvents.START_CLIENT_TICK.invoker().onStartTick(minecraft);
    }

    @Inject(at = @At("RETURN"), method = "tick")
    private void onEndTick(CallbackInfo info) {
        Minecraft minecraft = (Minecraft) (Object) this;
        ClientEvents.END_CLIENT_TICK.invoker().onEndTick(minecraft);
    }

    /// example/placeholder from the template
//    @Inject(at = @At("TAIL"), method = "<init>")
//    private void init(CallbackInfo info) {
//
//        if (Services.PLATFORM.isDevelopmentEnvironment()) {
//            Constants.LOG.info("This line is printed by an example mod common mixin!");
//            Constants.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
//        }
//    }
}