package dev.amble.core;

import dev.amble.core.items.K9LithiumCellItem;
import dev.amble.core.items.K9Wristband;
import dev.amble.lib.container.impl.ItemContainer;
import dev.amble.lib.datagen.util.AutomaticModel;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.item.Item;

public class K9Items extends ItemContainer {
    public static final Item K9_WRENCH = new Item(new AItemSettings().group(K9ItemGroups.K9_GROUP).maxDamage(4));
    public static final Item K9_BONE = new Item(new AItemSettings().group(K9ItemGroups.K9_GROUP).maxDamage(16));
    public static final K9LithiumCellItem K9_LITHIUM_CELL = new K9LithiumCellItem(new AItemSettings().group(K9ItemGroups.K9_GROUP).maxCount(1));
    public static final K9Wristband K9_WRISTBAND = new K9Wristband(new AItemSettings().group(K9ItemGroups.K9_GROUP).maxCount(1));
}
