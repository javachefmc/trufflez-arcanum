package com.trufflez.tsarcanum.item;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsBlocks;
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
    
    // Custom BlockItems
    public static BlockItem GREAT_OAK_LEAVES_ITEM;
    public static BlockItem HEARTWOOD_LEAVES_ITEM;
    public static BlockItem WILLOW_LEAVES_ITEM;
    public static BlockItem ELM_LEAVES_ITEM;
    
    public TsItems() {

    }

    private static BlockItem blockItem(Block block) {
        return new BlockItem(block, new FabricItemSettings().group(TsItemGroup.TS_MAIN));
    }

    private static Item register(String id, Item item) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), item); }
    private static Item register(String id, StaffItem item) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), item); }
    private static BlockItem register(String id, BlockItem blockItem) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), blockItem); }
    
    public static void init() {
        // Custom block item registry
        GREAT_OAK_LEAVES_ITEM = register("great_oak_leaves", blockItem(TsBlocks.GREAT_OAK_LEAVES));
        HEARTWOOD_LEAVES_ITEM = register("heartwood_leaves", blockItem(TsBlocks.HEARTWOOD_LEAVES));
        WILLOW_LEAVES_ITEM = register("willow_leaves", blockItem(TsBlocks.WILLOW_LEAVES));
        ELM_LEAVES_ITEM = register("elm_leaves", blockItem(TsBlocks.ELM_LEAVES));
        
        // Item registry
        DEV_TOOL = register("devtool", new DevTool(new FabricItemSettings()));

        COPPER_SHEET = register("copper_sheet", new Item(new FabricItemSettings().maxCount(16).group(TsItemGroup.TS_MAIN)));
        REFRACTORY_CLAY_BRICK = register("refractory_clay_brick", new Item(new FabricItemSettings().group(TsItemGroup.TS_MAIN)));
        REFRACTORY_BRICK = register("refractory_brick", new Item(new FabricItemSettings().fireproof().group(TsItemGroup.TS_MAIN)));

        GREAT_OAK_STAFF_CORE = register("great_oak_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.TS_MAIN)));
        HEARTWOOD_STAFF_CORE = register("heartwood_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.TS_MAIN)));
        WILLOW_STAFF_CORE = register("willow_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.TS_MAIN)));
        ELM_STAFF_CORE = register("elm_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.TS_MAIN)));
        
        GREAT_OAK_STAFF = (StaffItem) register("great_oak_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.TS_MAIN)));
        HEARTWOOD_STAFF = (StaffItem) register("heartwood_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.TS_MAIN)));
        WILLOW_STAFF = (StaffItem) register("willow_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.TS_MAIN)));
        ELM_STAFF = (StaffItem) register("elm_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.TS_MAIN)));
    }
    
    
    public static void registerItems() {
        TsArcanum.LOGGER.info("Registering items");
    }
}
