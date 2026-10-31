package com.turtlemanpurple.turtlesandmore.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.turtlemanpurple.turtlesandmore.init.TurmoModItems;

public class TurtlesAndMoreItemIsCraftedSmeltedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(TurmoModItems.TURTLES_AND_MORE);
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 9999, _player.inventoryMenu.getCraftSlots());
		}
	}
}