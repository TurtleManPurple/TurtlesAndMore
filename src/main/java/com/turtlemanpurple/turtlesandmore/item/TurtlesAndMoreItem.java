package com.turtlemanpurple.turtlesandmore.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

import com.turtlemanpurple.turtlesandmore.procedures.TurtlesAndMoreItemIsCraftedSmeltedProcedure;

public class TurtlesAndMoreItem extends Item {
	public TurtlesAndMoreItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		TurtlesAndMoreItemIsCraftedSmeltedProcedure.execute(entity);
	}
}