package com.trufflez.tsarcanum.block;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.custom.AuricWorkbench;
import com.trufflez.tsarcanum.block.custom.StaffPedestal;
import com.trufflez.tsarcanum.block.custom.VitriolBlock;
import com.trufflez.tsarcanum.block.patches.TsStairsBlock;
import com.trufflez.tsarcanum.item.TsItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class TsBlocks {
    public static final Block DEV_CUBE;

    public static final Block AURIC_WORKBENCH;
    public static final Block STAFF_PEDESTAL;
    public static final Block COPPER_TUBING;
    public static final Block COPPER_SPIGOT;
    public static final Block ALEMBIC;
    public static final Block REFRACTORY_CLAY;
    public static final Block REFRACTORY_BLOCK;
    public static final Block REFRACTORY_BRICKS;
    public static final Block ATHANOR;
    
    public static final Block GREAT_OAK_LOG;
    public static final Block GREAT_OAK_WOOD;
    public static final Block GREAT_OAK_PLANKS;
    public static final Block GREAT_OAK_LEAVES;
    public static final Block STRIPPED_GREAT_OAK_LOG;
    public static final Block STRIPPED_GREAT_OAK_WOOD;
    public static final Block GREAT_OAK_STAIRS;
    public static final Block GREAT_OAK_SLAB;
    
    public static final Block HEARTWOOD_LOG;
    public static final Block HEARTWOOD_WOOD;
    public static final Block HEARTWOOD_PLANKS;
    public static final Block HEARTWOOD_LEAVES;
    public static final Block STRIPPED_HEARTWOOD_LOG;
    public static final Block STRIPPED_HEARTWOOD_WOOD;
    public static final Block HEARTWOOD_STAIRS;
    public static final Block HEARTWOOD_SLAB;
    
    public static final Block WILLOW_LOG;
    public static final Block WILLOW_WOOD;
    public static final Block WILLOW_PLANKS;
    public static final Block WILLOW_LEAVES;
    public static final Block STRIPPED_WILLOW_LOG;
    public static final Block STRIPPED_WILLOW_WOOD;
    public static final Block WILLOW_STAIRS;
    public static final Block WILLOW_SLAB;
    
    public static final Block ELM_LOG;
    public static final Block ELM_WOOD;
    public static final Block ELM_PLANKS;
    public static final Block ELM_LEAVES;
    public static final Block STRIPPED_ELM_LOG;
    public static final Block STRIPPED_ELM_WOOD;
    public static final Block ELM_STAIRS;
    public static final Block ELM_SLAB;
    
    public static final Block VITRIOL;
    
    private static boolean yes(BlockState state, BlockView blockView, BlockPos pos) { return true; }
    private static boolean no(BlockState state, BlockView blockView, BlockPos pos) { return false; }
    
    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
    
    // Blocks with common parameters
    private static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(FabricBlockSettings.of(Material.LEAVES)
                .strength(0.2f)
                .ticksRandomly()
                .sounds(BlockSoundGroup.GRASS)
                .nonOpaque()
                .allowsSpawning(TsBlocks::canSpawnOnLeaves)
                .suffocates(TsBlocks::no)
                .blockVision(TsBlocks::no)
        );
    }
    
    private static PillarBlock createLogBlock(BlockSoundGroup soundGroup) {
        return new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(soundGroup));
    }
    
    // Register shortcuts
    private static Block registerCustom(String id, Block block) {
        //registerBlockItem(id, block);
        return Registry.register(Registry.BLOCK, new Identifier(TsArcanum.MOD_ID, id), block);
    }

    private static Block register(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registry.BLOCK, new Identifier(TsArcanum.MOD_ID, id), block);
    }
    
    private static Item registerBlockItem(String id, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id),
                new BlockItem(block, new FabricItemSettings().group(TsItemGroups.MAIN)));
    }
    
    static {
        DEV_CUBE = register("devcube", new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f)));
        
        AURIC_WORKBENCH = register("auric_workbench", new AuricWorkbench(FabricBlockSettings.of(Material.WOOD).strength(4.0f)));
        STAFF_PEDESTAL = register("staff_pedestal", new StaffPedestal(FabricBlockSettings.of(Material.STONE).nonOpaque().luminance(15)));
        COPPER_TUBING = register("copper_tubing", new Block(FabricBlockSettings.of(Material.STONE).nonOpaque()));
        COPPER_SPIGOT = register("copper_spigot", new Block(FabricBlockSettings.of(Material.STONE).nonOpaque()));
        ALEMBIC = register("alembic", new Block(FabricBlockSettings.of(Material.STONE).nonOpaque()));
        
        REFRACTORY_CLAY = register("refractory_clay", new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f)));
        REFRACTORY_BLOCK = register("refractory_block", new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f)));
        REFRACTORY_BRICKS = register("refractory_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f)));
        ATHANOR = register("athanor", new Block(FabricBlockSettings.of(Material.STONE)));

        GREAT_OAK_LOG = register("great_oak_log", createLogBlock(BlockSoundGroup.WOOD));
        GREAT_OAK_WOOD = register("great_oak_wood", createLogBlock(BlockSoundGroup.WOOD));
        GREAT_OAK_PLANKS = register("great_oak_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        GREAT_OAK_LEAVES = registerCustom("great_oak_leaves", createLeavesBlock());
        STRIPPED_GREAT_OAK_LOG = register("stripped_great_oak_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_GREAT_OAK_WOOD = register("stripped_great_oak_wood", createLogBlock(BlockSoundGroup.WOOD));
        GREAT_OAK_SLAB = register("great_oak_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        GREAT_OAK_STAIRS = register("great_oak_stairs", new TsStairsBlock(TsBlocks.GREAT_OAK_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
    
        HEARTWOOD_LOG = register("heartwood_log", createLogBlock(BlockSoundGroup.WOOD));
        HEARTWOOD_WOOD = register("heartwood_wood", createLogBlock(BlockSoundGroup.WOOD));
        HEARTWOOD_PLANKS = register("heartwood_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        HEARTWOOD_LEAVES = registerCustom("heartwood_leaves", createLeavesBlock());
        STRIPPED_HEARTWOOD_LOG = register("stripped_heartwood_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_HEARTWOOD_WOOD = register("stripped_heartwood_wood", createLogBlock(BlockSoundGroup.WOOD));
        HEARTWOOD_SLAB = register("heartwood_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        HEARTWOOD_STAIRS = register("heartwood_stairs", new TsStairsBlock(TsBlocks.HEARTWOOD_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        
        WILLOW_LOG = register("willow_log", createLogBlock(BlockSoundGroup.WOOD));
        WILLOW_WOOD = register("willow_wood", createLogBlock(BlockSoundGroup.WOOD));
        WILLOW_PLANKS = register("willow_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        WILLOW_LEAVES = registerCustom("willow_leaves", createLeavesBlock());
        STRIPPED_WILLOW_LOG = register("stripped_willow_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", createLogBlock(BlockSoundGroup.WOOD));
        WILLOW_SLAB = register("willow_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        WILLOW_STAIRS = register("willow_stairs", new TsStairsBlock(TsBlocks.WILLOW_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));

        ELM_LOG = register("elm_log", createLogBlock(BlockSoundGroup.WOOD));
        ELM_WOOD = register("elm_wood", createLogBlock(BlockSoundGroup.WOOD));
        ELM_PLANKS = register("elm_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        ELM_LEAVES = registerCustom("elm_leaves", createLeavesBlock());
        STRIPPED_ELM_LOG = register("stripped_elm_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_ELM_WOOD = register("stripped_elm_wood", createLogBlock(BlockSoundGroup.WOOD));
        ELM_SLAB = register("elm_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        ELM_STAIRS = register("elm_stairs", new TsStairsBlock(TsBlocks.ELM_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        
        VITRIOL = register("vitriol", new VitriolBlock(FabricBlockSettings.of(Material.GLASS).breakByHand(true).sounds(BlockSoundGroup.AMETHYST_CLUSTER).nonOpaque().luminance(8).dynamicBounds().noCollision()));
    }
    
    public static void init() {
        TsArcanum.LOGGER.info("Registering blocks.");
    }
}
