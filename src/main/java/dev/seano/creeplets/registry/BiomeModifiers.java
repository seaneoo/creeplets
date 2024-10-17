package dev.seano.creeplets.registry;

import com.mojang.serialization.Codec;
import dev.seano.creeplets.CreepletsMod;
import dev.seano.creeplets.world.AddCreepletBiomeModifier;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BiomeModifiers {

	public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_REGISTER = DeferredRegister.create(
		ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CreepletsMod.MOD_ID);

	public static RegistryObject<Codec<AddCreepletBiomeModifier>> ADD_CREEPLET_CODEC = BIOME_MODIFIER_REGISTER.register(
		"add_creeplet", () -> Codec.unit(AddCreepletBiomeModifier::new));

	public static void register(IEventBus eventBus) {
		CreepletsMod.LOGGER.debug("Registering biome modifiers");
		BIOME_MODIFIER_REGISTER.register(eventBus);
	}
}
