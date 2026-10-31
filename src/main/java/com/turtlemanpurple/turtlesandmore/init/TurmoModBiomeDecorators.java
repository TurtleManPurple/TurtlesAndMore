/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import com.turtlemanpurple.turtlesandmore.world.features.treedecorators.TurtleLandsTrunkDecorator;
import com.turtlemanpurple.turtlesandmore.world.features.treedecorators.TurtleLandsLeaveDecorator;
import com.turtlemanpurple.turtlesandmore.TurmoMod;

public class TurmoModBiomeDecorators {
	public static void load() {
		register("turtle_lands_tree_leave_decorator", TurtleLandsLeaveDecorator.DECORATOR_TYPE);
		register("turtle_lands_tree_trunk_decorator", TurtleLandsTrunkDecorator.DECORATOR_TYPE);
	}

	private static void register(String registryname, TreeDecoratorType<?> treeDecoratorType) {
		Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, Identifier.fromNamespaceAndPath(TurmoMod.MODID, registryname), treeDecoratorType);
	}
}