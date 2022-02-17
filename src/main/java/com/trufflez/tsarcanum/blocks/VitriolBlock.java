package com.trufflez.tsarcanum.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.GlassBlock;

public class VitriolBlock extends GlassBlock { // TODO: change this to WallMountedBlock
    public VitriolBlock(Settings settings) {
        super(settings);
    }

    @Override
    public AbstractBlock.OffsetType getOffsetType() {
        return OffsetType.XYZ;
    }
    
}
