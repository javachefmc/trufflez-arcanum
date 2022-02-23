package com.trufflez.tsarcanum.world;

import com.mojang.datafixers.util.Pair;
import com.trufflez.tsarcanum.TsArcanum;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import terrablender.api.BiomeProvider;
import terrablender.worldgen.TBClimate;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class TsBiomeProvider extends BiomeProvider {
    /*public TsBiomeProvider(Identifier name, int overworldWeight) {
        
        super(name, overworldWeight);
    }*/

    private static int count = 0;
    
    private final VanillaBiomeParameters vanillaBiomeParameters = new VanillaBiomeParameters();
    private final Set<RegistryKey<Biome>> tsBiomeKeys = new ObjectOpenHashSet<>();
    private final Map<RegistryKey<Biome>, RegistryKey<Biome>> swapper;

    public TsBiomeProvider(int overworldWeight,
                           RegistryKey<Biome>[][] oceans,
                           RegistryKey<Biome>[][] middleBiomes,
                           RegistryKey<Biome>[][] middleBiomesVariant,
                           RegistryKey<Biome>[][] plateauBiomes,
                           RegistryKey<Biome>[][] plateauBiomesVariant,
                           RegistryKey<Biome>[][] extremeHills,
                           Map<RegistryKey<Biome>,RegistryKey<Biome>> swapper) {
        super(new Identifier(TsArcanum.MOD_ID, "biome_provider_" + count++), overworldWeight);
        this.swapper = swapper;
        
        // TODO: Remap from official mappings
        /*VanillaBiomeParametersAccess vanillaBiomeParametersAccess = (VanillaBiomeParametersAccess) (Object) vanillaBiomeParameters;
        vanillaBiomeParametersAccess.setOCEANS(oceans);
        vanillaBiomeParametersAccess.setMIDDLE_BIOMES(middleBiomes);
        vanillaBiomeParametersAccess.setMIDDLE_BIOMES_VARIANT(middleBiomesVariant);
        vanillaBiomeParametersAccess.setPLATEAU_BIOMES(plateauBiomes);
        vanillaBiomeParametersAccess.setPLATEAU_BIOMES_VARIANT(plateauBiomesVariant);
        vanillaBiomeParametersAccess.setEXTREME_HILLS(extremeHills);
        dumpArrays((biomeRegistryKey -> {
            if (biomeRegistryKey != null && biomeRegistryKey != Biomes.THE_VOID) {
                tsBiomeKeys.add(biomeRegistryKey);
                if (swapper.containsValue(biomeRegistryKey)) {
                    throw new IllegalArgumentException("Swapper cannot contain elements found in the temperature arrays.");
                }
            }
        }), oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, extremeHills);*/
    }
    
    
    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, RegistryKey<Biome>>> mapper) {
        // From fabric documentation
        /*this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            
        });*/

        // TODO: Remap from official mappings
        /*((VanillaBiomeParametersAccess) (Object) this.vanillaBiomeParameters).invokeAddBiomes((parameterPointResourceKeyPair -> {
            RegistryKey<Biome> biomeKey = parameterPointResourceKeyPair.getSecond();
            if (this.tsBiomeKeys.contains(biomeKey)) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), biomeKey));
            }
            if (this.swapper.containsKey(biomeKey)) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), this.swapper.get(biomeKey)));
            }
        }));*/
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
