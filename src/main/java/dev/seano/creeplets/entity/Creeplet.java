package dev.seano.creeplets.entity;

import dev.seano.creeplets.mixin.CreeperAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Creeplet extends Creeper {

	private static final double MOVEMENT_SPEED = 0.5;

	private static final double MAX_HEALTH = 10;

	private static final int SWELL = 10; // Default is 30

	private static final int EXPLOSION_RADIUS = 2; // Default is 3

	public Creeplet(EntityType<? extends Creeper> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		((CreeperAccessor) this).setMaxSwell(SWELL);
		((CreeperAccessor) this).setExplosionRadius(EXPLOSION_RADIUS);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Monster.createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED)
			.add(Attributes.MAX_HEALTH, MAX_HEALTH);
	}
}
