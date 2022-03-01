package com.trufflez.tsarcanum.world.feature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TsPlacedFeatures {
    
    public static final RegistryKey<PlacedFeature> GREAT_OAK_KEY = registerKey("great_oak_spawn"); // Is this still used?
    public static final RegistryKey<PlacedFeature> HEARTWOOD_KEY = registerKey("heartwood_spawn");
    public static final RegistryKey<PlacedFeature> WILLOW_KEY = registerKey("willow_spawn");
    public static final RegistryKey<PlacedFeature> ELM_KEY = registerKey("elm_spawn");
    public static final RegistryKey<PlacedFeature> MYRTLE_KEY = registerKey("myrtle_spawn");
    public static final RegistryKey<PlacedFeature> SYCAMORE_KEY = registerKey("sycamore_spawn");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_OLD_GROWTH_KEY = registerKey("brown_mushroom_old_growth_spawn");
    
    public static final RegistryEntry<PlacedFeature> GREAT_OAK_VEGETATION_PLACED;
    public static final RegistryEntry<PlacedFeature> HEARTWOOD_PLACED;
    public static final RegistryEntry<PlacedFeature> WILLOW_PLACED;
    public static final RegistryEntry<PlacedFeature> ELM_PLACED;
    public static final RegistryEntry<PlacedFeature> MYRTLE_PLACED;
    public static final RegistryEntry<PlacedFeature> SYCAMORE_PLACED;
    public static final RegistryEntry<PlacedFeature> BROWN_MUSHROOM_OLD_GROWTH;
    
    public static final PlacementModifier NOT_IN_SURFACE_WATER_MODIFIER;
    
    public TsPlacedFeatures() {
    }
    
    /*
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }*/
    
    public static List<PlacementModifier> modifiers(int count) {
        return List.of(CountPlacementModifier.of(count), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    }
    
    private static List<PlacementModifier> modifiersWithChance(int chance, @Nullable PlacementModifier modifier) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (modifier != null) {
            builder.add(modifier);
        }
    
        if (chance != 0) {
            builder.add(RarityFilterPlacementModifier.of(chance));
        }
    
        builder.add(SquarePlacementModifier.of());
        builder.add(PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
        builder.add(BiomePlacementModifier.of());
        return builder.build();
    }
    
    /*
    private static Builder<PlacementModifier> modifiersBuilder(PlacementModifier countModifier) {
        return ImmutableList.builder()
                .add(countModifier)
                .add(SquarePlacementModifier.of())
                .add(NOT_IN_SURFACE_WATER_MODIFIER)
                .add(PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP)
                .add(BiomePlacementModifier.of());
    }*/
    
    /*
    public static List<PlacementModifier> modifiers(PlacementModifier modifier) {
        return VegetationPlacedFeatures.modifiersBuilder(modifier).build();
        //return ImmutableList.builder().add(modifier).build();
    }*/
    
    /*
    public static List<PlacementModifier> modifiersWithWouldSurvive(PlacementModifier modifier, Block block) {
        return modifiersBuilder(modifier).add(BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(block.getDefaultState(), BlockPos.ORIGIN))).build();
    }*/
    
    /*
    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TsArcanum.MOD_ID, name), placedFeature);
    }*/
    
    
    
    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TsArcanum.MOD_ID, name));
    }
    
    static {
    
        NOT_IN_SURFACE_WATER_MODIFIER = SurfaceWaterDepthFilterPlacementModifier.of(0);
        
        GREAT_OAK_VEGETATION_PLACED = PlacedFeatures.register("great_oak_spawn",
                TsConfiguredFeatures.GREAT_OAK_FOREST_VEGETATION, VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(45, 0.1f, 1)
                ));
                
        //Placeholder
        HEARTWOOD_PLACED = PlacedFeatures.register("heartwood_spawn",
                TsConfiguredFeatures.HEARTWOOD_TREE_RANDOM, VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                ));
        WILLOW_PLACED = PlacedFeatures.register("willow_spawn",
                TsConfiguredFeatures.WILLOW_TREE_RANDOM, VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                ));
        ELM_PLACED = PlacedFeatures.register("elm_spawn",
                TsConfiguredFeatures.ELM_TREE_RANDOM, VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                ));
        MYRTLE_PLACED = PlacedFeatures.register("myrtle_spawn",
                TsConfiguredFeatures.MYRTLE_TREE_RANDOM, VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                ));
        SYCAMORE_PLACED = PlacedFeatures.register("sycamore_spawn", TsConfiguredFeatures.SYCAMORE_TREE_RANDOM,
                        modifiersWithChance(10, CountPlacementModifier.of(1)) // Last argument can also be (PlacementModifier)null
                );
        BROWN_MUSHROOM_OLD_GROWTH = PlacedFeatures.register("ts_brown_mushroom_old_growth",
                VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM, VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(10, 0.1f, 1)
                ));
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering PlacedFeatures");
    }
}
