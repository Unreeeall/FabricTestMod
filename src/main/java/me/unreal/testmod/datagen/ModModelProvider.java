package me.unreal.testmod.datagen;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.block.ModBlocks;
import me.unreal.testmod.block.custom.CauliflowerCropBlock;
import me.unreal.testmod.block.custom.HoneyBerryBushBlock;
import me.unreal.testmod.block.custom.PinkGarnetLampBlock;
import me.unreal.testmod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_QUARGERMARK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PROTEIN_POWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);




        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EGG_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);

        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        //System.out.println(this.stateManager.getProperties());
        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.HONEY_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                HoneyBerryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_ISO_CLEAR_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_WHEY_PROTEIN_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROCCOLI, Models.GENERATED);
        itemModelGenerator.register(ModItems.ISO_CLEAR_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLAIN_WHEY_PROTEIN_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARGERMARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.WATERMELON_ISO_CLEAR_POWDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);




        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);

        /* Own approach (I guess useful when I want my own trim assets)
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_HELMET, ModEquipmentAssetKeys.PINK_GARNET, "pink_garnet", false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_CHESTPLATE, ModEquipmentAssetKeys.PINK_GARNET, "pink_garnet", false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_LEGGINGS, ModEquipmentAssetKeys.PINK_GARNET, "pink_garnet", false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_BOOTS, ModEquipmentAssetKeys.PINK_GARNET, "pink_garnet", false);

         */

        //@galeriagaming7707 https://www.youtube.com/@galeriagaming7707
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_HELMET, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(TestMod.MOD_ID, "pink_garnet")),
                "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_CHESTPLATE, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(TestMod.MOD_ID, "pink_garnet")),
                "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_LEGGINGS, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(TestMod.MOD_ID, "pink_garnet")),
                "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_BOOTS, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(TestMod.MOD_ID, "pink_garnet")),
                "boots", false);


        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);
    }
}
