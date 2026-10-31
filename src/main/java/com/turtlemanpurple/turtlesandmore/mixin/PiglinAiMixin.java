package com.turtlemanpurple.turtlesandmore.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.EquipmentSlot;

import com.turtlemanpurple.turtlesandmore.item.TurtleArmorItem;

@Mixin(PiglinAi.class)
public abstract class PiglinAiMixin {
	@Inject(method = "isWearingSafeArmor(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
	private static void isWearingSafeArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
		for (EquipmentSlot equipmentslot : EquipmentSlotGroup.ARMOR) {
			if (entity.getItemBySlot(equipmentslot).getItem() instanceof TurtleArmorItem.Helmet helmet)
				if (helmet.makesPiglinsNeutral(entity.getItemBySlot(equipmentslot), entity))
					cir.setReturnValue(true);
			if (entity.getItemBySlot(equipmentslot).getItem() instanceof TurtleArmorItem.Chestplate chestplate)
				if (chestplate.makesPiglinsNeutral(entity.getItemBySlot(equipmentslot), entity))
					cir.setReturnValue(true);
			if (entity.getItemBySlot(equipmentslot).getItem() instanceof TurtleArmorItem.Leggings leggings)
				if (leggings.makesPiglinsNeutral(entity.getItemBySlot(equipmentslot), entity))
					cir.setReturnValue(true);
			if (entity.getItemBySlot(equipmentslot).getItem() instanceof TurtleArmorItem.Boots boots)
				if (boots.makesPiglinsNeutral(entity.getItemBySlot(equipmentslot), entity))
					cir.setReturnValue(true);
		}
	}
}