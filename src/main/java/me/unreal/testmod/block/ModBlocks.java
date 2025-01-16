package me.unreal.testmod.block;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
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

    /*
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            Block::new, AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
     );

     */

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
    public static final Block PINK_GARNET_STAIRS = registerStairBlock("pink_garnet_stairs",
            ModBlocks.PINK_GARNET_BLOCK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            SlabBlock::new, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );
    public static final Block PINK_GARNET_BUTTON = registerButtonBlock("pink_garnet_button",
            BlockSetType.IRON, 10, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .noCollision()
    );

     */


    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            basicBlockFactory(), AbstractBlock.Settings.create().strength(3f).requiresTool());

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            stairsFactory(ModBlocks.PINK_GARNET_BLOCK), AbstractBlock.Settings.create().strength(2f).requiresTool());

    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            slabFactory(), AbstractBlock.Settings.create().strength(2f).requiresTool());

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            buttonFactory(BlockSetType.IRON, 10), AbstractBlock.Settings.create().strength(2f).requiresTool());

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            fenceFactory(), AbstractBlock.Settings.create().strength(2f).requiresTool());

    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            trapdoorFactory(BlockSetType.IRON), AbstractBlock.Settings.create().strength(2f).requiresTool());

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            doorFactory(BlockSetType.IRON), AbstractBlock.Settings.create().strength(2f).requiresTool());

    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            pressurePlateFactory(BlockSetType.IRON), AbstractBlock.Settings.create().strength(2f).requiresTool());



    public static Function<AbstractBlock.Settings, Block> basicBlockFactory() {
        return Block::new;
    }

    // Stairs Block
    public static Function<AbstractBlock.Settings, Block> stairsFactory(Block baseBlock) {
        return settings -> new StairsBlock(baseBlock.getDefaultState(), settings);
    }

    // Slab Block
    public static Function<AbstractBlock.Settings, Block> slabFactory() {
        return SlabBlock::new;
    }

    // Button Block
    public static Function<AbstractBlock.Settings, Block> buttonFactory(BlockSetType blockSetType, int pressTicks) {
        return settings -> new ButtonBlock(blockSetType, pressTicks, settings);
    }

    // Fence Block
    public static Function<AbstractBlock.Settings, Block> fenceFactory() {
        return FenceBlock::new;
    }

    // Trapdoor Block
    public static Function<AbstractBlock.Settings, Block> trapdoorFactory(BlockSetType blockSetType) {
        return settings -> new TrapdoorBlock(blockSetType, settings);
    }

    // Door Block
    public static Function<AbstractBlock.Settings, Block> doorFactory(BlockSetType blockSetType) {
        return settings -> new DoorBlock(blockSetType, settings);
    }

    // Pressure Plate Block
    public static Function<AbstractBlock.Settings, Block> pressurePlateFactory(BlockSetType blockSetType) {
        return settings -> new PressurePlateBlock(blockSetType, settings);
    }

    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(TestMod.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, blockFactory.apply(settings).getSettings());
        registerBlockItem(name, block);
        return block;
    }

    /*
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerStairBlock("pink_garnet_pressure_plate",
            ModBlocks.PINK_GARNET_BLOCK, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );
    */





    /*
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

     */
















    /*
    //HELPER METHODS:

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(TestMod.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        registerBlockItem(name, block);
        return block;
    }

    /// ///////////////////////////////////////////////////////////////////////////
    // From GPT:
    // Stairs
    public static Block registerStairBlock(String name, Block baseBlock, AbstractBlock.Settings settings) {
        return registerBlock(name, s -> new StairsBlock(baseBlock.getDefaultState(), s), settings);
    }

    // Slabs
    public static Block registerSlabBlock(String name, AbstractBlock.Settings settings) {
        return registerBlock(name, SlabBlock::new, settings);
    }

    // Fences
    public static Block registerFenceBlock(String name, AbstractBlock.Settings settings) {
        return registerBlock(name, FenceBlock::new, settings);
    }

    // Doors
    public static Block registerDoorBlock(String name, AbstractBlock.Settings settings, BlockSetType blockSetType) {
        return registerBlock(name, s -> new DoorBlock(blockSetType, s), settings);
    }

    public static Block registerButtonBlock(String name, BlockSetType blockSetType, int pressTicks, AbstractBlock.Settings settings) {
        return registerBlock(name, s -> new ButtonBlock(blockSetType, pressTicks,  s), settings);
    }
    /// ///////////////////////////////////////////////////////////////////////////

     */







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
            //entries.add(ModBlocks.CONDENSED_DIRT);
            entries.add(ModBlocks.PINK_GARNET_STAIRS);
            entries.add(ModBlocks.PINK_GARNET_BUTTON);
            entries.add(ModBlocks.PINK_GARNET_DOOR);
            entries.add(ModBlocks.PINK_GARNET_FENCE);
            entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
            entries.add(ModBlocks.PINK_GARNET_SLAB);
            entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);

        });
    }
}
