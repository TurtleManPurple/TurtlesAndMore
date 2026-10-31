/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import com.turtlemanpurple.turtlesandmore.command.TestMobCommand;
import com.turtlemanpurple.turtlesandmore.command.GiveItemCommand;

public class TurmoModCommands {
	public static void load() {
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, environment) -> {
			TestMobCommand.register(dispatcher, commandBuildContext, environment);
			GiveItemCommand.register(dispatcher, commandBuildContext, environment);
		});
	}
}