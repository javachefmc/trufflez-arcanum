package com.trufflez.tsarcanum.world.feature.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.trufflez.tsarcanum.world.feature.tree.TsFoliagePlacers;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Random;
import java.util.function.BiConsumer;

public class TsDroopyFoliagePlacer extends FoliagePlacer {
    public static final Codec<TsDroopyFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> 
            fillFoliagePlacerFields(instance).apply(instance, TsDroopyFoliagePlacer::new));

    public TsDroopyFoliagePlacer(IntProvider intProvider, IntProvider intProvider2) {
        super(intProvider, intProvider2);
    }

    protected FoliagePlacerType<?> getType() {
        return TsFoliagePlacers.DROOPY_FOLIAGE_PLACER;
    }

    protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        
        // TODO: Placeholder
        
        BlockPos blockPos = treeNode.getCenter().up(offset);
        boolean bl = treeNode.isGiantTrunk();
        
        this.generateSquare(world, replacer, random, config, blockPos, radius + 2, -1, bl);
        this.generateSquare(world, replacer, random, config, blockPos, radius + 1, 0, bl);
    }

    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == -1 && !giantTrunk) {
            return dx == radius && dz == radius;
        } else if (y == 1) {
            return dx + dz > radius * 2 - 2;
        } else {
            return false;
        }
    }
}
