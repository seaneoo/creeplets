package dev.seano.creeplets;

import com.mojang.logging.LogUtils;
import dev.seano.creeplets.client.CreepletRenderer;
import dev.seano.creeplets.config.ConfigHolder;
import dev.seano.creeplets.config.CreepletsConfig;
import dev.seano.creeplets.registry.BiomeModifiers;
import dev.seano.creeplets.registry.Entities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreepletsMod.MOD_ID)
public class CreepletsMod {

	public static final String MOD_ID = "creeplets";

	public static final Logger LOGGER = LogUtils.getLogger();

	public CreepletsMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::onModConfigEvent);

		Entities.register(modEventBus);
		BiomeModifiers.register(modEventBus);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHolder.CONFIG_SPEC, "creeplets.toml");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onModConfigEvent(ModConfigEvent event) {
		ModConfig modConfig = event.getConfig();
		if (modConfig.getSpec() == ConfigHolder.CONFIG_SPEC) CreepletsConfig.bake();
	}

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientEvents {

		@SubscribeEvent
		public static void onClientSetup(final FMLClientSetupEvent event) {
			EntityRenderers.register(Entities.CREEPLET.get(), CreepletRenderer::new);
		}
	}
}
