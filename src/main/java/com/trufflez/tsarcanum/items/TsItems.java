package com.trufflez.tsarcanum.items;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.blocks.TsBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TsItems {
    // Items
    public static Item DEV_TOOL;
    
    public static Item COPPER_SHEET;
    public static Item REFRACTORY_CLAY_BRICK;
    public static Item REFRACTORY_BRICK;
    
    public static Item GREAT_OAK_STAFF_CORE;
    public static Item HEARTWOOD_STAFF_CORE;
    public static Item WILLOW_STAFF_CORE;
    public static Item ELM_STAFF_CORE;
    
    public static StaffItem GREAT_OAK_STAFF;
    public static StaffItem HEARTWOOD_STAFF;
    public static StaffItem WILLOW_STAFF;
    public static StaffItem ELM_STAFF;
    
    // Block items
    public static BlockItem DEV_CUBE_ITEM;
    
    public static BlockItem AURIC_WORKBENCH_ITEM;
    public static BlockItem STAFF_PEDESTAL_ITEM;
    public static BlockItem COPPER_TUBING_ITEM;
    public static BlockItem COPPER_SPIGOT_ITEM;
    public static BlockItem ALEMBIC_ITEM;
    public static BlockItem REFRACTORY_CLAY_ITEM;
    public static BlockItem REFRACTORY_BLOCK_ITEM;
    public static BlockItem REFRACTORY_BRICKS_ITEM;
    public static BlockItem ATHANOR_ITEM;
    
    public static BlockItem GREAT_OAK_LOG_ITEM;
    public static BlockItem GREAT_OAK_WOOD_ITEM;
    public static BlockItem GREAT_OAK_PLANKS_ITEM;
    public static BlockItem GREAT_OAK_LEAVES_ITEM;
    public static BlockItem STRIPPED_GREAT_OAK_LOG_ITEM;
    public static BlockItem STRIPPED_GREAT_OAK_WOOD_ITEM;
    public static BlockItem GREAT_OAK_STAIRS_ITEM;
    public static BlockItem GREAT_OAK_SLAB_ITEM;

    public static BlockItem HEARTWOOD_LOG_ITEM;
    public static BlockItem HEARTWOOD_WOOD_ITEM;
    public static BlockItem HEARTWOOD_PLANKS_ITEM;
    public static BlockItem HEARTWOOD_LEAVES_ITEM;
    public static BlockItem STRIPPED_HEARTWOOD_LOG_ITEM;
    public static BlockItem STRIPPED_HEARTWOOD_WOOD_ITEM;
    public static BlockItem HEARTWOOD_STAIRS_ITEM;
    public static BlockItem HEARTWOOD_SLAB_ITEM;

    public static BlockItem WILLOW_LOG_ITEM;
    public static BlockItem WILLOW_WOOD_ITEM;
    public static BlockItem WILLOW_PLANKS_ITEM;
    public static BlockItem WILLOW_LEAVES_ITEM;
    public static BlockItem STRIPPED_WILLOW_LOG_ITEM;
    public static BlockItem STRIPPED_WILLOW_WOOD_ITEM;
    public static BlockItem WILLOW_STAIRS_ITEM;
    public static BlockItem WILLOW_SLAB_ITEM;

    public static BlockItem ELM_LOG_ITEM;
    public static BlockItem ELM_WOOD_ITEM;
    public static BlockItem ELM_PLANKS_ITEM;
    public static BlockItem ELM_LEAVES_ITEM;
    public static BlockItem STRIPPED_ELM_LOG_ITEM;
    public static BlockItem STRIPPED_ELM_WOOD_ITEM;
    public static BlockItem ELM_STAIRS_ITEM;
    public static BlockItem ELM_SLAB_ITEM;
    
    public static BlockItem VITRIOL_ITEM;
    
    public TsItems() {

    }

    private static BlockItem blockItem(Block block) {
        return new BlockItem(block, new FabricItemSettings());
    }

    private static Item register(String id, Item item) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), item); }
    private static Item register(String id, StaffItem item) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), item); }
    private static BlockItem register(String id, BlockItem blockItem) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), blockItem); }
    
    public static void init() {
        // Item registry
        DEV_TOOL = register("devtool", new DevTool(new FabricItemSettings()));

        COPPER_SHEET = register("copper_sheet", new Item(new FabricItemSettings().maxCount(16)));
        REFRACTORY_CLAY_BRICK = register("refractory_clay_brick", new Item(new FabricItemSettings()));
        REFRACTORY_BRICK = register("refractory_brick", new Item(new FabricItemSettings().fireproof()));

        GREAT_OAK_STAFF_CORE = register("great_oak_staff_core", new Item(new FabricItemSettings()));
        HEARTWOOD_STAFF_CORE = register("heartwood_staff_core", new Item(new FabricItemSettings()));
        WILLOW_STAFF_CORE = register("willow_staff_core", new Item(new FabricItemSettings()));
        ELM_STAFF_CORE = register("elm_staff_core", new Item(new FabricItemSettings()));
        
        GREAT_OAK_STAFF = (StaffItem) register("great_oak_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof()));
        HEARTWOOD_STAFF = (StaffItem) register("heartwood_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof()));
        WILLOW_STAFF = (StaffItem) register("willow_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof()));
        ELM_STAFF = (StaffItem) register("elm_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof()));
        
        // Block item registry
        DEV_CUBE_ITEM = register("devcube", blockItem(TsBlocks.DEV_CUBE));
        
        AURIC_WORKBENCH_ITEM = register("auric_workbench", new BlockItem(TsBlocks.AURIC_WORKBENCH, new FabricItemSettings()));
        STAFF_PEDESTAL_ITEM = register("staff_pedestal", new BlockItem(TsBlocks.STAFF_PEDESTAL, new FabricItemSettings()));
        COPPER_TUBING_ITEM = register("copper_tubing", new BlockItem(TsBlocks.COPPER_TUBING, new FabricItemSettings()));
        COPPER_SPIGOT_ITEM = register("copper_spigot", new BlockItem(TsBlocks.COPPER_SPIGOT, new FabricItemSettings()));
        ALEMBIC_ITEM = register("alembic", new BlockItem(TsBlocks.ALEMBIC, new FabricItemSettings()));
        
        REFRACTORY_CLAY_ITEM = register("refractory_clay", new BlockItem(TsBlocks.REFRACTORY_CLAY, new FabricItemSettings()));
        REFRACTORY_BLOCK_ITEM = register("refractory_block", new BlockItem(TsBlocks.REFRACTORY_BLOCK, new FabricItemSettings().fireproof()));
        REFRACTORY_BRICKS_ITEM = register("refractory_bricks", new BlockItem(TsBlocks.REFRACTORY_BRICKS, new FabricItemSettings().fireproof()));
        ATHANOR_ITEM = register("athanor", new BlockItem(TsBlocks.ATHANOR, new FabricItemSettings().fireproof()));
        
        GREAT_OAK_LOG_ITEM = register("great_oak_log", blockItem(TsBlocks.GREAT_OAK_LOG));
        GREAT_OAK_WOOD_ITEM = register("great_oak_wood", blockItem(TsBlocks.GREAT_OAK_WOOD));
        GREAT_OAK_PLANKS_ITEM = register("great_oak_planks", blockItem(TsBlocks.GREAT_OAK_PLANKS));
        GREAT_OAK_LEAVES_ITEM = register("great_oak_leaves", blockItem(TsBlocks.GREAT_OAK_LEAVES));
        STRIPPED_GREAT_OAK_LOG_ITEM = register("stripped_great_oak_log", blockItem(TsBlocks.STRIPPED_GREAT_OAK_LOG));
        STRIPPED_GREAT_OAK_WOOD_ITEM = register("stripped_great_oak_wood", blockItem(TsBlocks.STRIPPED_GREAT_OAK_WOOD));
        GREAT_OAK_STAIRS_ITEM = register("great_oak_stairs", blockItem(TsBlocks.GREAT_OAK_STAIRS));
        GREAT_OAK_SLAB_ITEM = register("great_oak_slab", blockItem(TsBlocks.GREAT_OAK_SLAB));

        HEARTWOOD_LOG_ITEM = register("heartwood_log", blockItem(TsBlocks.HEARTWOOD_LOG));
        HEARTWOOD_WOOD_ITEM = register("heartwood_wood", blockItem(TsBlocks.HEARTWOOD_WOOD));
        HEARTWOOD_PLANKS_ITEM = register("heartwood_planks", blockItem(TsBlocks.HEARTWOOD_PLANKS));
        HEARTWOOD_LEAVES_ITEM = register("heartwood_leaves", blockItem(TsBlocks.HEARTWOOD_LEAVES));
        STRIPPED_HEARTWOOD_LOG_ITEM = register("stripped_heartwood_log", blockItem(TsBlocks.STRIPPED_HEARTWOOD_LOG));
        STRIPPED_HEARTWOOD_WOOD_ITEM = register("stripped_heartwood_wood", blockItem(TsBlocks.STRIPPED_HEARTWOOD_WOOD));
        HEARTWOOD_STAIRS_ITEM = register("heartwood_stairs", blockItem(TsBlocks.HEARTWOOD_STAIRS));
        HEARTWOOD_SLAB_ITEM = register("heartwood_slab", blockItem(TsBlocks.HEARTWOOD_SLAB));
        
        WILLOW_LOG_ITEM = register("willow_log", blockItem(TsBlocks.WILLOW_LOG));
        WILLOW_WOOD_ITEM = register("willow_wood", blockItem(TsBlocks.WILLOW_WOOD));
        WILLOW_PLANKS_ITEM = register("willow_planks", blockItem(TsBlocks.WILLOW_PLANKS));
        WILLOW_LEAVES_ITEM = register("willow_leaves", blockItem(TsBlocks.WILLOW_LEAVES));
        STRIPPED_WILLOW_LOG_ITEM = register("stripped_willow_log", blockItem(TsBlocks.STRIPPED_WILLOW_LOG));
        STRIPPED_WILLOW_WOOD_ITEM = register("stripped_willow_wood", blockItem(TsBlocks.STRIPPED_WILLOW_WOOD));
        WILLOW_STAIRS_ITEM = register("willow_stairs", blockItem(TsBlocks.WILLOW_STAIRS));
        WILLOW_SLAB_ITEM = register("willow_slab", blockItem(TsBlocks.WILLOW_SLAB));

        ELM_LOG_ITEM = register("elm_log", blockItem(TsBlocks.ELM_LOG));
        ELM_WOOD_ITEM = register("elm_wood", blockItem(TsBlocks.ELM_WOOD));
        ELM_PLANKS_ITEM = register("elm_planks", blockItem(TsBlocks.ELM_PLANKS));
        ELM_LEAVES_ITEM = register("elm_leaves", blockItem(TsBlocks.ELM_LEAVES));
        STRIPPED_ELM_LOG_ITEM = register("stripped_elm_log", blockItem(TsBlocks.STRIPPED_ELM_LOG));
        STRIPPED_ELM_WOOD_ITEM = register("stripped_elm_wood", blockItem(TsBlocks.STRIPPED_ELM_WOOD));
        ELM_STAIRS_ITEM = register("elm_stairs", blockItem(TsBlocks.ELM_STAIRS));
        ELM_SLAB_ITEM = register("elm_slab", blockItem(TsBlocks.ELM_SLAB));

        VITRIOL_ITEM = register("vitriol", blockItem(TsBlocks.VITRIOL));
    }
}
