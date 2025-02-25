package me.unreal.testmod.item;


import me.unreal.testmod.block.ModBlocks;
import me.unreal.testmod.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GAINZ_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "gainz_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_QUARGERMARK))
                    .displayName(Text.translatable("itemgroup.testmod.gainz_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.QUARGERMARK);
                        entries.add(ModItems.ISO_CLEAR_POWDER);
                        entries.add(ModItems.APPLE_ISO_CLEAR_POWDER);
                        entries.add(ModItems.CHOCOLATE_WHEY_PROTEIN_POWDER);
                        entries.add(ModItems.PLAIN_WHEY_PROTEIN_POWDER);
                        entries.add(ModItems.WATERMELON_ISO_CLEAR_POWDER);
                        entries.add(ModItems.WHEY_ISOLATE);
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.CHISEL);

                        entries.add(ModBlocks.BLOCK_OF_QUARGERMARK);
                        entries.add(ModBlocks.PROTEIN_POWDER_BLOCK);
                        entries.add(ModBlocks.EGG_ORE);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.BROCCOLI);
                        entries.add(ModItems.STARLIGHT_ASHES);

                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_SLAB);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);
                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);

                        entries.add(ModBlocks.PINK_GARNET_LAMP);

                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_HOE);

                        entries.add(ModItems.PINK_GARNET_HAMMER);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);

                        entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);

                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);

                        entries.add(ModItems.CAULIFLOWER_SEEDS);
                        entries.add(ModItems.HONEY_BERRIES);

                        entries.add(ModBlocks.PINK_GARNET_NETHER_ORE);
                        entries.add(ModBlocks.PINK_GARNET_END_ORE);

                        entries.add(ModBlocks.DRIFTWOOD_LOG);
                        entries.add(ModBlocks.DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.DRIFTWOOD_LEAVES);
                        entries.add(ModBlocks.DRIFTWOOD_PLANKS);
                        entries.add(ModBlocks.DRIFTWOOD_SAPLING);
                    }).build());


    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
