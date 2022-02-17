package com.trufflez.tsarcanum.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class AuricWorkbench extends BlockWithEntity implements BlockEntityProvider { // This was "block" but that didn't work
    
    public AuricWorkbench(Settings settings) { // this was "protected" but that didn't work
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AuricWorkbenchBlockEntity(pos, state);
    }
    
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            
            if(screenHandlerFactory != null) {
                // server asks client to open screen handler
                player.openHandledScreen(screenHandlerFactory);
                //return ActionResult.CONSUME; // From a different tutorial
            }
        }
        
        if (world.isClient) {
            //TsAlchemy.LOG.info("Block right-clicked");
        }
        
        return ActionResult.SUCCESS;
    }
    
    
    //@Override
    /* TODO: literally all of this
    public boolean activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // go through server first!
        if (!world.isClient()) {
            //SimpleInventory inventory = new SimpleInventory(9);
            
            //WorkbenchGoldBlockEntity inventory;
            
            
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof WorkbenchGoldBlockEntity) {

                DefaultedList<ItemStack> itemsInBlock = ((WorkbenchGoldBlockEntity) blockEntity).getItems();
                
                
                
                
                

                Optional<AuricRecipe> match = world.getRecipeManager().getFirstMatch(AuricRecipe.Type.INSTANCE, itemsInBlock, world);
            }
            
            
            //Optional<AuricRecipe> match = world.getRecipeManager().getFirstMatch(AuricRecipe.Type.INSTANCE, inventory, world);
            if(match.isPresent()){
                player.getInventory().offerOrDrop(match.get().getOutput().copy());
            }
            
        }
        return true;
    }*/
    
    
    // drop items when broken
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) { // check block is destroyed?
            // this is how we get the inventory of the block entity
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AuricWorkbenchBlockEntity) {
                ItemScatterer.spawn(world, pos, (AuricWorkbenchBlockEntity)blockEntity);
                // update comparators
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}