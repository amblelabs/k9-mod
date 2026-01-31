package dev.amble.client;

import dev.amble.client.renderer.entity.K9EntityRenderer;
import dev.amble.client.screens.K9CellScreen;
import dev.amble.client.screens.K9InventoryScreen;
import dev.amble.core.K9EntityTypes;
import dev.amble.core.K9ScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class K9ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerScreenHandlers();
        entityRenderRegister();
    }

    public void registerScreenHandlers() {
        HandledScreens.register(K9ScreenHandlers.K9_CELL_HANDLER, K9CellScreen::new);
        HandledScreens.register(K9ScreenHandlers.K9_INVENTORY_HANDLER, K9InventoryScreen::new);
    }

    public void entityRenderRegister() {
        EntityRendererRegistry.register(K9EntityTypes.K9_ENTITY_TYPE, K9EntityRenderer::new);
    }
}
