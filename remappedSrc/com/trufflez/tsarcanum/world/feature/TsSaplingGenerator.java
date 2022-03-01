package com.trufflez.tsarcanum.world.feature;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("unchecked") // We cannot get rid of the error so we ignore it..
public class TsSaplingGenerator extends SaplingGenerator {
    private final ConfiguredFeature<TreeFeatureConfig, ?> feature;

    public TsSaplingGenerator(ConfiguredFeature<?, ?> feature) {
        
        this.feature = (ConfiguredFeature<TreeFeatureConfig, ?>) feature;
    }
    
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return feature;
    }
}
