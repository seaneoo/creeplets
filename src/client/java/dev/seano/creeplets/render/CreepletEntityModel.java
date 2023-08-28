package dev.seano.creeplets.render;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CreepletEntityModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart legFrontLeft;
    private final ModelPart legFrontRight;
    private final ModelPart legBackLeft;
    private final ModelPart legBackRight;

    public CreepletEntityModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.legFrontLeft = root.getChild("legFrontLeft");
        this.legFrontRight = root.getChild("legFrontRight");
        this.legBackLeft = root.getChild("legBackLeft");
        this.legBackRight = root.getChild("legBackRight");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
        modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));
        modelPartData.addChild("legFrontLeft", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 18.0F, -2.0F));
        modelPartData.addChild("legFrontRight", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 18.0F, -2.0F));
        modelPartData.addChild("legBackLeft", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 18.0F, 2.0F));
        modelPartData.addChild("legBackRight", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 18.0F, 2.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yaw = netHeadYaw * ((float) Math.PI / 180);
        this.head.pitch = headPitch * ((float) Math.PI / 180);
        this.legBackLeft.pitch = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.legBackRight.pitch = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
        this.legFrontLeft.pitch = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
        this.legFrontRight.pitch = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.scale(1.5f, 1.5f, 1.5f);
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        matrices.pop();

        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legFrontLeft.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legFrontRight.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legBackLeft.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legBackRight.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
