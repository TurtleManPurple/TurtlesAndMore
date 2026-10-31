package com.turtlemanpurple.turtlesandmore.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import com.turtlemanpurple.turtlesandmore.procedures.TurtleHammerEntitySwingsItemProcedure;

public class TurtleHammerItem extends Item {
	public TurtleHammerItem(Item.Properties properties) {
		super(properties.stacksTo(1).fireResistant());
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		TurtleHammerEntitySwingsItemProcedure.execute(entity);
		return ar;
	}
}