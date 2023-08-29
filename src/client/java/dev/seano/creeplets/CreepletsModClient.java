package dev.seano.creeplets;

import dev.seano.creeplets.registry.ModEntities;
import dev.seano.creeplets.render.CreepletEntityModel;
import dev.seano.creeplets.render.CreepletEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class CreepletsModClient implements ClientModInitializer {
    public static final EntityModelLayer CREEPLET = registerModelLayer("creeplet");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CREEPLET, ctx -> new CreepletEntityRenderer(ctx, CREEPLET));
        EntityModelLayerRegistry.registerModelLayer(CREEPLET, CreepletEntityModel::getTexturedModelData);
    }

    @SuppressWarnings("SameParameterValue")
    private static EntityModelLayer registerModelLayer(String name) {
        return new EntityModelLayer(CreepletsMod.identifier(name), "main");
    }
}
