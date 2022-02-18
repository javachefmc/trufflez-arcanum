package com.trufflez.tsarcanum;

import com.trufflez.tsarcanum.blocks.*;
import com.trufflez.tsarcanum.gen.feature.TsConfiguredFeatures;
import com.trufflez.tsarcanum.items.TsItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TsArcanum implements ModInitializer {
	
	public static final String MOD_ID = "tsarcanum";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);
	
	// Item groups
	public static final ItemGroup ITEMGROUP_MAIN = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "main"))
			.icon(() -> new ItemStack(TsBlocks.AURIC_WORKBENCH))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(TsBlocks.AURIC_WORKBENCH));
				
				stacks.add(new ItemStack(TsBlocks.VITRIOL));
				
				stacks.add(new ItemStack(TsBlocks.STAFF_PEDESTAL));
				stacks.add(new ItemStack(TsItems.COPPER_SHEET));
				stacks.add(new ItemStack(TsBlocks.COPPER_TUBING));
				stacks.add(new ItemStack(TsBlocks.COPPER_SPIGOT));
				stacks.add(new ItemStack(TsBlocks.ALEMBIC));

				stacks.add(new ItemStack(TsBlocks.REFRACTORY_CLAY));
				stacks.add(new ItemStack(TsBlocks.REFRACTORY_BLOCK));
				stacks.add(new ItemStack(TsItems.REFRACTORY_CLAY_BRICK));
				stacks.add(new ItemStack(TsItems.REFRACTORY_BRICK));
				stacks.add(new ItemStack(TsBlocks.REFRACTORY_BRICKS));
				stacks.add(new ItemStack(TsBlocks.ATHANOR));
				
				stacks.add(new ItemStack(TsBlocks.GREAT_OAK_LOG));
				stacks.add(new ItemStack(TsBlocks.GREAT_OAK_WOOD));
				stacks.add(new ItemStack(TsBlocks.HEARTWOOD_LOG));
				stacks.add(new ItemStack(TsBlocks.HEARTWOOD_WOOD));
				stacks.add(new ItemStack(TsBlocks.WILLOW_LOG));
				stacks.add(new ItemStack(TsBlocks.WILLOW_WOOD));
				stacks.add(new ItemStack(TsBlocks.ELM_LOG));
				stacks.add(new ItemStack(TsBlocks.ELM_WOOD));

				stacks.add(new ItemStack(TsBlocks.STRIPPED_GREAT_OAK_LOG));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_GREAT_OAK_WOOD));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_HEARTWOOD_LOG));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_HEARTWOOD_WOOD));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_WILLOW_LOG));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_WILLOW_WOOD));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_ELM_LOG));
				stacks.add(new ItemStack(TsBlocks.STRIPPED_ELM_WOOD));
				
				stacks.add(new ItemStack(TsBlocks.GREAT_OAK_PLANKS));
				stacks.add(new ItemStack(TsBlocks.HEARTWOOD_PLANKS));
				stacks.add(new ItemStack(TsBlocks.WILLOW_PLANKS));
				stacks.add(new ItemStack(TsBlocks.ELM_PLANKS));
				
				stacks.add(new ItemStack(TsBlocks.GREAT_OAK_SLAB));
				stacks.add(new ItemStack(TsBlocks.HEARTWOOD_SLAB));
				stacks.add(new ItemStack(TsBlocks.WILLOW_SLAB));
				stacks.add(new ItemStack(TsBlocks.ELM_SLAB));
				
				stacks.add(new ItemStack(TsBlocks.GREAT_OAK_STAIRS));
				stacks.add(new ItemStack(TsBlocks.HEARTWOOD_STAIRS));
				stacks.add(new ItemStack(TsBlocks.WILLOW_STAIRS));
				stacks.add(new ItemStack(TsBlocks.ELM_STAIRS));
				
				stacks.add(new ItemStack(TsBlocks.GREAT_OAK_LEAVES));
				stacks.add(new ItemStack(TsBlocks.HEARTWOOD_LEAVES));
				stacks.add(new ItemStack(TsBlocks.WILLOW_LEAVES));
				stacks.add(new ItemStack(TsBlocks.ELM_LEAVES));

				stacks.add(new ItemStack(TsSaplings.GREAT_OAK_SAPLING));
				stacks.add(new ItemStack(TsSaplings.HEARTWOOD_SAPLING));
				stacks.add(new ItemStack(TsSaplings.WILLOW_SAPLING));
				stacks.add(new ItemStack(TsSaplings.ELM_SAPLING));
				
				stacks.add(new ItemStack(TsItems.GREAT_OAK_STAFF_CORE));
				stacks.add(new ItemStack(TsItems.HEARTWOOD_STAFF_CORE));
				stacks.add(new ItemStack(TsItems.WILLOW_STAFF_CORE));
				stacks.add(new ItemStack(TsItems.ELM_STAFF_CORE));
				
				stacks.add(new ItemStack(TsItems.GREAT_OAK_STAFF));
				stacks.add(new ItemStack(TsItems.HEARTWOOD_STAFF));
				stacks.add(new ItemStack(TsItems.WILLOW_STAFF));
				stacks.add(new ItemStack(TsItems.ELM_STAFF));
			}).build();
	public static final ItemGroup ITEMGROUP_MAGIC = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "magic"))
			.icon(() -> new ItemStack(TsItems.GREAT_OAK_STAFF))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(TsBlocks.AURIC_WORKBENCH));
				stacks.add(new ItemStack(TsItems.GREAT_OAK_STAFF_CORE));
				stacks.add(new ItemStack(TsItems.HEARTWOOD_STAFF_CORE));
				stacks.add(new ItemStack(TsItems.GREAT_OAK_STAFF));
				stacks.add(new ItemStack(TsItems.HEARTWOOD_STAFF));
			}).build();
	public static final ItemGroup ITEMGROUP_DEV = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "devtools"))
			.icon(() -> new ItemStack(TsItems.DEV_TOOL))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(TsBlocks.DEV_CUBE));
				stacks.add(new ItemStack(TsItems.DEV_TOOL));
			}).build();
	
	// Registry refactorings
	
	//private static <T extends Recipe<?>> RecipeSerializer<T> register(String id, RecipeSerializer<T> recipeSerializer) { return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, id), recipeSerializer); }
	//private static <T extends Recipe<?>> RecipeType<T> register(String id, RecipeType<T> recipeType) { return Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, id), recipeType); }
	
	@Override
	public void onInitialize() {
		
		// If unordered, can CRASH the game!
		
		TsBlocks.init(); // Basic blocks
		TsItems.init(); // Basic items and BlockItems
		
		TsConfiguredFeatures.init(); // Trees and Features
		
		TsSaplings.init(); // SaplingBlocks and BlockItems
		
		TsBlockEntities.init(); // Block Entities and ScreenHandlers
		
		TsBlockProperties.init(); // Flammable, Compostable, Strippable, Tinted
		
		
		// Custom recipe type registry
		//Registry.register(Registry.RECIPE_SERIALIZER, AuricRecipeSerializer.ID, AuricRecipeSerializer.INSTANCE);
		//Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, AuricRecipe.Type.ID), AuricRecipe.Type.INSTANCE);
		//register("auric_workbench_recipe_serializer", new AuricWorkbenchRecipeSerializer());	//TODO
		//register("auric_workbench_recipe", AuricWorkbenchRecipe.Type.INSTANCE);				//TODO
		
		LOG.info("Trufflez' Arcanum Loaded.");
	}
}
