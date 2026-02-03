package dev.amble.client.models;

import com.google.common.collect.ImmutableList;
import dev.amble.core.entities.K9Entity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.TintableAnimalModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class K9EntityModel<T extends K9Entity> extends TintableAnimalModel<T> {
    private final ModelPart dog;
    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart collar;
    private final ModelPart scarf;
    private final ModelPart head;
    private final ModelPart tongue;
    private final ModelPart eye;
    private final ModelPart left_ear;
    private final ModelPart right_ear;
    private final ModelPart hat;
    public K9EntityModel(ModelPart root) {
        this.dog = root.getChild("dog");
        this.body = this.dog.getChild("body");
        this.tail = this.body.getChild("tail");
        this.collar = this.body.getChild("collar");
        this.scarf = this.body.getChild("scarf");
        this.head = this.dog.getChild("head");
        this.tongue = this.head.getChild("tongue");
        this.eye = this.head.getChild("eye");
        this.left_ear = this.head.getChild("left_ear");
        this.right_ear = this.head.getChild("right_ear");
        this.hat = this.head.getChild("hat");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData dog = modelPartData.addChild("dog", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, -2.0F));

        ModelPartData body = dog.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -1.0F, -7.0F, 10.0F, 1.0F, 18.0F, new Dilation(0.1F))
                .uv(54, 34).cuboid(-1.5F, -10.0F, 11.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 19).cuboid(-2.0F, -11.0F, -7.0F, 4.0F, 1.0F, 18.0F, new Dilation(0.0F))
                .uv(36, 61).cuboid(-2.0F, -11.1F, -7.0F, 4.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(64, 91).cuboid(-1.0F, -11.2F, 0.0F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(59, 53).cuboid(0.5F, -11.2F, -2.8F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
                .uv(59, 53).cuboid(-1.5F, -11.2F, -2.8F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
                .uv(5, 48).cuboid(-0.5F, -5.2F, -7.5F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(44, 19).cuboid(-2.5F, -4.4F, -7.1F, 5.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(44, 19).cuboid(-2.5F, -4.4F, 11.1F, 5.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(28, 72).cuboid(-5.0F, -11.0F, -6.9F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(28, 72).mirrored().cuboid(-5.0F, -11.0F, 10.9F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(72, 56).mirrored().cuboid(-1.0F, 0.0F, 7.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(12, 74).cuboid(-1.0F, 0.0F, -11.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(48, 109).mirrored().cuboid(0.1F, -0.5F, -6.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(47, 103).mirrored().cuboid(0.2F, -0.5F, -6.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(36, 38).mirrored().cuboid(0.0F, 0.0F, -11.0F, 0.0F, 5.0F, 18.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, -11.0F, 4.0F, 0.0F, 0.0F, -0.3316F));

        ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(30, 65).mirrored().cuboid(-2.0F, -2.0F, 7.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(32, 65).cuboid(-2.0F, -2.0F, -11.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(28, 65).mirrored().cuboid(-2.0F, -2.0F, 5.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(34, 62).mirrored().cuboid(-2.0F, -2.0F, -9.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(44, 20).mirrored().cuboid(-2.0F, -2.0F, -9.0F, 1.0F, 0.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
                .uv(56, 0).mirrored().cuboid(-1.5F, -2.0F, -9.0F, 0.0F, 6.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 38).mirrored().cuboid(-1.0F, -2.0F, -11.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.0F, -5.0F, 4.0F, 0.0F, 0.0F, -0.2618F));

        ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(12, 74).mirrored().cuboid(0.0F, 0.0F, 7.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(72, 56).cuboid(0.0F, 0.0F, -11.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(63, 96).cuboid(-0.1F, 0.0F, -11.0F, 0.0F, 5.0F, 18.0F, new Dilation(0.08F))
                .uv(63, 90).cuboid(-0.2F, 0.0F, -11.0F, 0.0F, 5.0F, 18.0F, new Dilation(0.0F))
                .uv(36, 38).cuboid(0.0F, 0.0F, -11.0F, 0.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -11.0F, 4.0F, 0.0F, 0.0F, 0.3316F));

        ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(32, 65).mirrored().cuboid(1.0F, -2.0F, 7.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(44, 20).cuboid(1.0F, -2.0F, -9.0F, 1.0F, 0.0F, 14.0F, new Dilation(0.0F))
                .uv(56, 0).cuboid(1.5F, -2.0F, -9.0F, 0.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(28, 65).cuboid(1.0F, -2.0F, 5.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(34, 62).cuboid(1.0F, -2.0F, -9.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(30, 65).cuboid(1.0F, -2.0F, -11.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 38).cuboid(1.0F, -2.0F, -11.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -5.0F, 4.0F, 0.0F, 0.0F, 0.2618F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.5F, 11.8F));

        ModelPartData cube_r5 = tail.addChild("cube_r5", ModelPartBuilder.create().uv(28, 62).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(72, 41).cuboid(-1.5F, 0.0F, 2.0F, 3.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData collar = body.addChild("collar", ModelPartBuilder.create().uv(0, 74).cuboid(-2.0F, -9.8F, -8.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -0.4F, 0.0F));

        ModelPartData scarf = body.addChild("scarf", ModelPartBuilder.create().uv(97, 42).cuboid(-2.0F, -10.0F, -8.5F, 5.0F, 9.0F, 2.0F, new Dilation(0.1F)), ModelTransform.pivot(-0.5F, -0.4F, -1.0F));

        ModelPartData head = dog.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.01F, -8.6F, -7.5F, 0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(60, 72).cuboid(-2.5448F, 0.0881F, -2.1243F, 5.0F, 4.0F, 2.0F, new Dilation(0.01F)), ModelTransform.of(0.0347F, -7.2622F, -3.0238F, -0.4363F, 0.0F, 0.0F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(0, 62).cuboid(-2.5448F, 2.3464F, -6.0825F, 5.0F, 3.0F, 9.0F, new Dilation(0.15F))
                .uv(72, 34).cuboid(-2.5448F, 2.3464F, -6.0825F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(62, 36).cuboid(1.1552F, -1.1536F, -1.0825F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(62, 34).cuboid(-2.2448F, -1.1536F, -1.0825F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(66, 61).cuboid(-2.5448F, -0.6536F, -2.0825F, 5.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0347F, -7.2622F, -3.0238F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(48, 83).cuboid(-1.5F, 0.049F, -1.5F, 3.0F, 7.0F, 3.0F, new Dilation(0.12F))
                .uv(48, 72).cuboid(-1.5F, 0.049F, -1.5F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.01F, -3.0F, -3.7463F, 0.7418F, 0.0F, 0.0F));

        ModelPartData tongue = head.addChild("tongue", ModelPartBuilder.create(), ModelTransform.pivot(0.0347F, -7.2622F, -3.0238F));

        ModelPartData cube_r9 = tongue.addChild("cube_r9", ModelPartBuilder.create().uv(70, 34).cuboid(-0.5447F, 2.3464F, -6.2825F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData eye = head.addChild("eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0347F, -7.2622F, -3.0238F));

        ModelPartData cube_r10 = eye.addChild("cube_r10", ModelPartBuilder.create().uv(54, 19).cuboid(-0.5447F, 2.0881F, -2.3243F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(44, 34).cuboid(-2.5448F, 0.0881F, -2.2243F, 5.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create(), ModelTransform.pivot(1.19F, -8.4584F, -3.4164F));

        ModelPartData cube_r11 = left_ear.addChild("cube_r11", ModelPartBuilder.create().uv(34, 68).cuboid(-0.4532F, -1.0F, -0.2113F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, -1.0F, 0.0F, -0.0962F, 0.4346F, -0.0406F));

        ModelPartData cube_r12 = left_ear.addChild("cube_r12", ModelPartBuilder.create().uv(66, 34).cuboid(-1.4532F, -1.0F, 0.2113F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.9F, -1.0F, 0.0F, -0.0962F, -0.4346F, 0.0406F));

        ModelPartData cube_r13 = left_ear.addChild("cube_r13", ModelPartBuilder.create().uv(66, 36).cuboid(-2.2448F, -3.1536F, -0.5825F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.1553F, 1.1962F, 0.3926F, -0.0873F, 0.0F, 0.0F));

        ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create(), ModelTransform.pivot(2.19F, -8.4584F, -3.4164F));

        ModelPartData cube_r14 = right_ear.addChild("cube_r14", ModelPartBuilder.create().uv(34, 70).cuboid(-1.4532F, -1.0F, 0.2113F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.0F, 0.0F, -0.0962F, -0.4346F, 0.0406F));

        ModelPartData cube_r15 = right_ear.addChild("cube_r15", ModelPartBuilder.create().uv(68, 36).cuboid(-2.2448F, -3.1536F, -0.5825F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.2448F, 1.1962F, 0.3926F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r16 = right_ear.addChild("cube_r16", ModelPartBuilder.create().uv(68, 34).cuboid(-0.4532F, -1.0F, -0.2113F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.0F, 0.0F, -0.0962F, 0.4346F, -0.0406F));

        ModelPartData hat = head.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(-0.01F, -8.6054F, -2.9661F));

        ModelPartData cube_r17 = hat.addChild("cube_r17", ModelPartBuilder.create().uv(84, 0).cuboid(-3.5448F, -6.6536F, -3.0825F, 7.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(88, 15).cuboid(-2.5448F, -8.6536F, -2.0825F, 5.0F, 2.0F, 5.0F, new Dilation(0.1F))
                .uv(88, 8).cuboid(-2.5448F, -8.6536F, -2.0825F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.4552F, 7.2561F, -1.0539F, -0.0873F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.pitch = headPitch * ((float) Math.PI / 300f);
        this.head.yaw = netHeadYaw * ((float) Math.PI / 300f);
    }

    @Override
    public void animateModel(T k9Entity, float f, float g, float h) {

        if (k9Entity.isUniversallyAngry(k9Entity.getWorld())) {
            this.tail.yaw = 0.0F;

            this.left_ear.yaw = (++this.left_ear.yaw) / 8.0F;
            this.right_ear.yaw = (--this.right_ear.yaw) / 8.0F;
        } else {
            this.tail.yaw = MathHelper.cos(f * 0.6662F) * 1.4F * g;
            this.left_ear.yaw = 0.0F;
            this.right_ear.yaw = 0.0F;
        }

        if (k9Entity.isInSittingPose()) {
            this.body.setPivot(0.0F, 1.0F, 0.0F);
            this.tail.pivotY = -7.0F;
            this.head.setPivot(0.01F, -7.6F, -7.5F);
        } else {
            this.body.setPivot(0.0F, 0.0F, 0.0F);
            this.tail.pivotY = -8.5F;
            this.head.setPivot(0.01F, -8.6F, -7.5F);
        }

        this.tongue.visible = k9Entity.getHealth() < 10.0F;
        this.collar.visible = k9Entity.isTamed();

        if (k9Entity.isSongPlaying()) {
            this.dog.yaw = this.dog.yaw + MathHelper.sin(f * 0.6662F) * 0.2F;
        } else {
            this.dog.yaw = this.dog.getDefaultTransform().yaw;
        }
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.scale(0.8F, 0.8F, 0.8F);
        matrices.translate(0, 0.35, 0);
        dog.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }

    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body, this.tail);
    }
}