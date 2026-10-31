package com.turtlemanpurple.turtlesandmore.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class TurtlePickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 99999, 100f, 0, 2, TagKey.create(Registries.ITEM, Identifier.parse("turmo:turtle_pickaxe_repair_items")));

	public TurtlePickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 99f, -3f).fireResistant());
	}
}