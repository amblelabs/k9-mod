/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package dev.amble.client.renderer.entity;

import dev.amble.K9Mod;
import dev.amble.client.models.K9EntityModel;
import dev.amble.core.entities.K9Entity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class K9CollarFeatureRenderer
        extends FeatureRenderer<K9Entity, K9EntityModel<K9Entity>> {
    private static final Identifier SKIN = K9Mod.id("textures/entity/k9_collar.png");

    public K9CollarFeatureRenderer(FeatureRendererContext<K9Entity, K9EntityModel<K9Entity>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, K9Entity k9Entity, float f, float g, float h, float j, float k, float l) {
        if (!k9Entity.isTamed() || k9Entity.isInvisible()) {
            return;
        }

        if (k9Entity.hasCustomName() && "bugger".equals(k9Entity.getName().getString())) return; // Return so we can render the texture with the SCARF on it
        if (k9Entity.hasCustomName() && "advanture".equals(k9Entity.getName().getString())) return; // Blue texture

        float[] fs = k9Entity.getCollarColor().getColorComponents();
        K9CollarFeatureRenderer.renderModel(this.getContextModel(), SKIN, matrixStack, vertexConsumerProvider, i, k9Entity, fs[0], fs[1], fs[2]);
    }
}

