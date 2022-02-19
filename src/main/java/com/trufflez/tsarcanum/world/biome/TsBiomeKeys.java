package com.trufflez.tsarcanum.world.biome;

import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public abstract class TsBiomeKeys {
    public static final RegistryKey<Biome> GREAT_OAK_FOREST = register("great_oak_forest");
    
    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(TsArcanum.MOD_ID, name));
    }
    
    public static void init() {
        TsArcanum.LOGGER.info("Registering biome keys");
    }
}
