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

    public static final double circle = 6.28; // this is in radians
    
    //public static final Codec<TsSpreadTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
    //        fillTrunkPlacerFields(instance).apply(instance, TsSpreadTrunkPlacer::new));

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

    private static void shuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    
    @Override
    protected TrunkPlacerType<?> getType() {
        return TsTrunkPlacers.BRANCHY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        
        setToDirt(world, replacer, random, startPos.down(), config);
        
        /*
        
        To implement:
        - branch max height (we already have branch min height)
        
         */
        
        // I will start with linear interpolation and figure out curves later

        List<FoliagePlacer.TreeNode> FoliageList = new ArrayList<>();
        
        int angle = (int) Math.round( Math.random() * circle ); // random angle in radians
        
        int thisBranchCount = branchCount.get(random);
        int thisBranchStart = branchStart.get(random);
        
        int thisBendLength = bendLength.get(random);
        float sizeX = TsMath.sin(angle) * thisBendLength,
                sizeZ = TsMath.cos(angle) * thisBendLength;
        
        //int mainBranchLength;
        
//        int[] branchHeights = new int[thisBranchCount - 1];
//        int[] branchAngles = new int[thisBranchCount - 1];
//        int[] branchSizesY = new int[thisBranchCount - 1];
//        int[] branchBends = new int[thisBranchCount - 1];
        
        //BlockPos[] branchPositions = new BlockPos[thisBranchCount];
        
        makeBranch(world, replacer, random, config, FoliageList, startPos, angle, height, thisBendLength);
        
        int branchHeight;
        float branchHeightPercentage; // init outside loop
        
        for(int i = 0; i < ( thisBranchCount ); i++) {
            
            branchHeight = (int) thisBranchStart + ( i * ( ( height - thisBranchStart ) / thisBranchCount ) );
            branchHeightPercentage = (float) branchHeight / height;
            
            /*branchHeights[i] = (int) thisBranchStart + ( i * ( ( height - thisBranchStart ) / ( thisBranchCount - 1 ) ) );
            branchAngles[i] = (int) ( ( i + 1 ) * ( circle / thisBranchCount ) ) + angle; // ok if angles roll over 360
            
            float branchHeightPercentage = (float) branchHeights[i] / height;
            
            branchSizesY[i] = (int) ( (1 - branchHeightPercentage) * height);
            branchBends[i] = (int) ( (1 - branchHeightPercentage) * thisBendLength ) + 2;
            
            branchPositions[i] = startPos
                    .offset(Direction.Axis.X, (int) (branchHeightPercentage * sizeX))
                    .offset(Direction.Axis.Z, (int) (branchHeightPercentage * sizeZ))
                    .offset(Direction.Axis.Y, branchHeights[i]);*/

            makeBranch(world, replacer, random, config, FoliageList,
                    startPos.offset(Direction.Axis.X, (int) (branchHeightPercentage * sizeX))   // Branch Start Position
                            .offset(Direction.Axis.Z, (int) (branchHeightPercentage * sizeZ))
                            .offset(Direction.Axis.Y, branchHeight),
                    (int) ( ( i + 1 ) * ( circle / thisBranchCount ) ) + angle,                 // Branch Angle
                    (int) ( (1 - branchHeightPercentage) * height),                             // Branch Height
                    (int) ( (1 - branchHeightPercentage) * bendLength.get(random) ) + 4                 // Branch Horizontal Length
            );
        }
        
        
        
        //Branches that are 25 degrees apart can merge. "Fixed" above by adding constant to branch bend width
        //shuffleArray(branchAngles);
        
        /*for(int i = 0; i < branchHeights.length; i++) {
            makeBranch(world, replacer, random, config, FoliageList,
                    branchPositions[i],
                    branchAngles[i],
                    branchSizesY[i],
                    branchBends[i]
            );
        }*/
        
        return FoliageList;
    }
    
    private void makeBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, List<FoliagePlacer.TreeNode> FoliageList, BlockPos startPos, int angle, int branchHeight, int horizontalLength){
        float sizeX = TsMath.sin(angle) * horizontalLength;
        float sizeZ = TsMath.cos(angle) * horizontalLength;
        
        int branchLength = (int) Math.sqrt( Math.pow(horizontalLength, 2) + Math.pow(branchHeight, 2) );
        // linear interpolation for now. branchLength is essentially the number of times a block will need to be placed
        
        float yStep = (float) branchHeight / branchLength; // vertical step amount
                                                                // also, why can't I just divide these without the cast?
        float yPercent;
        int yPos = 0;
        
        for(int i = 0; i < branchLength; ++i) { // loop over main branch length, not tree height (some branches may be horizontal)
            yPos = (int) (i * yStep); // Operating block height; Warning: int cast floors. Sometimes this results in a shorter branch, I think
            yPercent = (float) i / branchLength; // Current percent of height
            
            getAndSetState(world, replacer, random, startPos.up( yPos )
                    .offset(Direction.Axis.X, (int) ( yPercent * sizeX ))
                    .offset(Direction.Axis.Z, (int) ( yPercent * sizeZ )), config
            );
        }
        
        FoliageList.add(new FoliagePlacer.TreeNode(
                        startPos.up(yPos)
                                .offset(Direction.Axis.X, (int) sizeX)
                                .offset(Direction.Axis.Z, (int) sizeZ), 
                0, false)
        );
    }
}
