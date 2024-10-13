package dev.seano.creeplets.entity;

import dev.seano.creeplets.Creeplets;
import dev.seano.creeplets.mixin.CreeperEntityAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class CreepletEntity extends CreeperEntity {

	public CreepletEntity(EntityType<? extends CreeperEntity> entityType, World world) {
		super(entityType, world);

		((CreeperEntityAccessor) this).setFuseTime(Creeplets.config.fuseTime);
		((CreeperEntityAccessor) this).setExplosionRadius(Creeplets.config.explosionRadius);
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return HostileEntity.createHostileAttributes()
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, Creeplets.config.movementSpeed)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, Creeplets.config.maxHealth);
	}
}
