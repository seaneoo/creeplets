package dev.seano.creeplets.entity;

import dev.seano.creeplets.mixin.TntEntityMixin;
import dev.seano.creeplets.registry.Blocks;
import dev.seano.creeplets.registry.Entities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class UnstableTntEntity extends TntEntity {

	public final int fuse = 10;

	public final float minPower = 2f;

	public final float maxPower = 10f;

	public UnstableTntEntity(EntityType<? extends TntEntity> entityType, World world) {
		super(entityType, world);
	}

	public UnstableTntEntity(World world, double x, double y, double z, @Nullable LivingEntity livingEntity) {
		this(Entities.UNSTABLE_TNT, world);
		this.setPosition(x, y, z);
		double d = world.random.nextDouble() * (float) (Math.PI * 2);
		this.setVelocity(-Math.sin(d) * 0.02, 0.2F, -Math.cos(d) * 0.02);
		this.setFuse(fuse);
		this.prevX = x;
		this.prevY = y;
		this.prevZ = z;
		((TntEntityMixin) this).setCausingEntity(livingEntity);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		builder.add(((TntEntityMixin) this).FUSE(), fuse);
		builder.add(((TntEntityMixin) this).BLOCK_STATE(), Blocks.UNSTABLE_TNT.getDefaultState());
	}

	public void explode() {
		float power = minPower + random.nextFloat() * (maxPower - minPower);
		this.getWorld()
			.createExplosion(this, Explosion.createDamageSource(this.getWorld(), this),
				((TntEntityMixin) this).isTeleported() ? ((TntEntityMixin) this).TELEPORTED_EXPLOSION_BEHAVIOR() : null,
				this.getX(), this.getBodyY(0.0625), this.getZ(), power, false, World.ExplosionSourceType.TNT);
	}

	@Override
	public void tick() {
		this.tickPortalTeleportation();
		this.applyGravity();
		this.move(MovementType.SELF, this.getVelocity());
		this.setVelocity(this.getVelocity().multiply(0.98));
		if (this.isOnGround()) {
			this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
		}

		int i = this.getFuse() - 1;
		this.setFuse(i);
		if (i <= 0) {
			this.discard();
			if (!this.getWorld().isClient) {
				this.explode();
			}
		} else {
			this.updateWaterState();
			if (this.getWorld().isClient) {
				this.getWorld()
					.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
			}
		}
	}
}
