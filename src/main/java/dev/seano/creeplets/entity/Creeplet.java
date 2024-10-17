package dev.seano.creeplets.entity;

import dev.seano.creeplets.config.CreepletsConfig;
import dev.seano.creeplets.mixin.CreeperAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Creeplet extends Creeper {

	public Creeplet(EntityType<? extends Creeper> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		((CreeperAccessor) this).setMaxSwell(CreepletsConfig.creepletSwell);
		((CreeperAccessor) this).setExplosionRadius(CreepletsConfig.creepletExplosionRadius);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Monster.createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, CreepletsConfig.creepletMovementSpeed)
			.add(Attributes.MAX_HEALTH, CreepletsConfig.creepletMaxHealth);
	}
}
