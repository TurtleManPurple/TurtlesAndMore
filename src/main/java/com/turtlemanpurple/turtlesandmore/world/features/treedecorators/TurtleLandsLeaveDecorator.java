package com.turtlemanpurple.turtlesandmore.world.features.treedecorators;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.turtlemanpurple.turtlesandmore.init.TurmoModBlocks;

import com.mojang.serialization.MapCodec;

public class TurtleLandsLeaveDecorator extends LeaveVineDecorator {
	public static MapCodec<TurtleLandsLeaveDecorator> CODEC = MapCodec.unit(TurtleLandsLeaveDecorator::new);
	public static TreeDecoratorType<?> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

	public TurtleLandsLeaveDecorator() {
		super(0.25f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return DECORATOR_TYPE;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		context.leaves().forEach((blockpos) -> {
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.west();
				if (context.isAir(pos)) {
					addVine(pos, Direction.WEST, context);
				}
			}
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.east();
				if (context.isAir(pos)) {
					addVine(pos, Direction.EAST, context);
				}
			}
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.north();
				if (context.isAir(pos)) {
					addVine(pos, Direction.NORTH, context);
				}
			}
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.south();
				if (context.isAir(pos)) {
					addVine(pos, Direction.SOUTH, context);
				}
			}
		});
	}

	private static void addVine(BlockPos pos, Direction direction, TreeDecorator.Context context) {
		context.setBlock(pos, TurmoModBlocks.GLOW_ALGAE.defaultBlockState());
		int i = 4;
		for (BlockPos blockpos = pos.below(); context.isAir(blockpos) && i > 0; --i) {
			context.setBlock(blockpos, oriented(TurmoModBlocks.GLOW_ALGAE.defaultBlockState(), direction));
			blockpos = blockpos.below();
		}
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