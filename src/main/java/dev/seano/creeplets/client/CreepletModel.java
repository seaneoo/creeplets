package dev.seano.creeplets.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class CreepletModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;

	private final ModelPart head;

	private final ModelPart rightHindLeg;

	private final ModelPart leftHindLeg;

	private final ModelPart rightFrontLeg;

	private final ModelPart leftFrontLeg;

	public CreepletModel(ModelPart pRoot) {
		root = pRoot;
		head = pRoot.getChild("head");
		leftHindLeg = pRoot.getChild("right_hind_leg");
		rightHindLeg = pRoot.getChild("left_hind_leg");
		leftFrontLeg = pRoot.getChild("right_front_leg");
		rightFrontLeg = pRoot.getChild("left_front_leg");
	}

	@Override
	public @NotNull ModelPart root() {
		return root;
	}

	@Override
	public void setupAnim(@NotNull T pEntity,
						  float pLimbSwing,
						  float pLimbSwingAmount,
						  float pAgeInTicks,
						  float pNetHeadYaw,
						  float pHeadPitch) {
		head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
		head.xRot = pHeadPitch * ((float) Math.PI / 180F);
		rightHindLeg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
		leftHindLeg.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount;
		rightFrontLeg.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount;
		leftFrontLeg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack,
							   @NotNull VertexConsumer pBuffer,
							   int pPackedLight,
							   int pPackedOverlay,
							   float pRed,
							   float pGreen,
							   float pBlue,
							   float pAlpha) {
		pPoseStack.pushPose();
		pPoseStack.scale(1.5f, 1.5f, 1.5f);
		head.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
		pPoseStack.popPose();

		root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
	}
}
