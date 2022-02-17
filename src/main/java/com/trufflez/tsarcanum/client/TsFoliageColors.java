package com.trufflez.tsarcanum.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class TsFoliageColors {
    //private static final double mult = 0.65; // multiplied by foliage colors
    
    public static int[] colorToArray(int c) { return new int[]{(c & 0xFF0000) >> 16, (c & 0x00FF00) >> 8, c & 0x0000FF}; }
    public static int arrayToColor(int[] c) { return (c[0] << 16) + (c[1] << 8) + c[2]; }
    
    public static int getBiomeGreatOakLeavesColor(BlockRenderView world, BlockPos pos) {
        int[] color = colorToArray(BiomeColors.getFoliageColor(world, pos));

        color[0] = (int) Math.round(color[0] * 0.50);
        color[1] = (int) Math.round(color[1] * 0.65);
        color[2] = (int) Math.round(color[2] * 0.65);

        return arrayToColor(color);
    }
    
    /*
    * Debug leaf color is 0x4764952
    * Minecraft Wiki standard color is 0x48B518
    * Extracted plains foliage color was 7842607 / 0x77AB2F
    * Extracted desert foliage color was 11445290 / 0xAEA42A
     */
    
    public static int getDefaultColor() { return 0x4764952; } // Debug color
    
    public static int getGreatOakLeavesColor() { return 0x2F7610; } // Used for item
    public static int getHeartwoodLeavesColor() { return 0xef2466; }
    public static int getWillowLeavesColor() { return 0xefdd44; }
    public static int getElmLeavesColor() { return 0xabee55; }
}
