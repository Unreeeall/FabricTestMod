package me.unreal.testmod.block;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block BLOCK_OF_QUARGERMARK = registerBlock("block_of_quargermark",
            Block::new, AbstractBlock.Settings.create()
                            .strength(1f)
                            .sounds(BlockSoundGroup.MUD)
    );

    public static final Block PROTEIN_POWDER_BLOCK = registerBlock("protein_powder_block",
            Block::new, AbstractBlock.Settings.create()
                            .strength(1f)
                            .sounds(BlockSoundGroup.SAND)

    );

    public static final Block EGG_ORE = registerBlock("egg_ore",
            Block::new, AbstractBlock.Settings.create()
                            .strength(0f)
                            .sounds(BlockSoundGroup.CREAKING_HEART)
    );

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            Block::new, AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            Block::new, AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK));


    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            Block::new, AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            Block::new, AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
    );

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            MagicBlock::new, AbstractBlock.Settings.create()
                    .strength(6f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.VAULT)
    );

    /*
    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            StairsBlock::new, ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()
    );
    */

    /// //////////////////////////////////////////////////////////
    //Test for alternative way to make blocks
    public static final RegistryKey<Block> CONDENSED_DIRT_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(TestMod.MOD_ID, "condensed_dirt")
    );

    public static final Block CONDENSED_DIRT = register(
            new Block(AbstractBlock.Settings.create().registryKey(CONDENSED_DIRT_KEY).sounds(BlockSoundGroup.GRASS)),
            CONDENSED_DIRT_KEY,
            true
    );

    public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }
    /// /////////////////////////////////////////////////////////////////////

    //HELPER METHODS:

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(TestMod.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        registerBlockItem(name, block);
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BLOCK_OF_QUARGERMARK);
            entries.add(ModBlocks.PROTEIN_POWDER_BLOCK);
            entries.add(ModBlocks.EGG_ORE);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.PINK_GARNET_ORE);
            entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
            entries.add(ModBlocks.MAGIC_BLOCK);
            entries.add(ModBlocks.CONDENSED_DIRT);

        });
    }
}
