/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.function.Predicate;

import com.turtlemanpurple.turtlesandmore.block.TurtleOreBlock;
import com.turtlemanpurple.turtlesandmore.block.DeepslateTurtleOreBlock;
import com.turtlemanpurple.turtlesandmore.TurmoMod;

import com.mojang.serialization.MapCodec;

public class TurmoModFeatures {
	public static void load() {
		addToBiomes("turtle_ore", TurtleOreBlock.GENERATE_BIOMES, GenerationStep.Decoration.UNDERGROUND_ORES);
		addToBiomes("deepslate_turtle_ore", DeepslateTurtleOreBlock.GENERATE_BIOMES, GenerationStep.Decoration.UNDERGROUND_ORES);
		addToBiomes("turtle_tree", BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME, Identifier.parse("turmo:turtle_lands"))), GenerationStep.Decoration.SURFACE_STRUCTURES);
	}

	private static void addToBiomes(String registryname, Predicate<BiomeSelectionContext> biomes, GenerationStep.Decoration stage) {
		BiomeModifications.addFeature(biomes, stage, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(TurmoMod.MODID, registryname)));
	}

	private static void registerType(String registryname, MapCodec<? extends Feature> codec) {
		Registry.register(BuiltInRegistries.FEATURE_TYPE, Identifier.fromNamespaceAndPath(TurmoMod.MODID, registryname), codec);
	}
}