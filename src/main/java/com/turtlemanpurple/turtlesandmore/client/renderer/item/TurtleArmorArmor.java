package com.turtlemanpurple.turtlesandmore.client.renderer.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import com.turtlemanpurple.turtlesandmore.init.TurmoModItems;
import com.turtlemanpurple.turtlesandmore.init.TurmoModArmorModels;

@Environment(EnvType.CLIENT)
public class TurtleArmorArmor {
	public static void clientLoad() {
		TurmoModArmorModels.ARMOR_MODELS.put(TurmoModItems.TURTLE_ARMOR_HELMET, new TurmoModArmorModels.ArmorModel() {
			private final Identifier armorTexture = Identifier.parse("turmo:textures/entity/equipment/humanoid/custom_armor_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		});
		TurmoModArmorModels.ARMOR_MODELS.put(TurmoModItems.TURTLE_ARMOR_CHESTPLATE, new TurmoModArmorModels.ArmorModel() {
			private final Identifier armorTexture = Identifier.parse("turmo:textures/entity/equipment/humanoid/custom_armor_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		});
		TurmoModArmorModels.ARMOR_MODELS.put(TurmoModItems.TURTLE_ARMOR_LEGGINGS, new TurmoModArmorModels.ArmorModel() {
			private final Identifier armorTexture = Identifier.parse("turmo:textures/entity/equipment/humanoid_leggings/custom_armor_layer_2.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		});
		TurmoModArmorModels.ARMOR_MODELS.put(TurmoModItems.TURTLE_ARMOR_BOOTS, new TurmoModArmorModels.ArmorModel() {
			private final Identifier armorTexture = Identifier.parse("turmo:textures/entity/equipment/humanoid/custom_armor_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		});
	}
}