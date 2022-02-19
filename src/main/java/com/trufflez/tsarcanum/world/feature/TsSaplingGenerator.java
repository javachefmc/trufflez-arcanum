package com.trufflez.tsarcanum.world.feature;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

@SuppressWarnings("unused")
public class TsSaplingGenerator extends SaplingGenerator {
    /*
    
    CHECK THIS GUY:
    https://www.youtube.com/watch?v=mnOwoQSjztw&list=PLKGarocXCE1FKR-UzlU1l9qrPhnE36qFe&index=44
    
    FOR UPDATING THIS CODE
    
     */
    private final ConfiguredFeature<TreeFeatureConfig, ?> feature;

    public TsSaplingGenerator(ConfiguredFeature<?, ?> feature) {
        this.feature = (ConfiguredFeature<TreeFeatureConfig, ?>) feature;
    }

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return feature;
    }
}
