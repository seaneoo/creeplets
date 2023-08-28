package dev.seano.creeplets.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class CreepletEntity extends CreeperEntity {
    public CreepletEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
}
