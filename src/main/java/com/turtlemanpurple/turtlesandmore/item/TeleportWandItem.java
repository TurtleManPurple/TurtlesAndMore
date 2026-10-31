package com.turtlemanpurple.turtlesandmore.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import com.turtlemanpurple.turtlesandmore.procedures.TeleportWandRightclickedProcedure;

public class TeleportWandItem extends Item {
	public TeleportWandItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		TeleportWandRightclickedProcedure.execute(entity);
		return ar;
	}
}