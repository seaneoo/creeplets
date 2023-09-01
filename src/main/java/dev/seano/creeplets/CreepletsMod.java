package dev.seano.creeplets;

import dev.seano.creeplets.registry.ModEntities;
import dev.seano.creeplets.registry.ModItems;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreepletsMod implements ModInitializer {
    public static final String MOD_ID = "creeplets";

    public static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(MOD_ID);
    }

    @Override
    public void onInitialize() {
        MidnightConfig.init(MOD_ID, CreepletsConfig.class);

        ModEntities.register();
        ModItems.register();
    }

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }
}
