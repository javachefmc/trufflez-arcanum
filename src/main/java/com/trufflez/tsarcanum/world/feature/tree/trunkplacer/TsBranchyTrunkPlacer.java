package com.trufflez.tsarcanum.world.feature.tree.trunkplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.trufflez.tsarcanum.util.TsMath;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TsBranchyTrunkPlacer extends TrunkPlacer {

    public static final float circle = 6.28f; // this is in radians

    public static final Codec<TsBranchyTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> fillTrunkPlacerFields(instance).and(instance.group(
            IntProvider.createValidatingCodec(1, 10).fieldOf("branch_count").forGetter((placer) -> placer.branchCount),
            IntProvider.createValidatingCodec(1, 10).fieldOf("bend_length").forGetter((placer) -> placer.bendLength),
            IntProvider.createValidatingCodec(0, 100).fieldOf("branch_start").forGetter((placer) -> placer.branchStart)
    )).apply(instance, TsBranchyTrunkPlacer::new));

    private final IntProvider branchCount;
    private final IntProvider bendLength;
    private final IntProvider branchStart;
    
    public TsBranchyTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight, IntProvider branchStart, IntProvider branchCount, IntProvider bendLength) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.branchStart = branchStart;
        this.branchCount = branchCount;
        this.bendLength = bendLength;
    }
    
    @Override
    protected TrunkPlacerType<?> getType() {
        return TsTrunkPlacers.BRANCHY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        
        setToDirt(world, replacer, random, startPos.down(), config); // dirt under tree
        
        // TODO: max branch start height
        // I will start with linear interpolation and figure out curves later

        List<FoliagePlacer.TreeNode> FoliageList = new ArrayList<>();
        
        int angle = (int) Math.round( Math.random() * circle ); // random angle in radians
        
        int thisBranchCount = branchCount.get(random);
        int thisBranchStart = branchStart.get(random);
        int thisBendLength = bendLength.get(random);
        
        float sizeX = TsMath.sin(angle) * thisBendLength;
        float sizeZ = TsMath.cos(angle) * thisBendLength;
        
        makeBranch(world, replacer, random, config, FoliageList, startPos, angle, height, thisBendLength); // TODO: merge with loop below
        
        int branchHeight;
        float branchHeightPercentage; // init outside loop
        
        for(int i = 0; i < thisBranchCount; i++) {
            branchHeight = thisBranchStart + ( i * ( ( height - thisBranchStart ) / thisBranchCount ) ); // int division floors
            branchHeightPercentage = (float) branchHeight / height;

            makeBranch(world, replacer, random, config, FoliageList,
                    startPos.offset(Direction.Axis.X, (int) (branchHeightPercentage * sizeX))   // Branch Start Position
                            .offset(Direction.Axis.Z, (int) (branchHeightPercentage * sizeZ))
                            .offset(Direction.Axis.Y, branchHeight),
                    (int) ( ( i + 1 ) * ( circle / thisBranchCount ) ) + angle,                 // Branch Angle
                    (int) ( (1 - branchHeightPercentage) * height),                             // Branch Height
                    (int) ( (1 - branchHeightPercentage) * bendLength.get(random) ) + 4         // Branch Horizontal Length
            );
        }
        return FoliageList;
    }
    
    private void makeBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, List<FoliagePlacer.TreeNode> FoliageList, BlockPos startPos, int angle, int branchHeight, int horizontalLength){
        float sizeX = TsMath.sin(angle) * horizontalLength;
        float sizeZ = TsMath.cos(angle) * horizontalLength;
        int branchLength = (int) Math.sqrt( Math.pow(horizontalLength, 2) + Math.pow(branchHeight, 2) ); // branchLength is used to count how many blocks need to be placed
        float yStep = (float) branchHeight / branchLength; // vertical step amount per (potentially horizontal) branch block
        float yPercent;
        int yPos = 0;
        
        System.out.println("Creating branch with properties: ");
        System.out.println("SizeX: "+sizeX);
        System.out.println("SizeZ: "+sizeZ);
        System.out.println("branchLength: "+branchLength);
        System.out.println("angle: "+angle);
        
        for(int i = 0; i < branchLength; ++i) { // loop over main branch length, not tree height (some branches may be horizontal)
            yPos = (int) (i * yStep); // Operating block height; Warning: int cast floors. Sometimes this results in a shorter branch, I think
            yPercent = (float) i / branchLength; // Current percent of height.
            getAndSetState(world, replacer, random, startPos.up( yPos )
                    .offset(Direction.Axis.X, (int) ( yPercent * sizeX ))
                    .offset(Direction.Axis.Z, (int) ( yPercent * sizeZ )), config
            );
        }
        
        FoliageList.add(new FoliagePlacer.TreeNode(startPos.up(yPos)
                .offset(Direction.Axis.X, (int) sizeX)
                .offset(Direction.Axis.Z, (int) sizeZ), 0, false)
        );
    }
}

 /* // This code (for function generate) is arguably better but more verbose
        int mainBranchLength;
        int[] branchHeights = new int[thisBranchCount - 1];
        int[] branchAngles = new int[thisBranchCount - 1];
        int[] branchSizesY = new int[thisBranchCount - 1];
        int[] branchBends = new int[thisBranchCount - 1];
        BlockPos[] branchPositions = new BlockPos[thisBranchCount];
        
        for(int i = 0; i < ( thisBranchCount ); i++) {
            branchHeights[i] = (int) thisBranchStart + ( i * ( ( height - thisBranchStart ) / ( thisBranchCount - 1 ) ) );
            branchAngles[i] = (int) ( ( i + 1 ) * ( circle / thisBranchCount ) ) + angle; // ok if angles roll over 360
            
            float branchHeightPercentage = (float) branchHeights[i] / height;
            
            branchSizesY[i] = (int) ( (1 - branchHeightPercentage) * height);
            branchBends[i] = (int) ( (1 - branchHeightPercentage) * thisBendLength ) + 2;
            
            branchPositions[i] = startPos
                    .offset(Direction.Axis.X, (int) (branchHeightPercentage * sizeX))
                    .offset(Direction.Axis.Z, (int) (branchHeightPercentage * sizeZ))
                    .offset(Direction.Axis.Y, branchHeights[i]);
         }
         shuffleArray(branchAngles);
         for(int i = 0; i < branchHeights.length; i++) {
            makeBranch(world, replacer, random, config, FoliageList,
                    branchPositions[i],
                    branchAngles[i],
                    branchSizesY[i],
                    branchBends[i]
            );
        }
        */