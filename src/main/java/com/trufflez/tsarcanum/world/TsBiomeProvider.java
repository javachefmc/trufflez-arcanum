package com.trufflez.tsarcanum.world;

import com.mojang.datafixers.util.Pair;
import com.trufflez.tsarcanum.world.biome.TsBiomeKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import terrablender.api.BiomeProvider;
import terrablender.worldgen.TBClimate;

import java.util.function.Consumer;

public class TsBiomeProvider extends BiomeProvider {
    
    public TsBiomeProvider(Identifier name, int weight) {
        super(name, weight);
    }
    
    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, RegistryKey<Biome>>> mapper) {
        this.addBiomeSimilar(mapper, BiomeKeys.PLAINS, TsBiomeKeys.GREAT_OAK_FOREST);
        // TODO: adjust this stuff
        /*this.addBiome(mapper,
                MultiNoiseUtil.ParameterRange.of(0.0F), // temperature
                MultiNoiseUtil.ParameterRange.of(0.0F), // humidity
                MultiNoiseUtil.ParameterRange.of(0.0F), // continentalness
                MultiNoiseUtil.ParameterRange.of(0.0F), // erosion
                MultiNoiseUtil.ParameterRange.of(0.0F), // weirdness
                MultiNoiseUtil.ParameterRange.of(0.0F), // depth
                0.0F,                                   // offset
                TsBiomeKeys.GREAT_OAK_FOREST);*/
    }
    
    
    
    
    
    
    
    
    
    
    
}
