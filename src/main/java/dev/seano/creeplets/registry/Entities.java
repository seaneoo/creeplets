package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsMod;
import dev.seano.creeplets.entity.Creeplet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES;

public class Entities {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_REGISTER = DeferredRegister.create(ENTITY_TYPES,
		CreepletsMod.MOD_ID);

	public static final RegistryObject<EntityType<Creeplet>> CREEPLET = ENTITY_TYPE_REGISTER.register("creeplet",
		() -> EntityType.Builder.of(Creeplet::new, MobCategory.MONSTER).sized(0.5f, 1.15f).build("creeplet"));

	public static void register(IEventBus eventBus) {
		CreepletsMod.LOGGER.debug("Registering entities");
		ENTITY_TYPE_REGISTER.register(eventBus);
	}
}
