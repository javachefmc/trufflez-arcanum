package com.trufflez.tsarcanum.world;

import com.trufflez.tsarcanum.TsArcanum;
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
        
        // TODO: fix
        /*OverworldBiomeConfig.getConfig(true).values().forEach((biomeProviderData) -> {
            BiomeProviders.register(new BYGBiomeProvider(biomeProviderData.overworldWeight(), biomeProviderData.oceans(), biomeProviderData.middleBiomes(), biomeProviderData.middleBiomesVariant(), biomeProviderData.plateauBiomes(), biomeProviderData.plateauBiomesVariant(), biomeProviderData.extremeHills(), biomeProviderData.swapper()));
        });*/
    }
}
