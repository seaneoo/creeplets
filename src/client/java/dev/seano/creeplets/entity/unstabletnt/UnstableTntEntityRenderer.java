package dev.seano.creeplets.entity.unstabletnt;

import dev.seano.creeplets.entity.UnstableTntEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class UnstableTntEntityRenderer extends EntityRenderer<UnstableTntEntity> {

	private final BlockRenderManager blockRenderManager;

	public UnstableTntEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.shadowRadius = 0.5F;
		this.blockRenderManager = context.getBlockRenderManager();
	}

	@Override
	public void render(UnstableTntEntity unstableTntEntity,
					   float yaw,
					   float tickDelta,
					   MatrixStack matrices,
					   VertexConsumerProvider vertexConsumers,
					   int light) {
		matrices.push();
		matrices.translate(0.0F, 0.5F, 0.0F);
		int j = unstableTntEntity.getFuse();
		if ((float) j - tickDelta + 1.0F < 10.0F) {
			float h = 1.0F - ((float) j - tickDelta + 1.0F) / 10.0F;
			h = MathHelper.clamp(h, 0.0F, 1.0F);
			h *= h;
			h *= h;
			float k = 1.0F + h * 0.3F;
			matrices.scale(k, k, k);
		}

		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));
		matrices.translate(-0.5F, -0.5F, 0.5F);
		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));
		TntMinecartEntityRenderer.renderFlashingBlock(this.blockRenderManager, unstableTntEntity.getBlockState(),
			matrices, vertexConsumers, light, j / 5 % 2 == 0);
		matrices.pop();
		super.render(unstableTntEntity, yaw, tickDelta, matrices, vertexConsumers, light);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Identifier getTexture(UnstableTntEntity entity) {
		return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
	}
}
