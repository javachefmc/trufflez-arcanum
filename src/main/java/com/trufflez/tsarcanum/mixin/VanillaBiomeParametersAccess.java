package com.trufflez.tsarcanum.mixin;

import net.minecraft.util.Pair;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Consumer;

@Mixin(VanillaBiomeParameters.class)
public interface VanillaBiomeParametersAccess {
    
    // TODO: migrate code from official mappings: OverworldBiomeBuilder.class
    // Yarn: VanillaBiomeParameters
    // Additionally, method names need to be migrated

    @Accessor
    @Mutable
    void setOCEAN_BIOMES(RegistryKey<Biome>[][] oceanBiomes); // "Oceans"

    @Accessor @Mutable
    void setCOMMON_BIOMES(RegistryKey<Biome>[][] commonBiomes); // "Middle Biomes"

    @Accessor @Mutable
    void setUNCOMMON_BIOMES(RegistryKey<Biome>[][] uncommonBiomes); // "Middle Biomes Variant"

    @Accessor @Mutable
    void setNEAR_MOUNTAIN_BIOMES(RegistryKey<Biome>[][] nearMountainBiomes); // "Plateau Biomes"

    @Accessor @Mutable
    void setSPECIAL_NEAR_MOUNTAIN_BIOMES(RegistryKey<Biome>[][] specialNearMountainBiomes); // "Plateau Biomes Variant"

    @Accessor @Mutable
    void setHILL_BIOMES(RegistryKey<Biome>[][] hillBiomes); // "Extreme Hills"

    @Invoker
    void invokeWriteVanillaBiomeParameters(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper);
}

