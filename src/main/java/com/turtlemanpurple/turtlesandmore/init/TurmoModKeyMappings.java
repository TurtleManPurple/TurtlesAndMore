/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import com.turtlemanpurple.turtlesandmore.network.TestMobBindingMessage;

import com.mojang.blaze3d.platform.InputConstants;

@Environment(EnvType.CLIENT)
public class TurmoModKeyMappings {
	public static final KeyMapping TEST_MOB_BINDING = new KeyMapping("key.turmo.test_mob_binding",

			InputConstants.KEY_F7, KeyMapping.Category.CREATIVE) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPlayNetworking.send(new TestMobBindingMessage(0, 0));
				TestMobBindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	public static void clientLoad() {
		KeyMappingHelper.registerKeyMapping(TEST_MOB_BINDING);
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			if (client.gui.screen() == null) {
				TEST_MOB_BINDING.consumeClick();
			}
		});
	}
}