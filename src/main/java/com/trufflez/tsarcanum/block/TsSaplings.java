package com.trufflez.tsarcanum.block;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.patches.TsSaplingBlock;
import com.trufflez.tsarcanum.item.TsItemGroups;
import com.trufflez.tsarcanum.world.feature.TsSaplingGenerator;
import com.trufflez.tsarcanum.world.feature.TsTreeConfiguredFeatures;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class TsSaplings {
    
    public static final TsSaplingBlock GREAT_OAK_SAPLING;
    public static final TsSaplingBlock HEARTWOOD_SAPLING;
    public static final TsSaplingBlock WILLOW_SAPLING;
    public static final TsSaplingBlock ELM_SAPLING;
    public static final TsSaplingBlock MYRTLE_SAPLING;
    public static final TsSaplingBlock SYCAMORE_SAPLING;
    
    public static final BlockItem GREAT_OAK_SAPLING_ITEM;
    public static final BlockItem HEARTWOOD_SAPLING_ITEM;
    public static final BlockItem WILLOW_SAPLING_ITEM;
    public static final BlockItem ELM_SAPLING_ITEM;
    public static final BlockItem MYRTLE_SAPLING_ITEM;
    public static final BlockItem SYCAMORE_SAPLING_ITEM;
    
    public TsSaplings() {}

    private static boolean yes(BlockState state, BlockView blockView, BlockPos pos) { return true; }
    private static boolean no(BlockState state, BlockView blockView, BlockPos pos) { return false; }
    
    private static BlockItem blockItem(Block block) {
        return new BlockItem(block, new FabricItemSettings().group(TsItemGroups.MAIN));
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
    
    private static TsSaplingBlock register(String id, TsSaplingBlock tsSaplingBlock) {
        return Registry.register(Registry.BLOCK, new Identifier(TsArcanum.MOD_ID, id), tsSaplingBlock);
    }
    
    private static BlockItem register(String id, BlockItem blockItem) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), blockItem); }
    
    
    static {
        GREAT_OAK_SAPLING = register("great_oak_sapling", TsTreeConfiguredFeatures.GREAT_OAK);
        HEARTWOOD_SAPLING = register("heartwood_sapling", TsTreeConfiguredFeatures.HEARTWOOD);
        WILLOW_SAPLING = register("willow_sapling", TsTreeConfiguredFeatures.WILLOW);
        ELM_SAPLING = register("elm_sapling", TsTreeConfiguredFeatures.ELM);
        MYRTLE_SAPLING = register("myrtle_sapling", TsTreeConfiguredFeatures.MYRTLE);
        SYCAMORE_SAPLING = register("sycamore_sapling", TsTreeConfiguredFeatures.SYCAMORE);

        GREAT_OAK_SAPLING_ITEM = register("great_oak_sapling", blockItem(GREAT_OAK_SAPLING));
        HEARTWOOD_SAPLING_ITEM = register("heartwood_sapling", blockItem(HEARTWOOD_SAPLING));
        WILLOW_SAPLING_ITEM = register("willow_sapling", blockItem(WILLOW_SAPLING));
        ELM_SAPLING_ITEM = register("elm_sapling", blockItem(ELM_SAPLING));
        MYRTLE_SAPLING_ITEM = register("myrtle_sapling", blockItem(MYRTLE_SAPLING));
        SYCAMORE_SAPLING_ITEM = register("sycamore_sapling", blockItem(SYCAMORE_SAPLING));
    }

    public static void init() {
        TsArcanum.LOGGER.info("Registering saplings");
    }
}
