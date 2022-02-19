package com.trufflez.tsarcanum;

import com.trufflez.tsarcanum.block.TsBlockEntities;
import com.trufflez.tsarcanum.block.TsBlockProperties;
import com.trufflez.tsarcanum.block.TsBlocks;
import com.trufflez.tsarcanum.block.TsSaplings;
import com.trufflez.tsarcanum.item.TsItems;
import com.trufflez.tsarcanum.world.feature.TsConfiguredFeatures;
import com.trufflez.tsarcanum.world.feature.TsTreeConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TsArcanum implements ModInitializer {
	
	public static final String MOD_ID = "tsarcanum";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		
		// Must be done in this order!
		
		/*
		Some modders register items first: Items -> Blocks -> BlockItems
		I'm doing this: Blocks -> Items & BlockItems
		 */
		
		TsBlocks.registerBlocks(); // Basic blocks
		TsItems.registerItems(); // Basic items and special BlockItems
		
		TsTreeConfiguredFeatures.registerTreeConfiguredFeatures(); // TreeConfiguredFeatures (for sapling gen)
		
		TsConfiguredFeatures.init();
		
		//TsTreePlacedFeatures.init(); // TreePlacedFeatures
		
		TsSaplings.registerSaplings(); // SaplingBlocks and BlockItems
		
		TsBlockEntities.registerBlockEntities(); // Block Entities and ScreenHandlers
		
		
		TsBlockProperties.registerBlockProperties(); // Flammable, Compostable, Strippable, Tinted
		
		
		//TsWorldGen.init(); // World generation
		
		
		LOGGER.info("Trufflez' Arcanum Loaded.");
	}
}
