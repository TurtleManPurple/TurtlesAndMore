/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

import com.turtlemanpurple.turtlesandmore.network.TestMobBindingMessage;

public class TurmoModKeyMappingsServer {
	public static void serverLoad() {
		PayloadTypeRegistry.serverboundPlay().register(TestMobBindingMessage.TYPE, TestMobBindingMessage.STREAM_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(TestMobBindingMessage.TYPE, TestMobBindingMessage::handleData);
	}
}