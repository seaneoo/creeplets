package dev.seano.creeplets;

import dev.seano.creeplets.entity.creeplet.CreepletEntityModel;
import dev.seano.creeplets.entity.creeplet.CreepletEntityRenderer;
import dev.seano.creeplets.entity.unstabletnt.UnstableTntEntityRenderer;
import dev.seano.creeplets.registry.Entities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class CreepletsClient implements ClientModInitializer {

	public static final EntityModelLayer CREEPLET_LAYER = new EntityModelLayer(Creeplets.id("creeplet"), "main");

	@Override
	public void onInitializeClient() {
		Creeplets.LOGGER.debug("Initializing client-sided Creeplets mod");

		initModelsRenders();
	}

	private void initModelsRenders() {
		Creeplets.LOGGER.debug("Initializing entity models, renderers");

		EntityRendererRegistry.register(Entities.CREEPLET, ctx -> new CreepletEntityRenderer(ctx, CREEPLET_LAYER));
		EntityModelLayerRegistry.registerModelLayer(CREEPLET_LAYER, CreepletEntityModel::getTexturedModelData);
		EntityRendererRegistry.register(Entities.UNSTABLE_TNT, UnstableTntEntityRenderer::new);
	}
}
