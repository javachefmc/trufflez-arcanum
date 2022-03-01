package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsSaplings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;


public class TsConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> GREAT_OAK_FOREST_VEGETATION;
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> HEARTWOOD_TREE_RANDOM;
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WILLOW_TREE_RANDOM;
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ELM_TREE_RANDOM;
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MYRTLE_TREE_RANDOM;
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> SYCAMORE_TREE_RANDOM;
    
    
    
    /*private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }*/
    
    // new syntax:
    //SINGLE_PIECE_OF_GRASS = ConfiguredFeatures.register("single_piece_of_grass", Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS.getDefaultState())));
    
    /*public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TsArcanum.MOD_ID, name), configuredFeature);
    }*/
    
    /*
    public static RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> register(String id, Feature<DefaultFeatureConfig> feature) {
        return register(id, feature, FeatureConfig.DEFAULT);
    }*/
    
    static {
        GREAT_OAK_FOREST_VEGETATION = ConfiguredFeatures.register("great_oak_forest_vegetation", // TODO: convert members to placedfeatures
                Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(PlacedFeatures.createEntry(TsTreeConfiguredFeatures.GREAT_OAK), 0.2f),
                        //new RandomFeatureEntry(TsTreeConfiguredFeatures.SYCAMORE.withWouldSurviveFilter(TsSaplings.SYCAMORE_SAPLING), 0.01f),
                        new RandomFeatureEntry(PlacedFeatures.createEntry(TreeConfiguredFeatures.JUNGLE_BUSH), 0.4f),
                        new RandomFeatureEntry(PlacedFeatures.createEntry(TreeConfiguredFeatures.OAK), 0.5f),
                        new RandomFeatureEntry(PlacedFeatures.createEntry(TreeConfiguredFeatures.BIRCH), 0.7f)
                ), PlacedFeatures.createEntry(TsTreeConfiguredFeatures.GREAT_OAK)));

        // Placeholder
        HEARTWOOD_TREE_RANDOM = ConfiguredFeatures.register("heartwood_tree_feature",
                Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.HEARTWOOD), 0.1f)),
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.HEARTWOOD)));
        WILLOW_TREE_RANDOM = ConfiguredFeatures.register("willow_tree_feature",
                Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.WILLOW), 0.1f)),
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.WILLOW)));
        ELM_TREE_RANDOM = ConfiguredFeatures.register("elm_tree_feature",
                Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.ELM), 0.1f)),
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.ELM)));
        MYRTLE_TREE_RANDOM = ConfiguredFeatures.register("myrtle_tree_feature",
                Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.MYRTLE), 0.1f)),
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.MYRTLE)));
        SYCAMORE_TREE_RANDOM = ConfiguredFeatures.register("sycamore_tree_feature",
                Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.SYCAMORE), 0.1f)),
                        PlacedFeatures.createEntry(TsTreeConfiguredFeatures.SYCAMORE)));
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering ConfiguredFeatures");
    }
}
