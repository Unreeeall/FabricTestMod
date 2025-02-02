package me.unreal.testmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModVegetationGeneration.generateTrees();
        ModVegetationGeneration.generateBushes();
    }
}
