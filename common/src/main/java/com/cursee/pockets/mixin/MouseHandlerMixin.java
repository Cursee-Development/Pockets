package com.cursee.pockets.mixin;

import com.cursee.pockets.client.event.ScreenEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {

    @Inject(method = "onPress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;afterMouseAction()V"))
    private void pockets$onPress(long windowPointer, int button, int action, int modifiers, CallbackInfo ci) {
        Screen screen = Minecraft.getInstance().screen;
        if (screen == null) return;
        ScreenEvents.ON_CLICK.invoker().onClick(screen);
    }
}
