package dev.amble.core;

import dev.amble.K9Mod;
import dev.amble.core.screenhandlers.K9CellScreenHandler;
import dev.amble.core.screenhandlers.K9ScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;

public class K9ScreenHandlers {
    public static final ScreenHandlerType<K9ScreenHandler> K9_INVENTORY_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
            K9Mod.id("k9_inventory_handler"), new ScreenHandlerType<>(K9ScreenHandler::createDefault, ScreenHandlerType.GENERIC_9X3.getRequiredFeatures()));
    public static final ScreenHandlerType<K9CellScreenHandler> K9_CELL_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
            K9Mod.id("k9_cell_handler"), new ScreenHandlerType<>(K9CellScreenHandler::createDefault, ScreenHandlerType.GENERIC_9X3.getRequiredFeatures()));

    public static void init() {

    }
}
