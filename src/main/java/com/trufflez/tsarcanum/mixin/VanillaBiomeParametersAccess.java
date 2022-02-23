package com.trufflez.tsarcanum.mixin;

import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VanillaBiomeParameters.class)
public interface VanillaBiomeParametersAccess {
    
    // TODO: migrate code from official mappings: OverworldBiomeBuilder.class
    // Yarn: VanillaBiomeParameters
    // Additionally, method names need to be migrated

    /*@Accessor
    @Mutable
    void setOCEANS(RegistryKey<Biome>[][] oceans);

    @Accessor @Mutable
    void setMIDDLE_BIOMES(RegistryKey<Biome>[][] middleBiomes);

    @Accessor @Mutable
    void setMIDDLE_BIOMES_VARIANT(RegistryKey<Biome>[][] middleBiomesVariant);

    @Accessor @Mutable
    void setPLATEAU_BIOMES(RegistryKey<Biome>[][] plateauBiomes);

    @Accessor @Mutable
    void setPLATEAU_BIOMES_VARIANT(RegistryKey<Biome>[][] plateauBiomesVariant);

    @Accessor @Mutable
    void setEXTREME_HILLS(RegistryKey<Biome>[][] extremeHills);

    @Invoker
    void invokeAddBiomes(Consumer<Pair<Climate.ParameterPoint, RegistryKey<Biome>>> mapper);*/
}

