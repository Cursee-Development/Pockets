package com.cursee.pockets.mixin;

import com.cursee.pockets.core.event.ScreenEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void pockets$render(float partialTicks, long nanoTime, boolean renderLevel, CallbackInfo ci) {
        Screen screen = Minecraft.getInstance().screen;
        if (screen == null) return;
        ScreenEvents.RENDER_SCREEN.invoker().onRenderScreen(screen);
    }
}
