package dev.seano.creeplets.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TntEntity.class)
public interface TntEntityMixin {

	@Accessor("FUSE")
	TrackedData<Integer> FUSE();

	@Accessor("BLOCK_STATE")
	TrackedData<BlockState> BLOCK_STATE();

	@Accessor("TELEPORTED_EXPLOSION_BEHAVIOR")
	ExplosionBehavior TELEPORTED_EXPLOSION_BEHAVIOR();

	@Accessor("causingEntity")
	void setCausingEntity(LivingEntity livingEntity);

	@Accessor("teleported")
	boolean isTeleported();
}
