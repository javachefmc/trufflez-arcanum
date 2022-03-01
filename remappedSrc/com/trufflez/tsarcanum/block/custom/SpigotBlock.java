package com.trufflez.tsarcanum.block.custom;

import com.trufflez.tsarcanum.block.TsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

@SuppressWarnings("unused")
public class SpigotBlock extends ConnectingBlock { // Based on ChorusPlantBlock
    /*
    TODO: Add tool that can change block state of tube based on side the tube is clicked on
     */
    public SpigotBlock(Settings settings) {
        super(0.1875F, settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState())
                .with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false)).with(UP, false)).with(DOWN, false));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.withConnectionProperties(ctx.getWorld(), ctx.getBlockPos());
    }

    public BlockState withConnectionProperties(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        BlockState blockState2 = world.getBlockState(pos.up());
        BlockState blockState3 = world.getBlockState(pos.north());
        BlockState blockState4 = world.getBlockState(pos.east());
        BlockState blockState5 = world.getBlockState(pos.south());
        BlockState blockState6 = world.getBlockState(pos.west());
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.getDefaultState()
                .with(DOWN, blockState.isOf(this) || blockState.isOf(TsBlocks.COPPER_TUBING)))
                .with(UP, blockState2.isOf(this) || blockState2.isOf(TsBlocks.COPPER_TUBING)))
                .with(NORTH, blockState3.isOf(this) || blockState3.isOf(TsBlocks.COPPER_TUBING)))
                .with(EAST, blockState4.isOf(this) || blockState4.isOf(TsBlocks.COPPER_TUBING)))
                .with(SOUTH, blockState5.isOf(this) || blockState5.isOf(TsBlocks.COPPER_TUBING)))
                .with(WEST, blockState6.isOf(this) || blockState6.isOf(TsBlocks.COPPER_TUBING));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            world.createAndScheduleBlockTick(pos, this, 1);
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        } else {
            boolean bl = neighborState.isOf(this) || neighborState.isOf(TsBlocks.COPPER_TUBING);
            return state.with(FACING_PROPERTIES.get(direction), bl);
        }
    }
    
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{NORTH, EAST, SOUTH, WEST, UP, DOWN});
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}