package dev.seano.creeplets.registry;

import dev.seano.creeplets.Creeplets;
import dev.seano.creeplets.entity.CreepletEntity;
import dev.seano.creeplets.entity.UnstableTntEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;

public class Entities {

	public static final String CREEPLET_ID = "creeplet";

	public static final EntityType<CreepletEntity> CREEPLET = Registry.register(Registries.ENTITY_TYPE,
		Creeplets.id(CREEPLET_ID),
		FabricEntityType.Builder.createMob(CreepletEntity::new, SpawnGroup.MONSTER, (mob) -> mob)
			.dimensions(0.5f, 1.15f)
			.build());

	public static final EntityType<UnstableTntEntity> UNSTABLE_TNT = Registry.register(Registries.ENTITY_TYPE,
		Creeplets.id("unstable_tnt"),
		EntityType.Builder.<UnstableTntEntity>create(UnstableTntEntity::new, SpawnGroup.MISC).build());

	public static void init() {
		Creeplets.LOGGER.info("Initializing entities");

		FabricDefaultAttributeRegistry.register(CREEPLET, CreepletEntity.createAttributes());
		registerSpawns();
	}

	private static void registerSpawns() {
		Creeplets.LOGGER.info("Registering entity spawns");

		SpawnRestriction.register(CREEPLET, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
			HostileEntity::canSpawnInDark);
		BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.CREEPER), SpawnGroup.MONSTER, CREEPLET, 100,
			2, 3);
	}
}
