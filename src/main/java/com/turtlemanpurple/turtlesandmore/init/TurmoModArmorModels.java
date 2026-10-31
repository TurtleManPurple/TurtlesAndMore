/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.HumanoidModel;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.Map;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;

import com.turtlemanpurple.turtlesandmore.client.renderer.item.TurtleArmorArmor;

@Environment(EnvType.CLIENT)
public class TurmoModArmorModels {
	public static Map<Item, ArmorModel> ARMOR_MODELS = new Reference2ObjectOpenHashMap<>();

	public static interface ArmorModel {
		default Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
			return original;
		}

		@Nullable
		default Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
			return null;
		}

		default Model getGenericArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
			Model replacement = getHumanoidArmorModel(itemStack, layerType, original);
			if (replacement != original) {
				if (original instanceof HumanoidModel<?> originalHumanoid && replacement instanceof HumanoidModel<?> replacementHumanoid) {
					copyModelPartProperties(originalHumanoid.head, replacementHumanoid.head);
					copyModelPartProperties(originalHumanoid.hat, replacementHumanoid.hat);
					copyModelPartProperties(originalHumanoid.body, replacementHumanoid.body);
					copyModelPartProperties(originalHumanoid.rightArm, replacementHumanoid.rightArm);
					copyModelPartProperties(originalHumanoid.leftArm, replacementHumanoid.leftArm);
					copyModelPartProperties(originalHumanoid.rightLeg, replacementHumanoid.rightLeg);
					copyModelPartProperties(originalHumanoid.leftLeg, replacementHumanoid.leftLeg);
				}
				return replacement;
			}
			return original;
		}

		private void copyModelPartProperties(ModelPart original, ModelPart replacement) {
			replacement.visible = original.visible;
			replacement.x = original.x;
			replacement.y = original.y;
			replacement.z = original.z;
			replacement.xRot = original.xRot;
			replacement.yRot = original.yRot;
			replacement.zRot = original.zRot;
			replacement.xScale = original.xScale;
			replacement.yScale = original.yScale;
			replacement.zScale = original.zScale;
		}
	}

	public static void clientLoad() {
		TurtleArmorArmor.clientLoad();
	}
}