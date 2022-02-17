package com.trufflez.tsarcanum.gen.feature;

import com.trufflez.tsarcanum.blocks.TsBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.TreeFeatureConfig.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.OptionalInt;

@SuppressWarnings("unused")
public class TsConfiguredFeatures {
    public static ConfiguredFeature<TreeFeatureConfig, ?> GREAT_OAK;
    public static ConfiguredFeature<TreeFeatureConfig, ?> HEARTWOOD;
    public static ConfiguredFeature<TreeFeatureConfig, ?> WILLOW;
    public static ConfiguredFeature<TreeFeatureConfig, ?> ELM;
    
    public TsConfiguredFeatures() {
        
    }
    
    // Check AbstractTreeGrower for growing trees
    
    private static Builder greatOak() {
        return (new Builder(BlockStateProvider.of(TsBlocks.GREAT_OAK_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(TsBlocks.GREAT_OAK_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines();
    }

    private static Builder heartwood() {
        return (new Builder(BlockStateProvider.of(TsBlocks.HEARTWOOD_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(TsBlocks.HEARTWOOD_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines();
    }

    private static Builder willow() {
        return (new Builder(BlockStateProvider.of(TsBlocks.WILLOW_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(TsBlocks.WILLOW_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines();
    }

    private static Builder elm() {
        return (new Builder(BlockStateProvider.of(TsBlocks.ELM_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(TsBlocks.ELM_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines();
    }
    
    public static void init() {
        GREAT_OAK = ConfiguredFeatures.register("great_oak", Feature.TREE.configure(greatOak().build()));
        HEARTWOOD = ConfiguredFeatures.register("heartwood", Feature.TREE.configure(heartwood().build()));
        WILLOW = ConfiguredFeatures.register("willow", Feature.TREE.configure(willow().build()));
        ELM = ConfiguredFeatures.register("elm", Feature.TREE.configure(elm().build()));
    }
}
