package dev.seano.creeplets;

import dev.seano.creeplets.registry.Blocks;
import dev.seano.creeplets.registry.Entities;
import dev.seano.creeplets.registry.Items;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Creeplets implements ModInitializer {

	public static final String MOD_ID = "creeplets";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static CreepletsConfig config;

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Creeplets");

		AutoConfig.register(CreepletsConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(CreepletsConfig.class).getConfig();

		Entities.init();
		Blocks.init();
		Items.init();
	}
}
