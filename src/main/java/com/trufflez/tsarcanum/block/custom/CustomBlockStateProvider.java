package com.trufflez.tsarcanum.block.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;

import java.util.Random;

@SuppressWarnings("unused")
public class CustomBlockStateProvider extends BlockStateProvider {
    public static final Codec<CustomBlockStateProvider> CODEC;
    private final BlockState state;

    public CustomBlockStateProvider(BlockState state) {
        this.state = state;
    }

    public BlockStateProviderType<?> getType() {
        return BlockStateProviderType.SIMPLE_STATE_PROVIDER;
    }

    public BlockState getBlockState(Random random, BlockPos pos) {
        return this.state;
    }

    static {
        CODEC = BlockState.CODEC.fieldOf("state").xmap(CustomBlockStateProvider::new, (customBlockStateProvider) -> customBlockStateProvider.state).codec();
    }
}