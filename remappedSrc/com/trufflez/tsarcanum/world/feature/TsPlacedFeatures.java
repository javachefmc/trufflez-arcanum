package com.trufflez.tsarcanum.world.feature;

import com.google.common.collect.ImmutableList;
import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
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
    
    public static final PlacedFeature GREAT_OAK_VEGETATION_PLACED;
    public static final PlacedFeature HEARTWOOD_PLACED;
    public static final PlacedFeature WILLOW_PLACED;
    public static final PlacedFeature ELM_PLACED;
    public static final PlacedFeature MYRTLE_PLACED;
    public static final PlacedFeature SYCAMORE_PLACED;
    public static final PlacedFeature BROWN_MUSHROOM_OLD_GROWTH;
    
    
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
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
    
    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    
    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TsArcanum.MOD_ID, name), placedFeature);
    }
    
    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TsArcanum.MOD_ID, name));
    }
    
    
    static {
        GREAT_OAK_VEGETATION_PLACED = registerPlacedFeature("great_oak_spawn",
                TsConfiguredFeatures.GREAT_OAK_FOREST_VEGETATION.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(45, 0.1f, 1)
                )));
                
        //Placeholder
        HEARTWOOD_PLACED = registerPlacedFeature("heartwood_spawn",
                TsConfiguredFeatures.HEARTWOOD_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                )));
        WILLOW_PLACED = registerPlacedFeature("willow_spawn",
                TsConfiguredFeatures.WILLOW_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                )));
        ELM_PLACED = registerPlacedFeature("elm_spawn",
                TsConfiguredFeatures.ELM_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                )));
        MYRTLE_PLACED = registerPlacedFeature("myrtle_spawn",
                TsConfiguredFeatures.MYRTLE_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                )));
        SYCAMORE_PLACED = registerPlacedFeature("sycamore_spawn",
                TsConfiguredFeatures.SYCAMORE_TREE_RANDOM.withPlacement(//VegetationPlacedFeatures.modifiers(
                        //PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                        modifiersWithChance(10, CountPlacementModifier.of(1))
                ));
        BROWN_MUSHROOM_OLD_GROWTH = registerPlacedFeature("brown_mushroom_old_growth",
                VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        //modifiersWithChance(4, CountPlacementModifier.of(3))
                        PlacedFeatures.createCountExtraModifier(10, 0.1f, 1)
                )));
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering PlacedFeatures");
    }
}
