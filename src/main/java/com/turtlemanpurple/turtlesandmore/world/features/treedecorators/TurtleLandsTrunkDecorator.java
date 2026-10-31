package com.turtlemanpurple.turtlesandmore.world.features.treedecorators;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.turtlemanpurple.turtlesandmore.init.TurmoModBlocks;

import com.mojang.serialization.MapCodec;

public class TurtleLandsTrunkDecorator extends TrunkVineDecorator {
	public static MapCodec<TurtleLandsTrunkDecorator> CODEC = MapCodec.unit(TurtleLandsTrunkDecorator::new);
	public static TreeDecoratorType<?> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

	@Override
	protected TreeDecoratorType<?> type() {
		return DECORATOR_TYPE;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		context.logs().forEach(blockpos -> {
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.west();
				if (context.isAir(pos)) {
					context.setBlock(pos, oriented(TurmoModBlocks.GLOW_ALGAE.defaultBlockState(), Direction.EAST));
				}
			}
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.east();
				if (context.isAir(pos)) {
					context.setBlock(pos, oriented(TurmoModBlocks.GLOW_ALGAE.defaultBlockState(), Direction.WEST));
				}
			}
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.north();
				if (context.isAir(pos)) {
					context.setBlock(pos, oriented(TurmoModBlocks.GLOW_ALGAE.defaultBlockState(), Direction.SOUTH));
				}
			}
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.south();
				if (context.isAir(pos)) {
					context.setBlock(pos, oriented(TurmoModBlocks.GLOW_ALGAE.defaultBlockState(), Direction.NORTH));
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	private static BlockState oriented(BlockState blockstate, Direction direction) {
		return switch (direction) {
			case SOUTH -> blockstate.rotate(Rotation.CLOCKWISE_180);
			case EAST -> blockstate.rotate(Rotation.CLOCKWISE_90);
			case WEST -> blockstate.rotate(Rotation.COUNTERCLOCKWISE_90);
			default -> blockstate;
		};
	}
}