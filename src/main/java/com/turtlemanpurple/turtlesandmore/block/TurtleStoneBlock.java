package com.turtlemanpurple.turtlesandmore.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TurtleStoneBlock extends Block {
	public TurtleStoneBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f));
	}
}