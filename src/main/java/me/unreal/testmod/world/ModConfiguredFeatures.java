package me.unreal.testmod.world;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    // CF -> PF -> BM
    // Configure feature -> Place Feature -> Biome Modifications
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_GARNET_ORE_KEY = registerKey("pink_garnet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PINK_GARNET_ORE_KEY = registerKey("nether_pink_garnet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_PINK_GARNET_ORE_KEY = registerKey("end_pink_garnet_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceable = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceable = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
                        (OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.PINK_GARNET_DEEPSLATE_ORE.getDefaultState())));

        List<OreFeatureConfig.Target> netherPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceable, ModBlocks.PINK_GARNET_NETHER_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(endReplaceable, ModBlocks.PINK_GARNET_END_ORE.getDefaultState()));


        register(context, PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPinkGarnetOres, 12));
        register(context, NETHER_PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPinkGarnetOres, 6));
        register(context, END_PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(endPinkGarnetOres, 4));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TestMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
