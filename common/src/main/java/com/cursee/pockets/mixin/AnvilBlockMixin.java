package com.cursee.pockets.mixin;

import com.cursee.pockets.core.event.AnvilEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilBlock.class)
public class AnvilBlockMixin {

    @Inject(method = "onLand", at = @At("TAIL"))
    private void pockets$onLand(Level level, BlockPos pos, BlockState state, BlockState replaceableState, FallingBlockEntity fallingBlock, CallbackInfo ci) {
        AnvilBlock anvilBlock = (AnvilBlock) (Object) this;
        AnvilEvents.ON_LAND.invoker().onLand(anvilBlock);
    }
}
