package com.turtlemanpurple.turtlesandmore.item;

import net.minecraft.world.item.Item;

public class TurtleShardItem extends Item {
	public TurtleShardItem(Item.Properties properties) {
		super(properties.fireResistant());
	}
}