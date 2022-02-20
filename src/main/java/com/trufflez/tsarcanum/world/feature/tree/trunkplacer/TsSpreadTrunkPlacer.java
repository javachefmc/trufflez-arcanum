package com.trufflez.tsarcanum.world.feature.tree.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.trufflez.tsarcanum.world.feature.tree.TsTrunkPlacers;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TsSpreadTrunkPlacer extends TrunkPlacer {
    
    //public static final Codec<TsSpreadTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
    //        fillTrunkPlacerFields(instance).apply(instance, TsSpreadTrunkPlacer::new));

    public static final Codec<TsSpreadTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return fillTrunkPlacerFields(instance).and(instance.group(
                IntProvider.createValidatingCodec(1, 20).fieldOf("branch_count").forGetter((placer) -> {
                    return placer.branchCount;
                }),
                IntProvider.createValidatingCodec(1, 20).fieldOf("bend_length").forGetter((placer) -> {
                    return placer.bendLength;
                }),
                IntProvider.createValidatingCodec(0, 20).fieldOf("branch_start").forGetter((placer) -> {
                    return placer.branchStart;
                })
        )).apply(instance, TsSpreadTrunkPlacer::new);
    });

    private final IntProvider branchCount;
    private final IntProvider bendLength;
    private final IntProvider branchStart;
    
    public TsSpreadTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight, IntProvider branchStart, IntProvider branchCount, IntProvider bendLength) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.branchStart = branchStart;
        this.branchCount = branchCount;
        this.bendLength = bendLength;
    }
    
    @Override
    protected TrunkPlacerType<?> getType() {
        return TsTrunkPlacers.SPREAD_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        
        setToDirt(world, replacer, random, startPos.down(), config);
        
        
        /*
        
        Below is what I want to do, and hopefully someone smart (or I) can implement this
        
        Parameters we will need:
        - Height of tree
        - # of branches total
        - Width of tree (branch bend length)
        - Height at which new branches start
        
        One branch will be the main branch, and the rest will come off of it
        
        1. Get starting branch angle (random number)
        2. Calculate path of main branch based on horizontal bend and tree height ?
        3. Divide circle by # of branches for horizontal spread
        4. Divide (tree max height - branch start height) by # of branches for vertical spread
        5. For each additional branch:
            1. Choose angle from calculated list of angles
            2. Decrease branch bend length by inverse function of height
            3. Assign branch height by inverse function of height
            4. Assign foliage placer 
        
         */
        
        
        
        // I will start with linear interpolation
        // and figure curves out later
        
        
        int angle = (int) Math.round( Math.random() * 360 ); // Math.random does not include 1, but 0 = 360
                                                             // honestly though, this is a tree
        float sizeX, sizeZ;
        int distance;
        int mainBend = bendLength.get(random);
        
        sizeX = (float) (Math.sin(angle)*mainBend);
        sizeZ = (float) (Math.cos(angle)*mainBend);
        
        System.out.println("Creating tree with properties:");
        System.out.println("Angle: "+angle);
        System.out.println("SizeX/Z: "+sizeX+", "+sizeZ);
        System.out.println("Bend Length: "+mainBend);
        System.out.println("Height: "+height);
        
        
        distance = (int) Math.sqrt(Math.pow(mainBend,2)+Math.pow(height,2));
        
        
        int i;
        for(i = 0; i < height; ++i) {
            getAndSetState(world, replacer, random, startPos.up(i)
                            .offset(Direction.Axis.X, (int) (i*(sizeX/distance)))
                            .offset(Direction.Axis.Z, (int) (i*(sizeZ/distance))), config);
            //System.out.println();
        }
        
        
        // locations where foliage will be placed
        return ImmutableList.of(
                new FoliagePlacer.TreeNode(startPos.up(height), 0, false)
        );
    }
}
