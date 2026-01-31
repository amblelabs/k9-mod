package dev.amble.core;

import dev.amble.core.entities.K9Entity;
import dev.amble.lib.container.AssignedName;
import dev.amble.lib.container.impl.EntityContainer;
import dev.amble.lib.datagen.util.NoEnglish;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public class K9EntityTypes implements EntityContainer {
    @AssignedName("k9_entity")
    public static final EntityType<K9Entity> K9_ENTITY_TYPE = FabricEntityTypeBuilder.create(
            SpawnGroup.MISC, K9Entity::new).dimensions(EntityDimensions.changing(0.8f, 0.8f)).build();
}
