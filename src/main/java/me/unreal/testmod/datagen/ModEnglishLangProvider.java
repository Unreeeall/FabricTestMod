package me.unreal.testmod.datagen;

import me.unreal.testmod.block.ModBlocks;
import me.unreal.testmod.item.ModItemGroups;
import me.unreal.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    private FabricDataGenerator dataGenerator;

    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);

    }


    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add(ModBlocks.MAGIC_BLOCK, "Magic Block");
        translationBuilder.add(ModBlocks.PINK_GARNET_BLOCK, "Pink Garnet Block");
        translationBuilder.add(ModBlocks.RAW_PINK_GARNET_BLOCK, "Raw Pink Garnet Block");
        translationBuilder.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, "Pink Garnet Deepslate Ore");
        translationBuilder.add(ModBlocks.PINK_GARNET_ORE, "Pink Garnet Ore");
        translationBuilder.add(ModBlocks.PROTEIN_POWDER_BLOCK, "Protein Powder Block");
        translationBuilder.add(ModBlocks.EGG_ORE, "Egg Ore");
        translationBuilder.add(ModBlocks.BLOCK_OF_QUARGERMARK, "Quargermark Block");

        translationBuilder.add(ModItems.STARLIGHT_ASHES, "Starlight Ashes");
        translationBuilder.add(ModItems.BROCCOLI, "Broccoli");
        translationBuilder.add(ModItems.CHISEL, "Chisel");
        translationBuilder.add(ModItems.APPLE_ISO_CLEAR_POWDER, "Apple ISO Clear Powder");
        translationBuilder.add(ModItems.CAULIFLOWER, "Cauliflower");
        translationBuilder.add(ModItems.CHOCOLATE_WHEY_PROTEIN_POWDER, "Chocolate Whey Protein Powder");
        translationBuilder.add(ModItems.ISO_CLEAR_POWDER, "ISO Clear Powder");
        translationBuilder.add(ModItems.PINK_GARNET, "Pink Garnet");
        translationBuilder.add(ModItems.PLAIN_WHEY_PROTEIN_POWDER, "Plain Whey Protein Powder");
        translationBuilder.add(ModItems.QUARGERMARK, "Quargermark");
        translationBuilder.add(ModItems.RAW_PINK_GARNET, "Raw Pink Garnet");
        translationBuilder.add(ModItems.WATERMELON_ISO_CLEAR_POWDER, "Watermelon ISO Clear Powder");
        translationBuilder.add(ModItems.WHEY_ISOLATE, "Whey Isolate");




        /*
        translationBuilder.add(ModBlocks.MAGIC_BLOCK, "Magic Block");
        try {
           
            Path existingFilePath = dataGenerator.getModContainer().findPath("assets/testmod/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }

         */
    }
}
