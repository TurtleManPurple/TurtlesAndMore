/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Holder;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;

import com.turtlemanpurple.turtlesandmore.TurmoMod;

import com.mojang.datafixers.util.Pair;

public class TurmoModBiomes {
	public static final Identifier OVERWORLD_BIOMESOURCE_PRESET_ID = Identifier.withDefaultNamespace("overworld");
	public static final Identifier NETHER_BIOMESOURCE_PRESET_ID = Identifier.withDefaultNamespace("nether");
	private static boolean BOOTSTRAP_VALIDATION_PASSED = false;

	public static void load() {
		BOOTSTRAP_VALIDATION_PASSED = true;
		ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
			HolderGetter<MaterialRule> materialRules = server.registryAccess().lookupOrThrow(Registries.MATERIAL_RULE);
			Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().lookupOrThrow(Registries.LEVEL_STEM);
			for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
				Holder<DimensionType> dimensionType = levelStem.type();
				if (dimensionType.is(BuiltinDimensionTypes.NETHER) || dimensionType.is(BuiltinDimensionTypes.OVERWORLD)) {
					if (levelStem.generator() instanceof NoiseBasedChunkGenerator noiseGenerator) {
						if ((Object) noiseGenerator.generatorSettings().value() instanceof TurmoModNoiseGeneratorSettings settings) {
							settings.setturmoReferences(dimensionType, materialRules);
						} else {
							TurmoMod.LOGGER.error("NoiseGeneratorSettings mixin of turmo was not applied, custom biomes may not generate properly");
						}
					}
				}
			}
		});
	}

	public static MaterialRule adaptMaterialRule(MaterialRule currentRuleSource, Holder<DimensionType> dimensionType, HolderGetter<MaterialRule> materialRules) {
		List<MaterialRule> customMaterialRules = new ArrayList<>();
		if (dimensionType.is(BuiltinDimensionTypes.OVERWORLD)) {
			customMaterialRules.add(MaterialRules.getRule(materialRules, ResourceKey.create(Registries.MATERIAL_RULE, Identifier.fromNamespaceAndPath("turmo", "turtle_lands_surface"))));
		}
		if (customMaterialRules.isEmpty())
			return currentRuleSource;
		customMaterialRules.add(currentRuleSource);
		return MaterialRules.sequence(customMaterialRules);
	}

	public static <T> Climate.ParameterList<T> adaptPresetParameterList(Identifier idArg, Climate.ParameterList<T> originalList, Function<ResourceKey<Biome>, T> lookup) {
		if (!BOOTSTRAP_VALIDATION_PASSED)
			return originalList;
		if (idArg.equals(OVERWORLD_BIOMESOURCE_PRESET_ID))
			return TurmoModBiomes.modifyOverworldParameterPoints(originalList, lookup);
		return originalList;
	}

	public static <T> Climate.ParameterList<T> modifyOverworldParameterPoints(Climate.ParameterList<T> originalList, Function<ResourceKey<Biome>, T> lookup) {
		List<Pair<Climate.ParameterPoint, T>> parameters = new ArrayList<>(originalList.values());
		parameters.add(new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.point(0.0f),
				Climate.Parameter.span(-1f, 1f), 0), lookup.apply(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("turmo", "turtle_lands")))));
		parameters.add(new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.point(1.0f),
				Climate.Parameter.span(-1f, 1f), 0), lookup.apply(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("turmo", "turtle_lands")))));
		return new Climate.ParameterList<>(parameters);
	}

	public interface TurmoModNoiseGeneratorSettings {
		void setturmoReferences(Holder<DimensionType> dimensionType, HolderGetter<MaterialRule> materialRules);
	}
}