package com.turtlemanpurple.turtlesandmore.mixin;

import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.model.Model;

import com.turtlemanpurple.turtlesandmore.init.TurmoModArmorModels;

import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(EquipmentLayerRenderer.class)
public abstract class EquipmentLayerRendererMixin {
	@ModifyVariable(method = "renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/resources/Identifier;II)V", at = @At("HEAD"), argsOnly = true)
	public <S> Model<? super S> renderLayers(Model<? super S> model, EquipmentClientInfo.LayerType layerType, ResourceKey<EquipmentAsset> resourceKey, Model<? super S> originalModel, S state, ItemStack itemStack, PoseStack poseStack,
			SubmitNodeCollector submitNodeCollector, int lightCoords, @Nullable Identifier playerTextureOverride, int outlineColor, int order) {
		if (!TurmoModArmorModels.ARMOR_MODELS.containsKey(itemStack.getItem()) || layerType == EquipmentClientInfo.LayerType.WINGS)
			return model;
		TurmoModArmorModels.ArmorModel armorModel = TurmoModArmorModels.ARMOR_MODELS.get(itemStack.getItem());
		if (armorModel.getHumanoidArmorModel(itemStack, layerType, model) != null)
			return armorModel.getGenericArmorModel(itemStack, layerType, model);
		return model;
	}
}