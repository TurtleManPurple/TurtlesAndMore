package com.turtlemanpurple.turtlesandmore.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.item.ItemInput;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GiveItemProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entityiterator instanceof Player _player) {
					ItemStack _setstack = (commandParameterItemStack(arguments, "item")).copy();
					_setstack.setCount((int) DoubleArgumentType.getDouble(arguments, "count"));
					_player.addItem(_setstack);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}

	private static ItemStack commandParameterItemStack(CommandContext<CommandSourceStack> arguments, String parameter) {
		ItemInput input = ItemArgument.getItem(arguments, parameter);
		try {
			return input.createItemStack(1);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return input.item().value().getDefaultInstance();
		}
	}
}