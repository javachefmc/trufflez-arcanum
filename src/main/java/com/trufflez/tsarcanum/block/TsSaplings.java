package com.trufflez.tsarcanum.block;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.patches.TsSaplingBlock;
import com.trufflez.tsarcanum.world.feature.TsSaplingGenerator;
import com.trufflez.tsarcanum.world.feature.TsTreeConfiguredFeatures;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

@SuppressWarnings("unused")
public class TsSaplings {
    public static TsSaplingBlock GREAT_OAK_SAPLING;
    public static TsSaplingBlock HEARTWOOD_SAPLING;
    public static TsSaplingBlock WILLOW_SAPLING;
    public static TsSaplingBlock ELM_SAPLING;
    
    public static BlockItem GREAT_OAK_SAPLING_ITEM;
    public static BlockItem HEARTWOOD_SAPLING_ITEM;
    public static BlockItem WILLOW_SAPLING_ITEM;
    public static BlockItem ELM_SAPLING_ITEM;
    
    public TsSaplings() {
        
    }

    private static boolean yes(BlockState state, BlockView blockView, BlockPos pos) { return true; }
    private static boolean no(BlockState state, BlockView blockView, BlockPos pos) { return false; }
    
    private static BlockItem blockItem(Block block) {
        return new BlockItem(block, new FabricItemSettings());
    }

    private static TsSaplingBlock register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return Registry.register(Registry.BLOCK, new Identifier(TsArcanum.MOD_ID, id),
                new TsSaplingBlock(new TsSaplingGenerator(configuredFeature), FabricBlockSettings.of(Material.PLANT)
                        .nonOpaque()
                        .sounds(BlockSoundGroup.GRASS)
                        .suffocates(TsSaplings::no)
                        .blockVision(TsSaplings::no)
                        .noCollision()
                ));
    }

    //private FabricBlockSettings fabricBlockSettings = FabricBlockSettings.copyOf(Blocks.OAK_SAPLING);
    
    /*private static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(FabricBlockSettings.of(Material.LEAVES)
                .strength(0.2f)
                .ticksRandomly()
                .sounds(BlockSoundGroup.GRASS)
                .nonOpaque()
                .allowsSpawning(TsBlocks::canSpawnOnLeaves)
                .suffocates(TsBlocks::no)
                .blockVision(TsBlocks::no)
        );
    }*/

    private static Block registerBlock(String name, Block block){
        //registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(TsArcanum.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static BlockItem register(String id, BlockItem blockItem) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), blockItem); }

    
    public static void init() {
        //GREAT_OAK_SAPLING = register("great_oak_sapling", TsTreeConfiguredFeatures.GREAT_OAK);
        
        
        GREAT_OAK_SAPLING = register("great_oak_sapling", TsTreeConfiguredFeatures.GREAT_OAK);
        HEARTWOOD_SAPLING = register("heartwood_sapling", TsTreeConfiguredFeatures.HEARTWOOD);
        WILLOW_SAPLING = register("willow_sapling", TsTreeConfiguredFeatures.WILLOW);
        ELM_SAPLING = register("elm_sapling", TsTreeConfiguredFeatures.ELM);

        GREAT_OAK_SAPLING_ITEM = register("great_oak_sapling", blockItem(TsSaplings.GREAT_OAK_SAPLING));
        HEARTWOOD_SAPLING_ITEM = register("heartwood_sapling", blockItem(TsSaplings.HEARTWOOD_SAPLING));
        WILLOW_SAPLING_ITEM = register("willow_sapling", blockItem(TsSaplings.WILLOW_SAPLING));
        ELM_SAPLING_ITEM = register("elm_sapling", blockItem(TsSaplings.ELM_SAPLING));
    }
}
