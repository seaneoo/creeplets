package dev.seano.creeplets.mixin;

import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Creeper.class)
public interface CreeperAccessor {

	@Accessor("maxSwell")
	void setMaxSwell(int maxSwell);

	@Accessor("explosionRadius")
	void setExplosionRadius(int explosionRadius);
}
