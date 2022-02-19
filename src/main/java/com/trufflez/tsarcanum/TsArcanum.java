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
		
		// If unordered, can CRASH the game!
		
		TsBlocks.init(); // Basic blocks
		//TsItems.init(); // Basic items and BlockItems
		TsItems.init();
		
		TsTreeConfiguredFeatures.init(); // TreesConfiguredFeatures
		
		TsConfiguredFeatures.init();
		
		//TsTreePlacedFeatures.init(); // TreePlacedFeatures
		
		TsSaplings.init(); // SaplingBlocks and BlockItems
		
		TsBlockEntities.init(); // Block Entities and ScreenHandlers
		
		
		TsBlockProperties.init(); // Flammable, Compostable, Strippable, Tinted
		
		
		//TsWorldGen.init(); // World generation
		
		
		LOGGER.info("Trufflez' Arcanum Loaded.");
	}
}
