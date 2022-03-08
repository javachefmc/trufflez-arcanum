package com.trufflez.tsarcanum.world.biome;

import com.mojang.datafixers.util.Pair;
import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class TsRegions extends Region {
    private final Identifier name;
    private RegionType type;
    private int weight;

    public TsRegions(Identifier name, RegionType type, int weight)
    {
        super(name, type, weight);
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    @Override
    public void addBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        addBiome(mapper, MultiNoiseUtil.createNoiseHypercube(
                0.6f,
                0.8f,
                2.0f,
                2.0f,
                0.0f,
                0.0f,
                0.0f
        ), TsBiomeKeys.GREAT_OAK_FOREST);
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering overworld biomes.");
    }
}
