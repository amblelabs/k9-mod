package dev.amble.core;

import dev.amble.K9Mod;
import dev.amble.lib.container.impl.ItemGroupContainer;
import dev.amble.lib.itemgroup.AItemGroup;
import net.minecraft.item.ItemStack;

public class K9ItemGroups implements ItemGroupContainer {
    public static final AItemGroup K9_GROUP = AItemGroup.builder(K9Mod.id("item_group"))
            .icon(() -> new ItemStack(K9Blocks.K9_CRATE)).build();
}
