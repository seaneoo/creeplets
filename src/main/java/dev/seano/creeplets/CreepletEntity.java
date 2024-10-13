package dev.seano.creeplets;

import dev.seano.creeplets.mixin.CreeperEntityAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class CreepletEntity extends CreeperEntity {

	private static final int FUSE_TIME = 15;

	private static final int EXPLOSION_RADIUS = 2;

	private static final double MOVEMENT_SPEED = 0.4;

	private static final double MAX_HEALTH = 10;

	public CreepletEntity(EntityType<? extends CreeperEntity> entityType, World world) {
		super(entityType, world);

		((CreeperEntityAccessor) this).setFuseTime(FUSE_TIME);
		((CreeperEntityAccessor) this).setExplosionRadius(EXPLOSION_RADIUS);
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return HostileEntity.createHostileAttributes()
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, MOVEMENT_SPEED)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, MAX_HEALTH);
	}
}
