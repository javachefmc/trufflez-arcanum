package com.trufflez.tsarcanum.blocks;

import com.trufflez.tsarcanum.TsArcanum;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class TsBlocks {
    public static Block DEV_CUBE;

    public static Block AURIC_WORKBENCH;
    public static Block STAFF_PEDESTAL;
    public static Block COPPER_TUBING;
    public static Block COPPER_SPIGOT;
    public static Block ALEMBIC;
    public static Block REFRACTORY_CLAY;
    public static Block REFRACTORY_BLOCK;
    public static Block REFRACTORY_BRICKS;
    public static Block ATHANOR;
    
    public static Block GREAT_OAK_LOG;
    public static Block GREAT_OAK_WOOD;
    public static Block GREAT_OAK_PLANKS;
    public static Block GREAT_OAK_LEAVES;
    public static Block STRIPPED_GREAT_OAK_LOG;
    public static Block STRIPPED_GREAT_OAK_WOOD;
    public static Block GREAT_OAK_STAIRS;
    public static Block GREAT_OAK_SLAB;
    
    public static Block HEARTWOOD_LOG;
    public static Block HEARTWOOD_WOOD;
    public static Block HEARTWOOD_PLANKS;
    public static Block HEARTWOOD_LEAVES;
    public static Block STRIPPED_HEARTWOOD_LOG;
    public static Block STRIPPED_HEARTWOOD_WOOD;
    public static Block HEARTWOOD_STAIRS;
    public static Block HEARTWOOD_SLAB;
    
    public static Block WILLOW_LOG;
    public static Block WILLOW_WOOD;
    public static Block WILLOW_PLANKS;
    public static Block WILLOW_LEAVES;
    public static Block STRIPPED_WILLOW_LOG;
    public static Block STRIPPED_WILLOW_WOOD;
    public static Block WILLOW_STAIRS;
    public static Block WILLOW_SLAB;
    
    public static Block ELM_LOG;
    public static Block ELM_WOOD;
    public static Block ELM_PLANKS;
    public static Block ELM_LEAVES;
    public static Block STRIPPED_ELM_LOG;
    public static Block STRIPPED_ELM_WOOD;
    public static Block ELM_STAIRS;
    public static Block ELM_SLAB;
    
    public static Block VITRIOL;
    
    public TsBlocks(){}

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
    private static Block register(String id, Block block) { return Registry.register(Registry.BLOCK, new Identifier(TsArcanum.MOD_ID, id), block); }
    
    
    
    
    public static void init() {
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
        GREAT_OAK_LEAVES = register("great_oak_leaves", createLeavesBlock());
        STRIPPED_GREAT_OAK_LOG = register("stripped_great_oak_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_GREAT_OAK_WOOD = register("stripped_great_oak_wood", createLogBlock(BlockSoundGroup.WOOD));
        GREAT_OAK_SLAB = register("great_oak_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        GREAT_OAK_STAIRS = register("great_oak_stairs", new TsStairsBlock(TsBlocks.GREAT_OAK_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
    
        HEARTWOOD_LOG = register("heartwood_log", createLogBlock(BlockSoundGroup.WOOD));
        HEARTWOOD_WOOD = register("heartwood_wood", createLogBlock(BlockSoundGroup.WOOD));
        HEARTWOOD_PLANKS = register("heartwood_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        HEARTWOOD_LEAVES = register("heartwood_leaves", createLeavesBlock());
        STRIPPED_HEARTWOOD_LOG = register("stripped_heartwood_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_HEARTWOOD_WOOD = register("stripped_heartwood_wood", createLogBlock(BlockSoundGroup.WOOD));
        HEARTWOOD_SLAB = register("heartwood_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        HEARTWOOD_STAIRS = register("heartwood_stairs", new TsStairsBlock(TsBlocks.HEARTWOOD_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        
        WILLOW_LOG = register("willow_log", createLogBlock(BlockSoundGroup.WOOD));
        WILLOW_WOOD = register("willow_wood", createLogBlock(BlockSoundGroup.WOOD));
        WILLOW_PLANKS = register("willow_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        WILLOW_LEAVES = register("willow_leaves", createLeavesBlock());
        STRIPPED_WILLOW_LOG = register("stripped_willow_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", createLogBlock(BlockSoundGroup.WOOD));
        WILLOW_SLAB = register("willow_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        WILLOW_STAIRS = register("willow_stairs", new TsStairsBlock(TsBlocks.WILLOW_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));

        ELM_LOG = register("elm_log", createLogBlock(BlockSoundGroup.WOOD));
        ELM_WOOD = register("elm_wood", createLogBlock(BlockSoundGroup.WOOD));
        ELM_PLANKS = register("elm_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));
        ELM_LEAVES = register("elm_leaves", createLeavesBlock());
        STRIPPED_ELM_LOG = register("stripped_elm_log", createLogBlock(BlockSoundGroup.WOOD));
        STRIPPED_ELM_WOOD = register("stripped_elm_wood", createLogBlock(BlockSoundGroup.WOOD));
        ELM_SLAB = register("elm_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f)));
        ELM_STAIRS = register("elm_stairs", new TsStairsBlock(TsBlocks.ELM_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.0f).sounds(BlockSoundGroup.WOOD)));

        VITRIOL = register("vitriol", new VitriolBlock(FabricBlockSettings.of(Material.GLASS).breakByHand(true).sounds(BlockSoundGroup.AMETHYST_CLUSTER).nonOpaque().luminance(8).dynamicBounds().noCollision()));
    }
}
