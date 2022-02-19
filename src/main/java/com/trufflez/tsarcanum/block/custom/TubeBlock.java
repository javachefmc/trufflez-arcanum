package com.trufflez.tsarcanum.block.custom;

import net.minecraft.block.HorizontalConnectingBlock;

@SuppressWarnings("unused")
public class TubeBlock extends HorizontalConnectingBlock {
    protected TubeBlock(float radius1, float radius2, float boundingHeight1, float boundingHeight2, float collisionHeight, Settings settings) {
        super(radius1, radius2, boundingHeight1, boundingHeight2, collisionHeight, settings);
    }
    
    
    
    /*
    TODO: Add tool that can change block state of tube based on side the tube is clicked on
     */
    
}
