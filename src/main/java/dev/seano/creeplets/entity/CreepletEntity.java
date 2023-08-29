package dev.seano.creeplets.entity;

import dev.seano.creeplets.mixin.CreeperEntityAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

@SuppressWarnings("FieldCanBeLocal")
public class CreepletEntity extends CreeperEntity {
    private static final float movementSpeed = 0.4f;
    private static final float health = 10;
    private final int fuseTime = 10;
    private final int explosionRadius = 1;

    public CreepletEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);

        ((CreeperEntityAccessor) this).setFuseTime(this.fuseTime);
        ((CreeperEntityAccessor) this).setExplosionRadius(this.explosionRadius);
    }

    public static DefaultAttributeContainer.Builder createCreeperAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movementSpeed).add(EntityAttributes.GENERIC_MAX_HEALTH, health);
    }
}
