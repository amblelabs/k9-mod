package dev.amble.client.renderer.entity;

import dev.amble.K9Mod;
import dev.amble.client.models.K9EntityModel;
import dev.amble.core.entities.K9Entity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class K9EntityRenderer extends MobEntityRenderer<K9Entity, K9EntityModel<K9Entity>> {
    private static final Identifier DEFAULT_TEXTURE = new Identifier(K9Mod.MOD_ID, "textures/entity/k9.png");
    private static final Identifier SCARF_TEXTURE = new Identifier(K9Mod.MOD_ID, "textures/entity/k9_scarf.png");
    private static final Identifier BLUE_TEXTURE = new Identifier(K9Mod.MOD_ID, "textures/entity/k9_blue.png");
    private static final Identifier GLOW_TEXTURE = new Identifier(K9Mod.MOD_ID, "textures/entity/k9_emission.png");

    public K9EntityRenderer(EntityRendererFactory.Context context) {
        super(context, new K9EntityModel<>(K9EntityModel.getTexturedModelData().createModel()), 0.5F);
        this.addFeature(new K9CollarFeatureRenderer(this));
        this.addFeature(new K9GlowFeatureRenderer<>(this, GLOW_TEXTURE));
    }

    protected float getAnimationProgress(K9Entity K9Entity, float f) {
        return K9Entity.getTailAngle();
    }

    @Override
    public void render(K9Entity k9Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(k9Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(K9Entity k9Entity) {
        if(!k9Entity.isTamed()) return DEFAULT_TEXTURE;

        if (k9Entity.hasCustomName() && "bugger".equals(k9Entity.getName().getString())) {
            return SCARF_TEXTURE;
        }
        if (k9Entity.hasCustomName() && "adventure".equals(k9Entity.getName().getString())) {
            return BLUE_TEXTURE;
        }

        return DEFAULT_TEXTURE;
    }

}