package dev.seano.creeplets.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

	public final ForgeConfigSpec.DoubleValue creepletMovementSpeed;

	public final ForgeConfigSpec.DoubleValue creepletMaxHealth;

	public final ForgeConfigSpec.IntValue creepletSwell;

	public final ForgeConfigSpec.IntValue creepletExplosionRadius;

	public CommonConfig(final ForgeConfigSpec.Builder builder) {
		creepletMovementSpeed = builder.comment(
				"The movement speed of the Creeplet. Default for a Creeper is \"0.25\".")
			.defineInRange("creepletMovementSpeed", 0.5d, Double.MIN_VALUE, Double.MAX_VALUE);
		creepletMaxHealth = builder.comment("The max health of the Creeplet. Default for a Creeper is \"20\".")
			.defineInRange("creepletMaxHealth", 10d, Double.MIN_VALUE, Double.MAX_VALUE);
		creepletSwell = builder.comment("How fast the Creeplet explodes. Default for a Creeper is \"30\".")
			.defineInRange("creepletSwell", 10, Integer.MIN_VALUE, Integer.MAX_VALUE);
		creepletExplosionRadius = builder.comment(
				"The radius of the Creeplet's explosion. Default for a Creeper is \"3\".")
			.defineInRange("creepletExplosionRadius", 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
