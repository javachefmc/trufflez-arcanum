package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsBlocks;
import com.trufflez.tsarcanum.world.feature.tree.TsFoliagePlacers;
import com.trufflez.tsarcanum.world.feature.tree.TsTrunkPlacers;
import com.trufflez.tsarcanum.world.feature.tree.foliageplacer.TsDroopyFoliagePlacer;
import com.trufflez.tsarcanum.world.feature.tree.foliageplacer.TsLargeFoliagePlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsCanopyTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsRootedTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsBranchyTrunkPlacer;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.TreeFeatureConfig.Builder;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.OptionalInt;


public class TsTreeConfiguredFeatures {
    
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> GREAT_OAK;
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> HEARTWOOD;
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> WILLOW;
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ELM;
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MYRTLE;
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> SYCAMORE;
    
    // New syntax:
    //public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BOXWOOD;
    
    private static Builder standard(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new Builder(BlockStateProvider.of(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.of(leaves),
                new BlobFoliagePlacer(ConstantIntProvider.create(radius),
                        ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }
    
    /*

            ALL OF THESE TREES ARE NOT FINAL!!

     */
    
    private static Builder greatOak() {
        return (new Builder(BlockStateProvider.of(TsBlocks.GREAT_OAK_LOG),
                new LargeOakTrunkPlacer(18, 2, 4),
                BlockStateProvider.of(TsBlocks.GREAT_OAK_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines();
    }

    private static Builder heartwood() {
        return (new Builder(BlockStateProvider.of(TsBlocks.HEARTWOOD_LOG),
                new TsRootedTrunkPlacer(8, 0, 0),
                BlockStateProvider.of(TsBlocks.HEARTWOOD_LEAVES),
                new TsLargeFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines();
    }

    private static Builder willow() {
        return (new Builder(BlockStateProvider.of(TsBlocks.WILLOW_LOG),
                new BendingTrunkPlacer(6, 0, 3, 8, ConstantIntProvider.create(3)),
                BlockStateProvider.of(TsBlocks.WILLOW_LEAVES),
                new TsDroopyFoliagePlacer(
                        ConstantIntProvider.create(1), // Radius?
                        ConstantIntProvider.create(0)), // Offset?
                new TwoLayersFeatureSize(2, 0, 2)
                ))
                .ignoreVines();
    }

    private static Builder elm() {
        return (new Builder(BlockStateProvider.of(TsBlocks.ELM_LOG),
                new TsCanopyTrunkPlacer(12, 1, 2,
                        UniformIntProvider.create(0, 10), // branch start height in percent
                        UniformIntProvider.create(6, 30), // extra branch count
                        UniformIntProvider.create(8, 9)  // bend length of main branch
                        ),
                BlockStateProvider.of(TsBlocks.ELM_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(1, 0, 1)
        )).ignoreVines();
    }

    private static Builder myrtle() {
        return (new Builder(BlockStateProvider.of(TsBlocks.MYRTLE_LOG),
                new TsBranchyTrunkPlacer(10, 1, 2,
                        UniformIntProvider.create(1, 3), // branch start height
                        UniformIntProvider.create(2, 3), // extra branch count
                        UniformIntProvider.create(2, 3)  // bend length of main branch
                ),
                BlockStateProvider.of(TsBlocks.MYRTLE_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(1, 0, 1)
        )).ignoreVines();
    }

    private static Builder sycamore() {
        return (new Builder(BlockStateProvider.of(TsBlocks.SYCAMORE_LOG),
                new TsCanopyTrunkPlacer(24, 2, 4,
                        UniformIntProvider.create(60, 65), // branch start height in percent
                        UniformIntProvider.create(4, 6), // extra branch count
                        UniformIntProvider.create(6, 8)  // bend length of main branch
                ),
                BlockStateProvider.of(TsBlocks.SYCAMORE_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(1, 0, 1)
        )).ignoreVines();
    }
    

    private static Builder fancyOak() { // default large oak generation
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
        TsTrunkPlacers.init();
        TsFoliagePlacers.init();
        
        GREAT_OAK = ConfiguredFeatures.register("great_oak", Feature.TREE, greatOak().build());
        HEARTWOOD = ConfiguredFeatures.register("heartwood", Feature.TREE, heartwood().build());
        WILLOW = ConfiguredFeatures.register("willow", Feature.TREE, willow().build());
        ELM = ConfiguredFeatures.register("elm", Feature.TREE, elm().build());
        MYRTLE = ConfiguredFeatures.register("myrtle", Feature.TREE, myrtle().build());
        SYCAMORE = ConfiguredFeatures.register("sycamore", Feature.TREE, sycamore().build());
    }
    public static void init() {
        TsArcanum.LOGGER.debug("Registering TreeConfiguredFeatures");
    }
}
