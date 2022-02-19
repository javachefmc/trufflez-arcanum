package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.TreeFeatureConfig.Builder;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.OptionalInt;

@SuppressWarnings("unused")
public class TsTreeConfiguredFeatures {
    
    public static final ConfiguredFeature<TreeFeatureConfig, ?> GREAT_OAK;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> HEARTWOOD;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> WILLOW;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> ELM;
    
    // Check AbstractTreeGrower for growing trees

    /*
     * Currently I'm using fancy oak code to generate all four trees. 
     * Yes, there will be updated tree models but that's not the highest priority yet
     */
    
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

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TsArcanum.MOD_ID, name),
                configuredFeature);
    }
    
    static {
        GREAT_OAK = ConfiguredFeatures.register("great_oak", Feature.TREE.configure(greatOak().build()));
        HEARTWOOD = ConfiguredFeatures.register("heartwood", Feature.TREE.configure(heartwood().build()));
        WILLOW = ConfiguredFeatures.register("willow", Feature.TREE.configure(willow().build()));
        ELM = ConfiguredFeatures.register("elm", Feature.TREE.configure(elm().build()));
    }
    
    public static void init() {
        TsArcanum.LOGGER.info("Registering TreeConfiguredFeatures");
    }
}
