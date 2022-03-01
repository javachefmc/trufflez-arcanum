package com.trufflez.tsarcanum;

import com.trufflez.tsarcanum.block.TsBlockEntities;
import com.trufflez.tsarcanum.block.TsBlockProperties;
import com.trufflez.tsarcanum.block.TsBlocks;
import com.trufflez.tsarcanum.block.TsSaplings;
import com.trufflez.tsarcanum.item.TsItems;
import com.trufflez.tsarcanum.world.biome.TsBiomeKeys;
import com.trufflez.tsarcanum.world.biome.TsBiomeConfiguration;
import com.trufflez.tsarcanum.world.feature.TsConfiguredFeatures;
import com.trufflez.tsarcanum.world.feature.TsPlacedFeatures;
import com.trufflez.tsarcanum.world.feature.TsTreeConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class TsArcanum implements ModInitializer {
	public static final String MOD_ID = "tsarcanum";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Path CONFIG = null;
	
	public static void setCONFIG(){
		CONFIG = FabricLoader.getInstance().getConfigDir().resolve(MOD_ID);
	}
	
	@Override
	public void onInitialize() {
		
		setCONFIG();
		
		// Must be done in this order!
		
		/*
		
		Some modders register items first: Items -> Blocks -> BlockItems
		I'm doing this: Blocks -> Items & BlockItems
		It works, so..
		
		 */
		
		TsBlocks.init(); // Basic blocks
		TsItems.init(); // Basic items and special BlockItems
		
		TsTreeConfiguredFeatures.init(); // TreeConfiguredFeatures (individual tree generation)
		
		TsConfiguredFeatures.init(); // General ConfiguredFeatures (includes tree placement checks)
		TsPlacedFeatures.init(); // General PlacedFeatures (converts ConfiguredFeatures to PlacedFeatures with additional options)
		
		TsSaplings.init(); // SaplingBlocks and BlockItems
		
		TsBlockEntities.init(); // Block Entities and ScreenHandlers
		
		
		TsBlockProperties.init(); // Flammable, Compostable, Strippable, Tinted
		
		
		//TsBiomeKeys.init();
		//TsBiomeConfiguration.init();


		//TsWorldGen.init(); // World generation
		
		LOGGER.info("Trufflez' Arcanum Loaded.");
	}
}
