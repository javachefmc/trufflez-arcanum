package com.trufflez.tsarcanum.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class CodecUtil {
    public static final Codec<RegistryKey<Biome>> BIOME_CODEC = Identifier.CODEC.comapFlatMap(resourceLocation ->
            DataResult.success(RegistryKey.of(Registry.BIOME_KEY, resourceLocation)), RegistryKey::getValue);
}