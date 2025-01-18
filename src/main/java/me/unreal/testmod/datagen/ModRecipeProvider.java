package me.unreal.testmod.datagen;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.block.ModBlocks;
import me.unreal.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.client.data.TextureMap;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);


                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

                createShaped(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                        .input(ModBlocks.MAGIC_BLOCK)
                        .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(TestMod.MOD_ID, "raw_pink_garnet_from_magic_block")));

                createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK))
                        .criterion(hasItem(ModBlocks.PINK_GARNET_STAIRS), conditionsFromItem(ModBlocks.PINK_GARNET_STAIRS))
                        .offerTo(exporter);






                /*
                offerSmithingTrimRecipe(ModItems.UNREAL_SMITHING_TEMPLATE, RegistryKey.of(RegistryKeys.RECIPE,
                        Identifier.ofVanilla(getItemPath(ModItems.UNREAL_SMITHING_TEMPLATE) + "_smithing_trim")));

                 */
            }
        };
    }
/*
    private static void createSwordRecipe(RecipeExporter exporter, Item sword, Item bladeMaterial, Item handleMaterial, Item rawMaterial){
        createShaped(RecipeCategory.COMBAT, sword)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" H ")
                .input('B', bladeMaterial)
                .input('H', handleMaterial)
                .criterion(hasItem(rawMaterial), conditionsFromItem(rawMaterial))
                .offerTo(exporter);
    }
*/


    @Override
    public String getName() {
        return "Test Recipes";
    }
}
