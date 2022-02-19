package com.trufflez.tsarcanum.world.feature;

import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

import java.util.List;

public class TsPlacedFeatures {
    
    public static final RegistryKey<PlacedFeature> GREAT_OAK_KEY = registerKey("great_oak_spawn"); // Is this still used?
    public static final RegistryKey<PlacedFeature> HEARTWOOD_KEY = registerKey("heartwood_spawn");
    public static final RegistryKey<PlacedFeature> WILLOW_KEY = registerKey("willow_spawn");
    public static final RegistryKey<PlacedFeature> elm_KEY = registerKey("elm_spawn");
    
    public static final PlacedFeature GREAT_OAK_PLACED;
    public static final PlacedFeature HEARTWOOD_PLACED;
    public static final PlacedFeature WILLOW_PLACED;
    public static final PlacedFeature ELM_PLACED;
    
    
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
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
        GREAT_OAK_PLACED = registerPlacedFeature("great_oak_spawn",
                TsConfiguredFeatures.GREAT_OAK_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
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
    }
    
    public static void init() {
        TsArcanum.LOGGER.info("Registering PlacedFeatures");
    }
}
