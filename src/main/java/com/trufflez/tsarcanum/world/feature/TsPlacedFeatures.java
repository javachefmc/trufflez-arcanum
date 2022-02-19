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

import java.util.List;

public class TsPlacedFeatures {


    public static RegistryKey<PlacedFeature> GREAT_OAK_KEY;
    public static PlacedFeature GREAT_OAK_PLACED;
    
    
    
    
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
    
    
    public static void init() {
        System.out.println("TreePlacedFeatures start");
        //GREAT_OAK_PLACED = PlacedFeatures.register("great_oak", TsTreeConfiguredFeatures.GREAT_OAK.withPlacement());
        //GREAT_OAK_PLACED = PlacedFeatures.register("great_oak_placed", TsTreeConfiguredFeatures.GREAT_OAK.withPlacement(CountMultilayerPlacementModifier.of(8), BiomePlacementModifier.of()));
        
        //GREAT_OAK_PLACED_FEATURE = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TsArcanum.MOD_ID, "great_oak"));


        //GREAT_OAK_KEY = registerKey("great_oak_spawn");
        
        /*GREAT_OAK_PLACED = registerPlacedFeature("great_oak_spawn",
                TsTreeConfiguredFeatures.GREAT_OAK_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
                )));
        */
        
        System.out.println("TreePlacedFeatures done");
    }
}
