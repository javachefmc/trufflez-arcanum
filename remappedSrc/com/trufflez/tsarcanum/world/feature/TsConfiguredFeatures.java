package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsSaplings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;


public class TsConfiguredFeatures {
    
    public static final ConfiguredFeature<RandomFeatureConfig, ?> GREAT_OAK_FOREST_VEGETATION;
    public static final ConfiguredFeature<RandomFeatureConfig, ?> HEARTWOOD_TREE_RANDOM;
    public static final ConfiguredFeature<RandomFeatureConfig, ?> WILLOW_TREE_RANDOM;
    public static final ConfiguredFeature<RandomFeatureConfig, ?> ELM_TREE_RANDOM;
    public static final ConfiguredFeature<RandomFeatureConfig, ?> MYRTLE_TREE_RANDOM;
    public static final ConfiguredFeature<RandomFeatureConfig, ?> SYCAMORE_TREE_RANDOM;
    
    
    
    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TsArcanum.MOD_ID, name), configuredFeature);
    }
    
    
    
    static {
        GREAT_OAK_FOREST_VEGETATION = register("great_oak_forest_vegetation",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(TsTreeConfiguredFeatures.GREAT_OAK.withWouldSurviveFilter(TsSaplings.GREAT_OAK_SAPLING), 0.2f),
                        //new RandomFeatureEntry(TsTreeConfiguredFeatures.SYCAMORE.withWouldSurviveFilter(TsSaplings.SYCAMORE_SAPLING), 0.01f),
                        new RandomFeatureEntry(TreeConfiguredFeatures.JUNGLE_BUSH.withWouldSurviveFilter(Blocks.OAK_SAPLING), 0.4f),
                        new RandomFeatureEntry(TreeConfiguredFeatures.OAK.withWouldSurviveFilter(Blocks.OAK_SAPLING), 0.5f),
                        new RandomFeatureEntry(TreeConfiguredFeatures.BIRCH.withWouldSurviveFilter(Blocks.BIRCH_SAPLING), 0.7f)
                ),
                        TsTreeConfiguredFeatures.GREAT_OAK.withWouldSurviveFilter(TsSaplings.GREAT_OAK_SAPLING)
                )));
        
        // Placeholder
        HEARTWOOD_TREE_RANDOM = register("heartwood_tree_feature",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        TsTreeConfiguredFeatures.HEARTWOOD.withWouldSurviveFilter(TsSaplings.HEARTWOOD_SAPLING), 0.1f)),
                        TsTreeConfiguredFeatures.HEARTWOOD.withWouldSurviveFilter(TsSaplings.HEARTWOOD_SAPLING)
                )));
        WILLOW_TREE_RANDOM = register("willow_tree_feature",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        TsTreeConfiguredFeatures.WILLOW.withWouldSurviveFilter(TsSaplings.WILLOW_SAPLING), 0.1f)),
                        TsTreeConfiguredFeatures.WILLOW.withWouldSurviveFilter(TsSaplings.WILLOW_SAPLING)
                )));
        ELM_TREE_RANDOM = register("elm_tree_feature",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        TsTreeConfiguredFeatures.ELM.withWouldSurviveFilter(TsSaplings.ELM_SAPLING), 0.1f)),
                        TsTreeConfiguredFeatures.ELM.withWouldSurviveFilter(TsSaplings.ELM_SAPLING)
                )));
        MYRTLE_TREE_RANDOM = register("myrtle_tree_feature",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        TsTreeConfiguredFeatures.MYRTLE.withWouldSurviveFilter(TsSaplings.MYRTLE_SAPLING), 0.1f)),
                        TsTreeConfiguredFeatures.MYRTLE.withWouldSurviveFilter(TsSaplings.MYRTLE_SAPLING)
                )));
        SYCAMORE_TREE_RANDOM = register("sycamore_tree_feature",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        TsTreeConfiguredFeatures.SYCAMORE.withWouldSurviveFilter(TsSaplings.SYCAMORE_SAPLING), 0.1f)),
                        TsTreeConfiguredFeatures.SYCAMORE.withWouldSurviveFilter(TsSaplings.SYCAMORE_SAPLING)
                )));
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering ConfiguredFeatures");
    }
}
