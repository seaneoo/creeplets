package dev.seano.creeplets;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;

public class Entities {

	public static final String CREEPLET_ID = "creeplet";

	public static final EntityType<CreepletEntity> CREEPLET = Registry.register(Registries.ENTITY_TYPE,
		Creeplets.id(CREEPLET_ID), FabricEntityType.Builder.createMob(CreepletEntity::new, SpawnGroup.MONSTER,
			(mob) -> mob.spawnRestriction(SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark)).dimensions(0.3f, 0.85f).build());

	public static void init() {
		Creeplets.LOGGER.info("Initializing entities");

		FabricDefaultAttributeRegistry.register(CREEPLET, CreepletEntity.createAttributes());
	}
}
