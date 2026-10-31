package com.turtlemanpurple.turtlesandmore.network;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import com.turtlemanpurple.turtlesandmore.procedures.TestMobProcedureProcedure;
import com.turtlemanpurple.turtlesandmore.TurmoMod;

public record TestMobBindingMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<TestMobBindingMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(TurmoMod.MODID, "key_test_mob_binding"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TestMobBindingMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TestMobBindingMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new TestMobBindingMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TestMobBindingMessage> type() {
		return TYPE;
	}

	public static void handleData(final TestMobBindingMessage message, final ServerPlayNetworking.Context context) {
		context.server().execute(() -> {
			pressAction(context.player(), message.eventType, message.pressedms);
		});
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (type == 0) {
			TestMobProcedureProcedure.execute(entity);
		}
	}
}