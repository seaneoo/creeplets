package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsConfig;
import dev.seano.creeplets.CreepletsMod;
import dev.seano.creeplets.entity.CreepletEntity;
import dev.seano.creeplets.entity.CreepletTntEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;

public class ModEntities {
    public static final EntityType<CreepletEntity> CREEPLET = register("creeplet",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CreepletEntity::new)
            .dimensions(EntityDimensions.fixed(0.3f, 0.85f)));
    public static final EntityType<CreepletTntEntity> CREEPLET_TNT = register("creeplet_tnt",
            FabricEntityTypeBuilder.<CreepletTntEntity>create(SpawnGroup.MISC,
                            CreepletTntEntity::new)
            .fireImmune().dimensions(EntityDimensions.fixed(1f, 1f)).trackRangeBlocks(10)
            .trackedUpdateRate(10));

    public static void init() {
        FabricDefaultAttributeRegistry.register(ModEntities.CREEPLET,
                CreepletEntity.createCreeperAttributes());
        registerSpawns();
    }

    private static <T extends Entity> EntityType<T> register(String key,
                                                             FabricEntityTypeBuilder<T> builder) {
        EntityType<T> entityType = builder.build();
        Registry.register(Registries.ENTITY_TYPE, CreepletsMod.identifier(key), entityType);
        return entityType;
    }

    private static void registerSpawns() {
        SpawnRestriction.register(CREEPLET, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.CREEPER),
                SpawnGroup.MONSTER, CREEPLET, CreepletsConfig.spawnWeight, 1, 2);
    }
}
