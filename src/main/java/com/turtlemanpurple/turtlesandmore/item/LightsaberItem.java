package com.turtlemanpurple.turtlesandmore.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class LightsaberItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 99999, 99999f, 0, 99999, TagKey.create(Registries.ITEM, Identifier.parse("turmo:lightsaber_repair_items")));

	public LightsaberItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 99998f, 95f).fireResistant());
	}
}