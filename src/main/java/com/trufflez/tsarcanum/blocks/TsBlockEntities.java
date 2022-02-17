package com.trufflez.tsarcanum.blocks;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.screen.AuricWorkbenchScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class TsBlockEntities {

    public static BlockEntityType<AuricWorkbenchBlockEntity> AURIC_WORKBENCH_BLOCKENTITY;
    public static ScreenHandlerType<AuricWorkbenchScreenHandler> AURIC_WORKBENCH_SCREENHANDLER;

    public TsBlockEntities() {}
    
    
    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> blockEntityType) { return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(TsArcanum.MOD_ID, id), blockEntityType); }
    

    public static void init() {
        AURIC_WORKBENCH_BLOCKENTITY = register("auric_workbench", FabricBlockEntityTypeBuilder.create(AuricWorkbenchBlockEntity::new, TsBlocks.AURIC_WORKBENCH).build(null));
        AURIC_WORKBENCH_SCREENHANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(TsArcanum.MOD_ID, "auric_workbench"), AuricWorkbenchScreenHandler::new);
    }
}
