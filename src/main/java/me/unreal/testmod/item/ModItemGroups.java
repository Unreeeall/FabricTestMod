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
                        entries.add(ModItems.CAUILIFLOWER);
                        entries.add(ModItems.BROCCOLI);
                        entries.add(ModItems.STARLIGHT_ASHES);
                    }).build());


    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
