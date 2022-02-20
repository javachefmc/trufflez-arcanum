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

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TsSpreadTrunkPlacer extends TrunkPlacer {

    public static final double circle = 6.28;
    
    //public static final Codec<TsSpreadTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
    //        fillTrunkPlacerFields(instance).apply(instance, TsSpreadTrunkPlacer::new));

    public static final Codec<TsSpreadTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return fillTrunkPlacerFields(instance).and(instance.group(
                IntProvider.createValidatingCodec(1, 100).fieldOf("branch_count").forGetter((placer) -> {
                    return placer.branchCount;
                }),
                IntProvider.createValidatingCodec(1, 100).fieldOf("bend_length").forGetter((placer) -> {
                    return placer.bendLength;
                }),
                IntProvider.createValidatingCodec(0, 100).fieldOf("branch_start").forGetter((placer) -> {
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
        
        
        
        // I will start with linear interpolation and figure out curves later
        
        
        
        int angle = (int) Math.round( Math.random() * circle ); // random angle in radians
        
        int mainBend = bendLength.get(random);
        int thisBranchCount = branchCount.get(random);
        int thisBranchStart = branchStart.get(random);

        float sizeX = (float) ( Math.sin(angle) * mainBend ),
                sizeZ = (float) ( Math.cos(angle) * mainBend ); // for main branch
        
        int mainBranchLength;
        
        int[] branchHeights = new int[thisBranchCount - 1];
        int[] branchAngles = new int[thisBranchCount - 1];
        BlockPos[] branchPositions = new BlockPos[thisBranchCount - 1];
        
        float branchHeightPercentage; // init outside loop
        for(int i = 0; i < branchHeights.length; i++) {
            branchHeights[i] = (int) thisBranchStart + ( i * ( ( height - thisBranchStart ) / ( thisBranchCount - 1 ) ) );
            branchAngles[i] = (int) ( ( i + 1 ) * ( circle / thisBranchCount ) ) + angle; // ok if angles roll over 360
            
            branchHeightPercentage = (float) branchHeights[i] / height;
            
            branchPositions[i] = startPos
                    .offset(Direction.Axis.X, (int) ( branchHeightPercentage * sizeX ))
                    .offset(Direction.Axis.Z, (int) ( branchHeightPercentage * sizeZ ))
                    .offset(Direction.Axis.Y, branchHeights[i] );
        }
        
        {
            System.out.println("Creating tree with properties:");
            System.out.println("Starting angle: " + angle);
            //System.out.println("SizeX/Z: "+sizeX+", "+sizeZ);
            //System.out.println("Main branch bend length: "+mainBend);
            //System.out.println("Main branch height: "+height); // not yet randomized
            System.out.println("BranchStart Height: " + thisBranchStart);
            System.out.println("BranchCount: " + thisBranchCount);
            System.out.println("BranchHeights: " + Arrays.toString(branchHeights));
            System.out.println("BranchAngles: " + Arrays.toString(branchAngles));
        }
        
        makeBranch(world, replacer, random, config, startPos, angle, height, mainBend);
        
        for(int i = 0; i < branchHeights.length; i++) {
            makeBranch(world, replacer, random, config,
                    branchPositions[i],
                    branchAngles[i],
                    height,
                    mainBend
            );
        }
        
        // locations where foliage will be placed
        return ImmutableList.of(
                new FoliagePlacer.TreeNode(startPos.up(height), 0, false)
        );
    }
    
    private void makeBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, BlockPos startPos, int angle, int branchHeight, int horizontalLength){
        float sizeX = (float) ( Math.sin(angle) * horizontalLength );
        float sizeZ = (float) ( Math.cos(angle) * horizontalLength );
        
        int branchLength = (int) Math.sqrt( Math.pow(horizontalLength, 2) + Math.pow(branchHeight, 2) );
        // linear interpolation for now. branchLength is essentially the number of times a block will need to be placed
        
        {
//        System.out.println("Creating branch with properties:");
//        System.out.println("Angle: "+angle);
//        System.out.println("SizeX/Z: "+sizeX+", "+sizeZ);
//        System.out.println("Bend Length: "+bendLength);
//        System.out.println("Height: "+branchHeight); // not yet randomized
//        System.out.println("Branch length: "+branchLength);
        }
        
        System.out.println("Current branch angle: " + angle);
        
        float yMoveMult = (float) branchHeight / branchLength; // vertical step amount
                                                                // also, why can't I just divide these without the cast?
        float yPercent;
        int yPos;
        
        for(int i = 0; i < branchLength; ++i) { // loop over main branch length, not tree height (some branches may be horizontal)
            yPos = (int) (i * yMoveMult); // Operating block height; Warning: int cast floors
            yPercent = (float) i / branchLength; // Current percent of height. Also, this cast again!
            
            getAndSetState(world, replacer, random, startPos.up( yPos )
                    .offset(Direction.Axis.X, (int) ( yPercent * sizeX ))
                    .offset(Direction.Axis.Z, (int) ( yPercent * sizeZ )), config
            );
        }
    }
}
