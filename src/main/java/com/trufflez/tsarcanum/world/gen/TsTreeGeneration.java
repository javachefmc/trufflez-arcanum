package com.trufflez.tsarcanum.world.gen;

import com.trufflez.tsarcanum.world.feature.TsPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class TsTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, TsPlacedFeatures.GREAT_OAK_KEY);
    }
}
