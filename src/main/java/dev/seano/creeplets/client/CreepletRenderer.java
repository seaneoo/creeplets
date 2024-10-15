package dev.seano.creeplets.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.seano.creeplets.entity.Creeplet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class CreepletRenderer extends MobRenderer<Creeplet, CreepletModel<Creeplet>> {

	private static final float SHADOW = 0.5f;

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/creeper/creeper.png");

	public CreepletRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CreepletModel<>(pContext.bakeLayer(ModelLayers.CREEPER)), SHADOW);
	}

	@Override
	protected void scale(Creeplet pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
		final float SCALE = 0.7f;
		float f = pLivingEntity.getSwelling(pPartialTickTime);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		pPoseStack.scale(f2 * SCALE, f3 * SCALE, f2 * SCALE);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull Creeplet pEntity) {
		return TEXTURE;
	}
}
