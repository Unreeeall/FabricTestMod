package me.unreal.testmod.block;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.block.custom.*;
import me.unreal.testmod.sound.ModSounds;
import me.unreal.testmod.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
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

    public static final Block PINK_GARNET_END_ORE = registerBlock("pink_garnet_end_ore",
            Block::new, AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block PINK_GARNET_NETHER_ORE = registerBlock("pink_garnet_nether_ore",
            Block::new, AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHER_ORE));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            MagicBlock::new, AbstractBlock.Settings.create()
                    .strength(6f)
                    .requiresTool()
                    .sounds(ModSounds.MAGIC_BLOCK_SOUNDS)
    );

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            settings -> new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(), settings),
            AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
    );

    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            SlabBlock::new, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );
    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            settings -> new ButtonBlock(BlockSetType.IRON, 2, settings),
            AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .noCollision()
    );

    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            FenceBlock::new, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );

    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            settings -> new FenceGateBlock(WoodType.ACACIA, settings),
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );

    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            WallBlock::new, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
    );

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            settings -> new DoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .nonOpaque()
    );

    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .nonOpaque()
    );

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            PinkGarnetLampBlock::new, AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool().luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)
    );



    public static final Block CAULIFLOWER_CROP = registerBlockWithoutItem("cauliflower_crop",
            CauliflowerCropBlock::new, AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.DARK_GREEN)
    );


    public static final Block HONEY_BERRY_BUSH = registerBlockWithoutItem("honey_berry_bush",
            HoneyBerryBushBlock::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));


    public static final Block DRIFTWOOD_LOG = registerBlock("driftwood_log",
            PillarBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LOG)
    );
    public static final Block DRIFTWOOD_WOOD = registerBlock("driftwood_wood",
            PillarBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
    );
    public static final Block STRIPPED_DRIFTWOOD_LOG = registerBlock("stripped_driftwood_log",
            PillarBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
    );
    public static final Block STRIPPED_DRIFTWOOD_WOOD = registerBlock("stripped_driftwood_wood",
            PillarBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
    );

    public static final Block DRIFTWOOD_PLANKS = registerBlock("driftwood_planks",
            Block::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
    );
    public static final Block DRIFTWOOD_LEAVES = registerBlock("driftwood_leaves",
            LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
    );

    public static final Block DRIFTWOOD_SAPLING = registerBlock("driftwood_sapling",
            settings -> new ModSaplingBlock(ModSaplingGenerators.DRIFTWOOD, settings, Blocks.SNOW_BLOCK),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
    );



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

    private static Block registerBlockWithoutItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(TestMod.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        return Blocks.register(registryKey, factory, settings);
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(TestMod.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        registerBlockItem(name, block);
        return block;
    }

    /// ///////////////////////////////////////////////////////////////////////////


    /// ///////////////////////////////////////////////////////////////////////////
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

            entries.add(ModBlocks.PINK_GARNET_NETHER_ORE);
            entries.add(ModBlocks.PINK_GARNET_END_ORE);

        });
    }
}
