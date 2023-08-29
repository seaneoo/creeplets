package dev.seano.creeplets.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

/**
 * TODO: - Change fuse speed to '15' (down from '30' as the default)
 *       - Make the explosion radius smaller (only slightly, original is '3')
 */
public class CreepletEntity extends CreeperEntity {
    private static final float movementSpeed = 0.45f;

    public CreepletEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createCreeperAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movementSpeed);
    }
}
