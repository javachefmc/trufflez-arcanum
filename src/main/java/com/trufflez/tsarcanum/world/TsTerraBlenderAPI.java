package com.trufflez.tsarcanum.world;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.world.biome.TsBiomeProvider;
import net.minecraft.util.Identifier;
//import terrablender.api.BiomeProviders;
//import terrablender.api.TerraBlenderApi;

public class TsTerraBlenderAPI { // implements TerraBlenderApi 
    //@Override
    public void onTerraBlenderInitialized() {
        
        TsArcanum.setCONFIG();

        //BiomeProviders.register(new TsBiomeProvider(new Identifier(TsArcanum.MOD_ID, "tsbiome_provider"), 2));
        
        // Register material rules. I do not know what material rules are
        /*BiomeProviders.register(new BiomeProvider(new Identifier(TsArcanum.MOD_ID, "surface_data"), 0) {
            public Optional<MaterialRules.MaterialRule> getOverworldSurfaceRules() {
                return Optional.of(TsMaterialRules.OVERWORLD_SURFACE_RULES);
            }
        });*/
    }
}
