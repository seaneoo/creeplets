package dev.seano.creeplets;

import net.fabricmc.api.ClientModInitializer;

public class CreepletsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		Creeplets.LOGGER.info("Initializing Creeplets (Client)");
	}
}
