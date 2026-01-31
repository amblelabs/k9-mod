package dev.amble.core;

import dev.amble.core.blocks.K9CrateBlock;
import dev.amble.lib.block.ABlockSettings;
import dev.amble.lib.container.impl.BlockContainer;
import dev.amble.lib.datagen.util.AutomaticModel;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.block.Block;

public class K9Blocks extends BlockContainer {
    @AutomaticModel
    public static final Block K9_CRATE = new K9CrateBlock(ABlockSettings.create().itemSettings(new AItemSettings().group(K9ItemGroups.K9_GROUP)).nonOpaque());
}
