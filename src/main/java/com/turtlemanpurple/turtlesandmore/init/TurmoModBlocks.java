/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

import com.turtlemanpurple.turtlesandmore.block.*;
import com.turtlemanpurple.turtlesandmore.TurmoMod;

public class TurmoModBlocks {
	public static Block TURTLE_ORE;
	public static Block DEEPSLATE_TURTLE_ORE;
	public static Block TURTLE_STONE;
	public static Block SHELL_TILE;
	public static Block AQUA_GLASS;
	public static Block GLOW_ALGAE;
	public static Block CORAL_COLUMN;
	public static Block MYSTIC_SAND;
	public static Block WATERFALL_BLOCK;

	public static void load() {
		TURTLE_ORE = register("turtle_ore", TurtleOreBlock::new);
		DEEPSLATE_TURTLE_ORE = register("deepslate_turtle_ore", DeepslateTurtleOreBlock::new);
		TURTLE_STONE = register("turtle_stone", TurtleStoneBlock::new);
		SHELL_TILE = register("shell_tile", ShellTileBlock::new);
		AQUA_GLASS = register("aqua_glass", AquaGlassBlock::new);
		GLOW_ALGAE = register("glow_algae", GlowAlgaeBlock::new);
		CORAL_COLUMN = register("coral_column", CoralColumnBlock::new);
		MYSTIC_SAND = register("mystic_sand", MysticSandBlock::new);
		WATERFALL_BLOCK = register("waterfall_block", WaterfallBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TurmoMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}