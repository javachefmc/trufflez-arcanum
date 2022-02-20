package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsBlocks;
import com.trufflez.tsarcanum.world.feature.tree.foliageplacer.TsDroopyFoliagePlacer;
import com.trufflez.tsarcanum.world.feature.tree.foliageplacer.TsLargeFoliagePlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsLargeTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsRootedTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsSpreadTrunkPlacer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
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
    
    public static final ConfiguredFeature<TreeFeatureConfig, ?> GREAT_OAK;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> HEARTWOOD;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> WILLOW;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> ELM;
    
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
                new TsLargeTrunkPlacer(8, 0, 0),
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
                        ConstantIntProvider.create(0)),
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
                new TsSpreadTrunkPlacer(8, 0, 0,
                        UniformIntProvider.create(0, 0), // branch start height
                        UniformIntProvider.create(3, 3), // branch number
                        UniformIntProvider.create(6, 6)  // bend length of main branch
                        ),
                BlockStateProvider.of(Blocks.AIR),
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
        GREAT_OAK = ConfiguredFeatures.register("great_oak", Feature.TREE.configure(greatOak().build()));
        HEARTWOOD = ConfiguredFeatures.register("heartwood", Feature.TREE.configure(heartwood().build()));
        WILLOW = ConfiguredFeatures.register("willow", Feature.TREE.configure(willow().build()));
        ELM = ConfiguredFeatures.register("elm", Feature.TREE.configure(elm().build()));
    }
    
    public static void init() {
        TsArcanum.LOGGER.info("Registering TreeConfiguredFeatures");
    }
}
