package com.trufflez.tsarcanum.world.biome;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class TsOverworldBiomeBuilder {

    private static final RegistryKey<Biome>[][] OCEANS_EMPTY = new RegistryKey[][]{
            {BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN},
            {BiomeKeys.FROZEN_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN}
    };
    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_EMPTY = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.TAIGA},
            {BiomeKeys.PLAINS, BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.FLOWER_FOREST, BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA, BiomeKeys.SAVANNA, BiomeKeys.FOREST, BiomeKeys.JUNGLE, BiomeKeys.JUNGLE},
            {BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT}
    };
    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_VARIANT_EMPTY = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.SNOWY_TAIGA, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
            {BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.PLAINS, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.BAMBOO_JUNGLE},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };
    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_EMPTY = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };
    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_VARIANT_EMPTY = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.ERODED_BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    private static final RegistryKey<Biome>[][] EXTREME_HILLS_EMPTY = new RegistryKey[][]{
            {BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
            {BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
            {BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };


    private static final RegistryKey<Biome>[][] OCEANS = new RegistryKey[][]{
            {BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN},
            {BiomeKeys.FROZEN_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.OCEAN, BiomeKeys.LUKEWARM_OCEAN}
    };
    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES = new RegistryKey[][]{
            {BiomeKeys.TAIGA},
            {BiomeKeys.PLAINS, BiomeKeys.PLAINS, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA},
            {BiomeKeys.DESERT}
    };
    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_2 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.TAIGA},
            {BiomeKeys.PLAINS, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.FLOWER_FOREST, BiomeKeys.PLAINS, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA, BiomeKeys.JUNGLE},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_3 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.TAIGA},
            {BiomeKeys.PLAINS, BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.FLOWER_FOREST, BiomeKeys.PLAINS, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA, BiomeKeys.SAVANNA, BiomeKeys.FOREST, BiomeKeys.JUNGLE, BiomeKeys.JUNGLE},
            {BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT}
    };

    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.SNOWY_TAIGA, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
            {BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.ERODED_BADLANDS}
    };
    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_VARIANT_2 = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.SNOWY_TAIGA, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
            {BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.BAMBOO_JUNGLE},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    private static final RegistryKey<Biome>[][] MIDDLE_BIOMES_VARIANT_3 = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.SNOWY_TAIGA, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
            {BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.PLAINS, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.BAMBOO_JUNGLE},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_2 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_3 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_4 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };
    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_5 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_6 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_7 = new RegistryKey[][]{
            {BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
            {BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
            {BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
            {BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.ERODED_BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    private static final RegistryKey<Biome>[][] PLATEAU_BIOMES_VARIANT_2 = new RegistryKey[][]{
            {BiomeKeys.ICE_SPIKES, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.MEADOW, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.ERODED_BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    private static final RegistryKey<Biome>[][] EXTREME_HILLS = new RegistryKey[][]{
            {BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
            {BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
            {BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID},
            {BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID, BiomeKeys.THE_VOID}
    };

    // TODO: FIX THIS
    
    /*
    public static final List<BiomeProviderData> OVERWORLD_DEFAULTS = Util.make(new ArrayList<>(), list -> {
        int overworldWeight = 6;
        list.add(new BiomeProviderData(overworldWeight, OCEANS, MIDDLE_BIOMES, MIDDLE_BIOMES_VARIANT, PLATEAU_BIOMES, PLATEAU_BIOMES_VARIANT, EXTREME_HILLS, Util.make(new IdentityHashMap<>(), map -> map.put(BiomeKeys.SWAMP))));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_2, MIDDLE_BIOMES_VARIANT_2, PLATEAU_BIOMES_2, PLATEAU_BIOMES_VARIANT_2, EXTREME_HILLS_EMPTY, Util.make(new IdentityHashMap<>(), map -> map.put(BiomeKeys.SWAMP))));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_3, MIDDLE_BIOMES_VARIANT_3, PLATEAU_BIOMES_3, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_4, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_5, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        // Broken beyond this point atm.
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_6, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_7, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
    });
    
    public static final class BiomeProviderData {
        public static final Codec<BiomeProviderData> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(Codec.INT.fieldOf("weight").forGetter(biomeProviderData -> biomeProviderData.overworldWeight),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("oceans").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.oceanBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("middle_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.commonBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("middle_biomes_variant").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.uncommonBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("plateau_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.nearMountainBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("plateau_biomes_variant").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.specialNearMountainBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("extreme_hills").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.hillBiomes)),
                    Codec.unboundedMap(Identifier.CODEC.comapFlatMap(resourceLocation -> {
                        if (!resourceLocation.getNamespace().equals("minecraft")) {
                            throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                        }
                        return DataResult.success(RegistryKey.of(Registry.BIOME_KEYS, resourceLocation));
                    }, RegistryKey::getValue), CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(biomeProviderData -> biomeProviderData.swapper)
            ).apply(builder, BiomeProviderData::new);
        });
        
        private final int overworldWeight;
        private final RegistryKey<Biome>[][] oceanBiomes;
        private final RegistryKey<Biome>[][] commonBiomes;
        private final RegistryKey<Biome>[][] uncommonBiomes;
        private final RegistryKey<Biome>[][] nearMountainBiomes;
        private final RegistryKey<Biome>[][] specialNearMountainBiomes;
        private final RegistryKey<Biome>[][] hillBiomes;
        private final Map<RegistryKey<Biome>, RegistryKey<Biome>> swapper;

        public BiomeProviderData(int overworldWeight, List<List<RegistryKey<Biome>>> oceans, List<List<RegistryKey<Biome>>> middleBiomes, List<List<RegistryKey<Biome>>> middleBiomesVariant, List<List<RegistryKey<Biome>>> plateauBiomes, List<List<RegistryKey<Biome>>> plateauBiomesVariant, List<List<RegistryKey<Biome>>> extremeHills, Map<RegistryKey<Biome>, RegistryKey<Biome>> swapper) {
            this(overworldWeight, BYGUtil.convert2DResourceKeyArrayTo2DList(oceans), BYGUtil.convert2DResourceKeyArrayTo2DList(middleBiomes), BYGUtil.convert2DResourceKeyArrayTo2DList(middleBiomesVariant), BYGUtil.convert2DResourceKeyArrayTo2DList(plateauBiomes), BYGUtil.convert2DResourceKeyArrayTo2DList(plateauBiomesVariant), BYGUtil.convert2DResourceKeyArrayTo2DList(extremeHills), swapper);
        }

        public BiomeProviderData(int overworldWeight,
                                 RegistryKey<Biome>[][] oceanBiomes,
                                 RegistryKey<Biome>[][] commonBiomes,
                                 RegistryKey<Biome>[][] uncommonBiomes,
                                 RegistryKey<Biome>[][] nearMountainBiomes,
                                 RegistryKey<Biome>[][] specialNearMountainBiomes,
                                 RegistryKey<Biome>[][] hillBiomes,
                                 Map<RegistryKey<Biome>, RegistryKey<Biome>> swapper) {
            this.overworldWeight = overworldWeight;
            this.oceanBiomes = oceanBiomes;
            this.commonBiomes = commonBiomes;
            this.uncommonBiomes = uncommonBiomes;
            this.nearMountainBiomes = nearMountainBiomes;
            this.specialNearMountainBiomes = specialNearMountainBiomes;
            this.hillBiomes = hillBiomes;
            this.swapper = swapper;
        }
        
        

        public int overworldWeight() {
            return overworldWeight;
        }

        public RegistryKey<Biome>[][] getOceanBiomes() {
            return oceanBiomes;
        }

        public RegistryKey<Biome>[][] getCommonBiomes() {
            return commonBiomes;
        }

        public RegistryKey<Biome>[][] getUncommonBiomes() {
            return uncommonBiomes;
        }

        public RegistryKey<Biome>[][] getNearMountainBiomes() {
            return nearMountainBiomes;
        }

        public RegistryKey<Biome>[][] getSpecialNearMountainBiomes() {
            return specialNearMountainBiomes;
        }

        public RegistryKey<Biome>[][] getHillBiomes() {
            return hillBiomes;
        }

        public Map<RegistryKey<Biome>, RegistryKey<Biome>> swapper() {
            return swapper;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == BiomeKeys.THE_VOID || obj.getClass() != this.getClass()) return false;
            var that = (BiomeProviderData) obj;
            return this.overworldWeight == that.overworldWeight &&
                    Objects.equals(this.oceanBiomes, that.oceanBiomes) &&
                    Objects.equals(this.commonBiomes, that.commonBiomes) &&
                    Objects.equals(this.uncommonBiomes, that.uncommonBiomes) &&
                    Objects.equals(this.nearMountainBiomes, that.nearMountainBiomes) &&
                    Objects.equals(this.specialNearMountainBiomes, that.specialNearMountainBiomes) &&
                    Objects.equals(this.hillBiomes, that.hillBiomes) &&
                    Objects.equals(this.swapper, that.swapper);
        }

        @Override
        public int hashCode() {
            return Objects.hash(overworldWeight, oceanBiomes, commonBiomes, uncommonBiomes, nearMountainBiomes, specialNearMountainBiomes, hillBiomes, swapper);
        }
        
        @Override
        public String toString() {
            return "BiomeProviderData[" +
                    "overworldWeight=" + overworldWeight + ", " +
                    "oceanBiomes=" + oceanBiomes + ", " +
                    "commonBiomes=" + commonBiomes + ", " +
                    "uncommonBiomes=" + uncommonBiomes + ", " +
                    "nearMountainBiomes=" + nearMountainBiomes + ", " +
                    "specialNearMountainBiomes=" + specialNearMountainBiomes + ", " +
                    "hillBiomes=" + hillBiomes + ", " +
                    "swapper=" + swapper + ']';
        }
        */
}
