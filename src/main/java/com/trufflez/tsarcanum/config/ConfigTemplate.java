package com.trufflez.tsarcanum.config;

public record ConfigTemplate() {
    
    // This is config from BYG mod but I'll get rid of their code ..later
    
    /*
    public static final ConfigTemplate DEFAULT = new ConfigTemplate(TsOverworldBiomeBuilder.OVERWORLD_DEFAULTS);

    public static ConfigTemplate INSTANCE = null;

    public static final Codec<ConfigTemplate> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            TsOverworldBiomeBuilder.BiomeProviderData.CODEC.listOf().fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
    ).apply(builder, ConfigTemplate::new));

    
    public static ConfigTemplate getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }
        
        return INSTANCE;
    }

    public static void setConfigInstance(ConfigTemplate config) {
        INSTANCE = config;
    }
    
    */
    /*
    private static ConfigTemplate readConfig() {
        final Path path = TsArcanum.CONFIG.resolve("overworld-biomes.json");

        if (!path.toFile().exists()) {
            JsonElement jsonElement = CODEC.encodeStart(JsonOps.INSTANCE, DEFAULT).result().get();

            try {
                Files.createDirectories(path.getParent());
                Files.write(path, new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(jsonElement).getBytes());
            } catch (IOException e) {
                TsArcanum.LOGGER.error(e.toString());
            }
        }
        TsArcanum.LOGGER.info(String.format("\"%s\" was read.", path));

        try {
            return CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(path.toFile()))).result().orElseThrow(RuntimeException::new).getFirst();
        } catch (Exception e) {
            String error = String.format("An error occurred when parsing \"%s\".\n%s", path, e);
            TsArcanum.LOGGER.error(error);
            throw new IllegalStateException(error);
        }
    }
     */
}
