package dev.seano.creeplets;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class CreepletsClient implements ClientModInitializer {

	public static final EntityModelLayer CREEPLET_LAYER = new EntityModelLayer(Creeplets.id(Entities.CREEPLET_ID),
		"main");

	@Override
	public void onInitializeClient() {
		Creeplets.LOGGER.info("Initializing Creeplets (Client)");

		initModelsRenders();
	}

	private void initModelsRenders() {
		Creeplets.LOGGER.info("Initializing entity models, renderers");

		EntityRendererRegistry.register(Entities.CREEPLET, ctx -> new CreepletEntityRenderer(ctx, CREEPLET_LAYER));
		EntityModelLayerRegistry.registerModelLayer(CREEPLET_LAYER, CreepletEntityModel::getTexturedModelData);
	}
}
