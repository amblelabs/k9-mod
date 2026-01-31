package dev.amble.core.datagen.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.amble.K9Mod;
import dev.amble.core.K9Blocks;
import dev.amble.core.K9Items;
import dev.amble.lib.datagen.model.AmbleModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Direction;

public class K9ModelProvider extends AmbleModelProvider {
    private final List<Block> directionalBlocksToRegister = new ArrayList<>();
    private final List<Block> simpleBlocksToRegister = new ArrayList<>();
    private final List<Block> customTexBlocksToRegister = new ArrayList<>();
    private final List<Pair<Block, Block>> coralFanBlocksToRegister = new ArrayList<>();

    public K9ModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static Model item(String modid, String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(modid, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return item(K9Mod.MOD_ID, parent, requiredTextureKeys);
    }

    private static Model item(TextureKey... requiredTextureKeys) {
        return item("minecraft", "generated", requiredTextureKeys);
    }

    private static Model item(String name) {
        return item(name, TextureKey.LAYER0);
    }

    private static String getItemName(Item item) {
        return item.getTranslationKey().split("\\.")[2];
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        for (Block block : directionalBlocksToRegister) {
            generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(block).with(
                    When.create().set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                    BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R0)));
        }
        for (Block block : simpleBlocksToRegister) {
            generator.registerSimpleCubeAll(block);
        }

        for (Block block : customTexBlocksToRegister) {
            generator.registerSingleton(block, TexturedModel.CUBE_COLUMN);
        }

        for (Pair<Block, Block> pair : coralFanBlocksToRegister) {
            generator.registerCoralFan(pair.getLeft(), pair.getRight());
        }

        super.generateBlockStateModels(generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        this.withItems(K9Items.class);
        this.withBlocks(K9Blocks.class);

        super.generateItemModels(generator);
    }

    public void registerDirectionalBlock(Block block) {
        directionalBlocksToRegister.add(block);
    }

    public void registerCoralFanBlock(Block fanBlock, Block wallFanBlock) {
        coralFanBlocksToRegister.add(new Pair<>(fanBlock, wallFanBlock));
    }

    public void registerSimpleBlock(Block block) {
        simpleBlocksToRegister.add(block);
    }

    public void registerCustomTexturedBlock(Block block) {
        customTexBlocksToRegister.add(block);
    }

    private void registerItem(ItemModelGenerator generator, Item item, String modid) {
        Model model = item(TextureKey.LAYER0);
        model.upload(ModelIds.getItemModelId(item), createTextureMap(item, modid), generator.writer);
    }

    private TextureMap createTextureMap(Item item, String modid) {
        Identifier texture = new Identifier(modid, "item/" + getItemName(item));
        if (!(doesTextureExist(texture))) {
            texture = K9Mod.id("item/error");
        }

        return new TextureMap().put(TextureKey.LAYER0, texture);
    }

    public boolean doesTextureExist(Identifier texture) {
        return this.output.getModContainer().findPath("assets/" + texture.getNamespace() + "/textures/" + texture.getPath() + ".png").isPresent();
    }
}
