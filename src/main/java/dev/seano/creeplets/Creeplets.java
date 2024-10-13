package dev.seano.creeplets;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Creeplets implements ModInitializer {

	public static final String MOD_ID = "creeplets";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Creeplets");

		Entities.init();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
