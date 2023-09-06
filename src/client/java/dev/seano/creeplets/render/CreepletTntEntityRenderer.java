package dev.seano.creeplets.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntEntityRenderer;

/**
 * TODO: Resize the TNT entity to match the block model
 */
public class CreepletTntEntityRenderer extends TntEntityRenderer {

    public CreepletTntEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
}
