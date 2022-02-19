package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;


public class TsConfiguredFeatures {
    //public static final RegistryKey<ConfiguredFeature<?, ?>> GREAT_OAK_TREE_KEY;
    
    
    
    
    
    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TsArcanum.MOD_ID, name), configuredFeature);
    }
    
    
    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }
    
    
    public static void init() {
        /*ConfiguredFeature<RandomFeatureConfig, ?> GREAT_OAK_TREE_RANDOM = register("great_oak_tree_feature", //public static final 
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        TsTreeConfiguredFeatures.GREAT_OAK.withWouldSurviveFilter(TsSaplings.GREAT_OAK_SAPLING), 0.1f)),
                        TsTreeConfiguredFeatures.GREAT_OAK.withWouldSurviveFilter(TsSaplings.GREAT_OAK_SAPLING)
                )));*/
    }
}
