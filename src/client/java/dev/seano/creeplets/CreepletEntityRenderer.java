package dev.seano.creeplets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CreepletEntityRenderer extends MobEntityRenderer<CreepletEntity, CreepletEntityModel<CreepletEntity>> {

	private static final float SHADOW = 0.5f;

	private static final String TEXTURE = "textures/entity/creeper/creeper.png";

	public CreepletEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer entityModelLayer) {
		super(context, new CreepletEntityModel<>(context.getPart(entityModelLayer)), SHADOW);
	}

	@Override
	public Identifier getTexture(CreepletEntity entity) {
		return Identifier.of(TEXTURE);
	}

	@Override
	protected void scale(CreepletEntity entity, MatrixStack matrices, float amount) {
		final float SCALE = 0.7f;
		float g = entity.getClientFuseTime(amount);
		float h = 1.0f + MathHelper.sin(g * 100.0f) * g * 0.01f;
		g = MathHelper.clamp(g, 0.0f, 1.0f);
		g *= g;
		g *= g;
		float i = (1.0f + g * 0.4f) * h;
		float j = (1.0f + g * 0.1f) / h;
		matrices.scale(i * SCALE, j * SCALE, i * SCALE);
	}

	@Override
	protected float getAnimationCounter(CreepletEntity entity, float tickDelta) {
		float g = entity.getClientFuseTime(tickDelta);
		if ((int) (g * 10.0f) % 2 == 0) return 0.0f;
		return MathHelper.clamp(g, 0.5f, 1.0f);
	}
}
