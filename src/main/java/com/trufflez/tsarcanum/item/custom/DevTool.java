package com.trufflez.tsarcanum.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class DevTool extends Item {

    public DevTool(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        playerEntity.setVelocity(playerEntity.getVelocity().x, 0.5, playerEntity.getVelocity().z);
        playerEntity.playSound(SoundEvents.BLOCK_ANCIENT_DEBRIS_PLACE, 1.0f, 1.0f);
        
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
    
    public void appendTooltip(
            ItemStack stack, 
            World world,
            List<Text> tooltip,
            TooltipContext context
    ) {
        tooltip.add(new TranslatableText("Use wisely.").formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText("Press Shift for more information.").formatted(Formatting.DARK_GRAY));
        
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("Wow it's working! maybe").formatted(Formatting.AQUA));
        }
        
        super.appendTooltip(stack, world, tooltip, context);
    }
}
