package me.unreal.testmod.world.gen;

import me.unreal.testmod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModVegetationGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DRIFTWOOD_PLACED_KEY);
    }

    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HONEY_BERRY_BUSH_PLACED_KEY);
    }
}
