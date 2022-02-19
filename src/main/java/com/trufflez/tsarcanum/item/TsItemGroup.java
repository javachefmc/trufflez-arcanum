package com.trufflez.tsarcanum.item;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TsItemGroup {
    public static final ItemGroup MAIN = FabricItemGroupBuilder.build(new Identifier(TsArcanum.MOD_ID, "main"),
            () -> new ItemStack(TsBlocks.AURIC_WORKBENCH));
}
