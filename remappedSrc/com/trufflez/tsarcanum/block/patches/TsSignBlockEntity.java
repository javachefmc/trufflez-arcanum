package com.trufflez.tsarcanum.block.patches;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

@SuppressWarnings("unused")
public class TsSignBlockEntity extends SignBlockEntity {
    public TsSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }
}
