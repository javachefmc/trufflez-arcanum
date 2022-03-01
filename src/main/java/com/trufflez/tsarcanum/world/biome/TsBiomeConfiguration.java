package com.trufflez.tsarcanum.world.biome;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.world.feature.TsPlacedFeatures;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import org.jetbrains.annotations.Nullable;

public abstract class TsBiomeConfiguration {
    
    // Convert to RegistryEntry<Biome> if access is necessary
    //public static final Biome GREAT_OAK_FOREST = 
    static {
        //register(TsBiomeKeys.GREAT_OAK_FOREST, createGreatOakForest());
    }
    
    protected static final int DEFAULT_WATER_COLOR = 4159204;
    protected static final int DEFAULT_WATER_FOG_COLOR = 329011;
    private static final int DEFAULT_FOG_COLOR = 12638463;
    @Nullable
    private static final MusicSound DEFAULT_MUSIC = null;
    
    protected static int getSkyColor(float temperature) { // vanilla temperature-based sky color
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
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
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettingsBuilder);
        
        net.minecraft.world.biome.GenerationSettings.Builder genBuilder = new net.minecraft.world.biome.GenerationSettings.Builder();
        addBasicFeatures(genBuilder);
        
        DefaultBiomeFeatures.addMossyRocks(genBuilder);
        DefaultBiomeFeatures.addLargeFerns(genBuilder);

        genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_TALL_GRASS);
        genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_NORMAL);
        genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TsPlacedFeatures.GREAT_OAK_VEGETATION_PLACED);
        //genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TsPlacedFeatures.SYCAMORE_PLACED);
        // TODO: fix sycamore placement
        
        DefaultBiomeFeatures.addDefaultOres(genBuilder);            // ores and magma
        DefaultBiomeFeatures.addDefaultDisks(genBuilder);           // sand, clay, gravel
        
        genBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TsPlacedFeatures.BROWN_MUSHROOM_OLD_GROWTH);
        
        return (new net.minecraft.world.biome.Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.FOREST)
                .temperature(0.7F)
                .downfall(0.8F)
                .effects((new net.minecraft.world.biome.BiomeEffects.Builder())
                        .waterColor(1391452)
                        .waterFogColor(596779)
                        .fogColor(10007466)
                        .skyColor(7574665)
                        .grassColor(3434816)
                        //.foliageColor(2391347)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettingsBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }
    
    private static void register(RegistryKey<Biome> key, Biome biome) {
        //return (Biome) BuiltinRegistries.set(BuiltinRegistries.BIOME, key, biome);
        BuiltinRegistries.add(BuiltinRegistries.BIOME, key, biome);
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering biomes");
    }
}
