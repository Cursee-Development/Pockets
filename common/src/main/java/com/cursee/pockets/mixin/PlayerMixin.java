package com.cursee.pockets.mixin;

import com.cursee.pockets.core.event.EquipLeggingEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class PlayerMixin {

    // @Shadow @Final private int slot;

//    @Inject(method = "set", at = @At("TAIL"))
//    private void pockets$mayPickup(ItemStack stack, CallbackInfo ci) {
//        Slot slot = (Slot) (Object) this;
//        if (!(slot.getItem().getItem() instanceof ArmorItem armorItem) || armorItem.getSlot() != EquipmentSlot.LEGS) return;
//
//        EquipLeggingEvents.ON_EQUIP.invoker().onEquip(player);
//    }

//    @Inject(method = "equipEventAndSound", at = @At("HEAD"))
//    private void pockets$setItemSlot(ItemStack equippedItem, CallbackInfo ci) {
//        System.out.println("setItemSlot nothing");
//
//        LivingEntity entity = (LivingEntity) (Object) this;
//
//        if (!(entity instanceof Player player)) return;
//
//        EquipLeggingEvents.ON_EQUIP.invoker().onEquip(player);
//    }

    @Unique
    private boolean pockets$hasRun = false;

    @Inject(method = "tick", at = @At("HEAD"))
    private void pockets$setItemSlot(CallbackInfo ci) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if ((!(entity instanceof Player player) || !player.hasItemInSlot(EquipmentSlot.LEGS))) {

            if (pockets$hasRun) pockets$hasRun = false;

            return;
        }

        if (!pockets$hasRun) {
            EquipLeggingEvents.ON_EQUIP.invoker().onEquip(player);
            System.out.println("invoked registered onEquip events");
            pockets$hasRun = true;
        }
    }
}
