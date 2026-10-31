package com.turtlemanpurple.turtlesandmore.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Holder;

import com.turtlemanpurple.turtlesandmore.init.TurmoModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements TurmoModBiomes.TurmoModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> turmo_dimensionTypeReference;
	@Unique
	private HolderGetter<MaterialRule> turmo_materialRuleLookup;

	@WrapMethod(method = "materialRule")
	public Holder<MaterialRule> materialRule(Operation<Holder<MaterialRule>> original) {
		Holder<MaterialRule> retval = original.call();
		if (this.turmo_dimensionTypeReference != null) {
			retval = Holder.direct(TurmoModBiomes.adaptMaterialRule(retval.value(), this.turmo_dimensionTypeReference, this.turmo_materialRuleLookup));
		}
		return retval;
	}

	@Override
	public void setturmoReferences(Holder<DimensionType> dimensionType, HolderGetter<MaterialRule> materialRules) {
		this.turmo_dimensionTypeReference = dimensionType;
		this.turmo_materialRuleLookup = materialRules;
	}
}