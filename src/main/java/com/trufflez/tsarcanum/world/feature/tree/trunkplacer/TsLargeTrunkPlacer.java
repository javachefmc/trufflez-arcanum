package com.trufflez.tsarcanum.world.feature.tree.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.trufflez.tsarcanum.world.feature.tree.TsTrunkPlacers;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TsLargeTrunkPlacer extends TrunkPlacer {
    
    public static final Codec<TsLargeTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillTrunkPlacerFields(instance).apply(instance, TsLargeTrunkPlacer::new));
    
    public TsLargeTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return TsTrunkPlacers.LARGE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);

        for(int i = 0; i < height; ++i) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }

        return ImmutableList.of(
                new FoliagePlacer.TreeNode(startPos.up(height), 0, false),
                new FoliagePlacer.TreeNode(startPos.up(height), 0, false)
        );
    }
}
