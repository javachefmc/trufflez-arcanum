package com.trufflez.tsarcanum.block;

import com.trufflez.tsarcanum.client.TsFoliageColors;
import com.trufflez.tsarcanum.item.TsItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.item.AxeItem;

import java.util.HashMap;

public class TsBlockProperties {

    public static void addStrippables() {
        AxeItem.STRIPPED_BLOCKS = new HashMap<>(AxeItem.STRIPPED_BLOCKS);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.GREAT_OAK_LOG, TsBlocks.STRIPPED_GREAT_OAK_LOG);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.GREAT_OAK_WOOD, TsBlocks.STRIPPED_GREAT_OAK_WOOD);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.HEARTWOOD_LOG, TsBlocks.STRIPPED_HEARTWOOD_LOG);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.HEARTWOOD_WOOD, TsBlocks.STRIPPED_HEARTWOOD_WOOD);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.WILLOW_LOG, TsBlocks.STRIPPED_WILLOW_LOG);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.WILLOW_WOOD, TsBlocks.STRIPPED_WILLOW_WOOD);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.ELM_LOG, TsBlocks.STRIPPED_ELM_LOG);
        AxeItem.STRIPPED_BLOCKS.put(TsBlocks.ELM_WOOD, TsBlocks.STRIPPED_ELM_WOOD);
    }
    
    public static void registerBlockProperties(){
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.GREAT_OAK_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.GREAT_OAK_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_GREAT_OAK_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_GREAT_OAK_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.GREAT_OAK_PLANKS, 2, 10);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.GREAT_OAK_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(TsSaplings.GREAT_OAK_SAPLING, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.GREAT_OAK_STAIRS, 2, 10);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.GREAT_OAK_SLAB, 2, 10);

        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.HEARTWOOD_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.HEARTWOOD_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_HEARTWOOD_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_HEARTWOOD_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.HEARTWOOD_PLANKS, 4, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.HEARTWOOD_LEAVES, 100, 600);
        FlammableBlockRegistry.getDefaultInstance().add(TsSaplings.HEARTWOOD_SAPLING, 100, 600);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.HEARTWOOD_STAIRS, 2, 10);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.HEARTWOOD_SLAB, 2, 10);

        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.WILLOW_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.WILLOW_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_WILLOW_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_WILLOW_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.WILLOW_PLANKS, 4, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.WILLOW_LEAVES, 100, 600);
        FlammableBlockRegistry.getDefaultInstance().add(TsSaplings.WILLOW_SAPLING, 100, 600);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.WILLOW_STAIRS, 2, 10);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.WILLOW_SLAB, 2, 10);

        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.ELM_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.ELM_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_ELM_LOG, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.STRIPPED_ELM_WOOD, 2, 2);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.ELM_PLANKS, 4, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.ELM_LEAVES, 100, 600);
        FlammableBlockRegistry.getDefaultInstance().add(TsSaplings.ELM_SAPLING, 100, 600);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.ELM_STAIRS, 2, 10);
        FlammableBlockRegistry.getDefaultInstance().add(TsBlocks.ELM_SLAB, 2, 10);

        CompostingChanceRegistry.INSTANCE.add(TsBlocks.GREAT_OAK_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsBlocks.HEARTWOOD_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsBlocks.WILLOW_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsBlocks.ELM_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsSaplings.GREAT_OAK_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsSaplings.HEARTWOOD_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsSaplings.WILLOW_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(TsSaplings.ELM_SAPLING, 0.30f);

        // Tinted block registry
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? TsFoliageColors.getBiomeGreatOakLeavesColor(world, pos) : TsFoliageColors.getDefaultColor(), TsBlocks.GREAT_OAK_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TsFoliageColors.getHeartwoodLeavesColor(), TsBlocks.HEARTWOOD_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TsFoliageColors.getWillowLeavesColor(), TsBlocks.WILLOW_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TsFoliageColors.getElmLeavesColor(), TsBlocks.ELM_LEAVES);

        // Tinted item registry
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TsFoliageColors.getGreatOakLeavesColor(), TsItems.GREAT_OAK_LEAVES_ITEM);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TsFoliageColors.getHeartwoodLeavesColor(), TsItems.HEARTWOOD_LEAVES_ITEM);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TsFoliageColors.getWillowLeavesColor(), TsItems.WILLOW_LEAVES_ITEM);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TsFoliageColors.getElmLeavesColor(), TsItems.ELM_LEAVES_ITEM);
       
        addStrippables();
    }
}
