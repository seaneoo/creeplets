package dev.seano.creeplets.config;

import dev.seano.creeplets.CreepletsMod;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreepletsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreepletsConfig {

	public static double creepletMovementSpeed = 0.5d;

	public static double creepletMaxHealth = 10d;

	public static int creepletSwell = 10;

	public static int creepletExplosionRadius = 2;

	public static void bake() {
		try {
			creepletMovementSpeed = ConfigHolder.COMMON.creepletMovementSpeed.get();
			creepletMaxHealth = ConfigHolder.COMMON.creepletMaxHealth.get();
			creepletSwell = ConfigHolder.COMMON.creepletSwell.get();
			creepletExplosionRadius = ConfigHolder.COMMON.creepletExplosionRadius.get();
		} catch (Exception e) {
			CreepletsMod.LOGGER.warn("Could not bake config values; using default values.", e);
		}
	}
}
