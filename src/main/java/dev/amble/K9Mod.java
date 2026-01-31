package dev.amble;

import dev.amble.core.*;
import dev.amble.core.entities.K9Entity;
import dev.amble.lib.container.RegistryContainer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class K9Mod implements ModInitializer {
    public static final String MOD_ID = "k9";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        RegistryContainer.register(K9Items.class, MOD_ID);
        RegistryContainer.register(K9Blocks.class, MOD_ID);
        RegistryContainer.register(K9EntityTypes.class, MOD_ID);
        RegistryContainer.register(K9ItemGroups.class, MOD_ID);
        K9Sounds.init();
        K9ScreenHandlers.init();
        entityAttributeRegister();
    }

    public void entityAttributeRegister() {
        FabricDefaultAttributeRegistry.register(K9EntityTypes.K9_ENTITY_TYPE, K9Entity.createK9Attributes());
    }
}