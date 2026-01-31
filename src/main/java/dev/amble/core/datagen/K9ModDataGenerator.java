package dev.amble.core.datagen;

import dev.amble.K9Mod;
import dev.amble.core.K9Blocks;
import dev.amble.core.K9ItemGroups;
import dev.amble.core.K9Items;
import dev.amble.core.datagen.providers.K9ModelProvider;
import dev.amble.core.datagen.providers.K9RecipeProvider;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.model.AmbleModelProvider;
import dev.amble.lib.datagen.sound.AmbleSoundProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;
import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;

public class K9ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        generateSoundData(pack);
        generateModels(pack);
        generateRecipes(pack);
        genLang(pack);
    }

    public void generateSoundData(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleSoundProvider(output))));
    }

    public void generateModels(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            K9ModelProvider provider = new K9ModelProvider(output);

            provider.registerCustomTexturedBlock(K9Blocks.K9_CRATE);

            return provider;
        })));
    }

    private void genLang(FabricDataGenerator.Pack pack) {
        genEnglish(pack);
    }

    private void genEnglish(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);

            provider.addTranslation(K9Items.K9_WRENCH, "K9 Wrench");
            provider.addTranslation(K9Items.K9_BONE, "Metal Bone");
            provider.addTranslation(K9Items.K9_LITHIUM_CELL, "Lithium Cell");
            provider.addTranslation(K9Items.K9_WRISTBAND, "K9 Wristband");
            provider.addTranslation(K9Blocks.K9_CRATE, "K9 Crate");
            provider.addTranslation(K9ItemGroups.K9_GROUP, "K9 Mod");

            return provider;
        })));
    }

    public void generateRecipes(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            K9RecipeProvider provider = new K9RecipeProvider(output);

            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, K9Items.K9_WRENCH, 1)
                    .pattern(" R ")
                    .pattern("IAR")
                    .pattern("TI ")
                    .input('R', Items.REPEATER)
                    .input('I', Items.IRON_INGOT)
                    .input('A', Items.IRON_AXE)
                    .input('T', Items.REDSTONE_TORCH)
                    .criterion(FabricRecipeProvider.hasItem(Items.REPEATER),
                            FabricRecipeProvider.conditionsFromItem(Items.REPEATER))
                    .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                            FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .criterion(FabricRecipeProvider.hasItem(Items.IRON_AXE),
                            FabricRecipeProvider.conditionsFromItem(Items.IRON_AXE))
                    .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE_TORCH),
                            FabricRecipeProvider.conditionsFromItem(Items.REDSTONE_TORCH))
            );
            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, K9Blocks.K9_CRATE, 1)
                    .pattern("SSS")
                    .pattern("LWL")
                    .pattern("SMS")
                    .input('S', Items.STRIPPED_OAK_WOOD)
                    .input('L', Items.OAK_PLANKS)
                    .input('W', K9Items.K9_WRENCH)
                    .input('M', Items.MINECART)
                    .criterion(FabricRecipeProvider.hasItem(Items.STRIPPED_OAK_WOOD),
                            FabricRecipeProvider.conditionsFromItem(Items.STRIPPED_OAK_WOOD))
                    .criterion(FabricRecipeProvider.hasItem(Items.OAK_PLANKS),
                            FabricRecipeProvider.conditionsFromItem(Items.OAK_PLANKS))
                    .criterion(FabricRecipeProvider.hasItem(K9Items.K9_WRENCH),
                            FabricRecipeProvider.conditionsFromItem(K9Items.K9_WRENCH))
                    .criterion(FabricRecipeProvider.hasItem(Items.MINECART),
                            FabricRecipeProvider.conditionsFromItem(Items.MINECART))
            );
            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, K9Items.K9_BONE, 1)
                    .pattern("III")
                    .pattern("IBI")
                    .pattern("III")
                    .input('I', Items.IRON_INGOT)
                    .input('B', Items.BONE)
                    .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                            FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .criterion(FabricRecipeProvider.hasItem(Items.BONE),
                            FabricRecipeProvider.conditionsFromItem(Items.BONE))
            );
            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, K9Items.K9_LITHIUM_CELL, 1)
                    .pattern("IAI")
                    .pattern("OCO")
                    .pattern("IAI")
                    .input('I', Items.IRON_INGOT)
                    .input('O', Items.OBSIDIAN) // Maybe make it granite since pegmatites are more similar to granite
                    .input('A', Items.COAL)
                    .input('C', Items.COPPER_INGOT)
                    .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                            FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .criterion(FabricRecipeProvider.hasItem(Items.OBSIDIAN),
                            FabricRecipeProvider.conditionsFromItem(Items.OBSIDIAN))
                    .criterion(FabricRecipeProvider.hasItem(Items.COAL),
                            FabricRecipeProvider.conditionsFromItem(Items.COAL))
                    .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT),
                            FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
            );
            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, K9Items.K9_WRISTBAND, 1)
                    .pattern("ISI")
                    .pattern("SWS")
                    .pattern("LSL")
                    .input('I', Items.IRON_INGOT)
                    .input('S', Items.STRING)
                    .input('W', K9Items.K9_WRENCH)
                    .input('L', K9Items.K9_LITHIUM_CELL)
                    .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                            FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .criterion(FabricRecipeProvider.hasItem(Items.STRING),
                            FabricRecipeProvider.conditionsFromItem(Items.STRING))
                    .criterion(FabricRecipeProvider.hasItem(K9Items.K9_WRENCH),
                            FabricRecipeProvider.conditionsFromItem(K9Items.K9_WRENCH))
                    .criterion(FabricRecipeProvider.hasItem(K9Items.K9_LITHIUM_CELL),
                            FabricRecipeProvider.conditionsFromItem(K9Items.K9_LITHIUM_CELL))
            );

            return provider;
        })));
    }
}
