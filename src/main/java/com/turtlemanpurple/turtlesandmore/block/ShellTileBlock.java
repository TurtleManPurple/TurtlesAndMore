package com.turtlemanpurple.turtlesandmore.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class ShellTileBlock extends Block {
	public ShellTileBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.DEEPSLATE_TILES).strength(1f, 10f));
	}
}