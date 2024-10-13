package dev.seano.creeplets.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreeperEntity.class)
public interface CreeperEntityAccessor {

	@Accessor("fuseTime")
	void setFuseTime(int fuseTime);

	@Accessor("explosionRadius")
	void setExplosionRadius(int explosionRadius);
}
