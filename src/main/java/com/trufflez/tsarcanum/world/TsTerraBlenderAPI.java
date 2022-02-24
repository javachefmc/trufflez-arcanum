package com.trufflez.tsarcanum.world;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.world.biome.OverworldBiomeConfig;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.BiomeProvider;
import terrablender.api.BiomeProviders;
import terrablender.api.TerraBlenderApi;

import java.util.Optional;

public class TsTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        // From documentation:
        // BiomeProviders.register(new TsBiomeProvider(new Identifier(TsArcanum.MOD_ID, "biome_provider"), 2));
        
        BiomeProviders.register(new BiomeProvider(new Identifier(TsArcanum.MOD_ID, "surface_data"), 0) {
            public Optional<MaterialRules.MaterialRule> getOverworldSurfaceRules() {
                return Optional.of(TsMaterialRules.OVERWORLD_SURFACE_RULES);
            }
        });
        
        // BYG appears to use a json carrier file to store and retrieve biomes
        // Hopefully that's what this is, and not something to do with 1.18 biome injection
        
        
        // TODO: FIX
        /*
        OverworldBiomeConfig.getConfig(true).values().forEach((biomeProviderData) -> {
            BiomeProviders.register(new TsBiomeProvider(
                    biomeProviderData.overworldWeight(),
                    biomeProviderData.oceanBiomes(),
                    biomeProviderData.commonBiomes(),
                    biomeProviderData.uncommonBiomes(),
                    biomeProviderData.nearMountainBiomes(),
                    biomeProviderData.specialNearMountainBiomes(),
                    biomeProviderData.hillBiomes(),
                    biomeProviderData.swapper()));
        });
        
         */
        
        
    }
}
