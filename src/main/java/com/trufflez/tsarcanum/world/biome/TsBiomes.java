package com.trufflez.tsarcanum.world.biome;

import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public abstract class TsBiomes {

    public static final Biome GREAT_OAK_FOREST;
    
    // An attempt at forcing a new biome into Minecraft 1.18
    // update: this works, but it's just a registry
    // and this whole system is identical to the datapacks
    
    /*
    Update: It appears that biomes in mod-supported datapacks are registered,
    but they trigger an "experimental feature" warning in-game
     */
    
    private static Biome register(RegistryKey<Biome> key, Biome biome) {
        return (Biome) BuiltinRegistries.set(BuiltinRegistries.BIOME, key, biome);
    }
    
    static {
        GREAT_OAK_FOREST = register(TsBiomeKeys.GREAT_OAK_FOREST, TsBiomeCreator.createGreatOakForest());
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering biomes");
    }
}
