package dev.seano.creeplets;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Creeplets.MOD_ID)
public class Creeplets {

	public static final String MOD_ID = "creeplets";

	private static final Logger LOGGER = LogUtils.getLogger();

	public Creeplets() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info("Creeplets::commonSetup");
	}
}
