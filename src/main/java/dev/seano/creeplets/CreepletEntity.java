package dev.seano.creeplets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class CreepletEntity extends CreeperEntity {

	private static final double MOVEMENT_SPEED = 0.4;

	private static final double MAX_HEALTH = 10;

	public CreepletEntity(EntityType<? extends CreeperEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return HostileEntity.createHostileAttributes()
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, MOVEMENT_SPEED)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, MAX_HEALTH);
	}
}
