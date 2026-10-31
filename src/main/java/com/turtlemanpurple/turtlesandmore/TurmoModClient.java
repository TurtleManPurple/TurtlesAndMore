package com.turtlemanpurple.turtlesandmore;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

import com.turtlemanpurple.turtlesandmore.init.TurmoModKeyMappings;
import com.turtlemanpurple.turtlesandmore.init.TurmoModArmorModels;

@Environment(EnvType.CLIENT)
public class TurmoModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		TurmoModArmorModels.clientLoad();
		TurmoModKeyMappings.clientLoad();
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}