package com.trufflez.tsarcanum.world;

import com.mojang.datafixers.util.Pair;
import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.mixin.VanillaBiomeParametersAccess;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import terrablender.api.BiomeProvider;
import terrablender.api.ParameterUtils;
import terrablender.worldgen.TBClimate;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class TsBiomeProvider extends BiomeProvider {
    
    /*
     BiomeProvider: TerraBlender API
    */
    
    private static int count = 0; // I do not fully understand this
    
    private final VanillaBiomeParameters vanillaBiomeParameters = new VanillaBiomeParameters();
    private final Set<RegistryKey<Biome>> tsBiomeKeys = new ObjectOpenHashSet<>();
    private final Map<RegistryKey<Biome>, RegistryKey<Biome>> swapper;

    public TsBiomeProvider(int overworldWeight,
                           RegistryKey<Biome>[][] oceanBiomes, // "oceans"
                           RegistryKey<Biome>[][] commonBiomes, // "middleBiomes"
                           RegistryKey<Biome>[][] uncommonBiomes, // "middleBiomesVariant"
                           RegistryKey<Biome>[][] nearMountainBiomes, // "plateauBiomes"
                           RegistryKey<Biome>[][] specialNearMountainBiomes, // "plateauBiomesVariant"
                           RegistryKey<Biome>[][] hillBiomes, // "extremeHills"
                           Map<RegistryKey<Biome>,RegistryKey<Biome>> swapper) {
        super(new Identifier(TsArcanum.MOD_ID, "biome_provider_" + count++), overworldWeight);
        this.swapper = swapper;
        
        // TODO: Remap from official mappings
        
        VanillaBiomeParametersAccess vanillaBiomeParametersAccess = (VanillaBiomeParametersAccess) (Object) vanillaBiomeParameters;
        vanillaBiomeParametersAccess.setOCEAN_BIOMES(oceanBiomes);
        vanillaBiomeParametersAccess.setCOMMON_BIOMES(commonBiomes);
        vanillaBiomeParametersAccess.setUNCOMMON_BIOMES(uncommonBiomes);
        vanillaBiomeParametersAccess.setNEAR_MOUNTAIN_BIOMES(nearMountainBiomes);
        vanillaBiomeParametersAccess.setSPECIAL_NEAR_MOUNTAIN_BIOMES(specialNearMountainBiomes);
        vanillaBiomeParametersAccess.setHILL_BIOMES(hillBiomes);
        dumpArrays((biomeRegistryKey -> {
            if (biomeRegistryKey != null && biomeRegistryKey != BiomeKeys.THE_VOID) {
                tsBiomeKeys.add(biomeRegistryKey);
                // The following code is from BYG. I do not understand it.
                if (swapper.containsValue(biomeRegistryKey)) {
                    throw new IllegalArgumentException("Swapper cannot contain elements found in the temperature arrays.");
                }
            }
        }), oceanBiomes, commonBiomes, uncommonBiomes, nearMountainBiomes, specialNearMountainBiomes, hillBiomes);
    }
    
    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, RegistryKey<Biome>>> mapper) {

        // TODO: Remap from official mappings
        
        ((VanillaBiomeParametersAccess) (Object) this.vanillaBiomeParameters).invokeWriteVanillaBiomeParameters((parameterPointRegistryKeyPair -> {
            RegistryKey<Biome> biomeKey = parameterPointRegistryKeyPair.getRight(); // getSecond, getFirst
            if (this.tsBiomeKeys.contains(biomeKey)) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointRegistryKeyPair.getLeft(), getUniquenessParameter()), biomeKey));
            }
            if (this.swapper.containsKey(biomeKey)) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointRegistryKeyPair.getLeft(), getUniquenessParameter()), this.swapper.get(biomeKey)));
            }
        }));
    }

    // Remapped
    @SafeVarargs
    private static void dumpArrays(Consumer<RegistryKey<Biome>> biomeConsumer, RegistryKey<Biome>[][]... registryKeys) {
        for (RegistryKey<Biome>[][] registryKey : registryKeys) {
            for (RegistryKey<Biome>[] keys : registryKey) {
                for (RegistryKey<Biome> key : keys) {
                    biomeConsumer.accept(key);
                }
            }
        }
    }
}
