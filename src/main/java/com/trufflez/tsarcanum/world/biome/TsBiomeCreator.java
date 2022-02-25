package com.trufflez.tsarcanum.world.biome;

import com.trufflez.tsarcanum.world.feature.TsPlacedFeatures;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import org.jetbrains.annotations.Nullable;

public class TsBiomeCreator {
    protected static final int DEFAULT_WATER_COLOR = 4159204;
    protected static final int DEFAULT_WATER_FOG_COLOR = 329011;
    private static final int DEFAULT_FOG_COLOR = 12638463;
    @Nullable
    private static final MusicSound DEFAULT_MUSIC = null;
    
    public TsBiomeCreator() {
        
    }
    
    protected static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    private static Biome createBiome(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, SpawnSettings.Builder spawnSettings, net.minecraft.world.biome.GenerationSettings.Builder generationSettings, @Nullable MusicSound music) {
        return createBiome(precipitation, category, temperature, downfall, 4159204, 329011, spawnSettings, generationSettings, music);
    }

    private static Biome createBiome(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, int waterColor, int waterFogColor, SpawnSettings.Builder spawnSettings, net.minecraft.world.biome.GenerationSettings.Builder generationSettings, @Nullable MusicSound music) {
        return (new net.minecraft.world.biome.Biome.Builder()).precipitation(precipitation).category(category).temperature(temperature).downfall(downfall).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(getSkyColor(temperature)).moodSound(BiomeMoodSound.CAVE).music(music).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    private static void addBasicFeatures(net.minecraft.world.biome.GenerationSettings.Builder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }
    
    public static Biome createGreatOakForest() {
        SpawnSettings.Builder spawnSettingsBuilder = new SpawnSettings.Builder();
        //DefaultBiomeFeatures.addFarmAnimals(spawnSettingsBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettingsBuilder);
        net.minecraft.world.biome.GenerationSettings.Builder genBuilder = new net.minecraft.world.biome.GenerationSettings.Builder();
        addBasicFeatures(genBuilder);

        genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_JUNGLE);
        genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TsPlacedFeatures.GREAT_OAK_PLACED); //VegetationPlacedFeatures.DARK_FOREST_VEGETATION
        
        DefaultBiomeFeatures.addDefaultOres(genBuilder);            // Normal ores and magma
        DefaultBiomeFeatures.addDefaultDisks(genBuilder);           // sand, clay, gravel
        DefaultBiomeFeatures.addForestGrass(genBuilder);            // grass
        DefaultBiomeFeatures.addDefaultMushrooms(genBuilder);       // 
        
        return (new net.minecraft.world.biome.Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.FOREST)
                .temperature(0.7F)
                .downfall(0.8F)
                .effects((new net.minecraft.world.biome.BiomeEffects.Builder())
                        .waterColor(1391452)
                        .waterFogColor(596779)
                        .fogColor(7574665)
                        .skyColor(7574665)
                        .grassColor(7574665)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettingsBuilder.build()).generationSettings(genBuilder.build()).build();
    }
    
    
}
