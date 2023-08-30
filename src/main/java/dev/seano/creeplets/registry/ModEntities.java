package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsMod;
import dev.seano.creeplets.entity.CreepletEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;

public class ModEntities {
    public static final EntityType<CreepletEntity> CREEPLET = Registry.register(Registries.ENTITY_TYPE, CreepletsMod.identifier("creeplet"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CreepletEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.85f)).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(ModEntities.CREEPLET, CreepletEntity.createCreeperAttributes());
        registerSpawns();
    }

    private static void registerSpawns() {
        SpawnRestriction.register(CREEPLET, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.CREEPER), SpawnGroup.MONSTER, CREEPLET, 100, 1, 2);
    }
}
