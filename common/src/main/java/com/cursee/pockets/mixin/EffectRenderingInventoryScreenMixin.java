package com.cursee.pockets.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerScreen.class)
public class EffectRenderingInventoryScreenMixin {

    @Shadow
    protected int topPos;
    @Shadow
    protected int leftPos;
    @Shadow
    protected int imageWidth;
    @Shadow
    protected int imageHeight;

    @Unique
    private static final ResourceLocation INVENTORY_LOCATION = new ResourceLocation("textures/gui/container/inventory.png");

    @Inject(method = "render", at = @At("TAIL"))
    private void pockets$render(PoseStack poseStack, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        EffectRenderingInventoryScreen screen = (EffectRenderingInventoryScreen) (Object) this;
        if (!(screen instanceof InventoryScreen) && !(screen instanceof CreativeModeInventoryScreen)) return;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, INVENTORY_LOCATION);
        int i = leftPos;
        int j = topPos;
        screen.blit(poseStack, i + 20, j + 20, 0, 0, imageWidth, imageHeight);
    }
}
