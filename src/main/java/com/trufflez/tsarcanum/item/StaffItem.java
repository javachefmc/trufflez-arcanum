package com.trufflez.tsarcanum.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

@SuppressWarnings("unused")
public class StaffItem extends Item {
    
    public static final String[] FOCI = {
            "None",
            "Excavation",
            "Translocation"
    };
    
    public static final int[] FOCUS = {
            3, 4
    };
    
    public StaffItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        
        
        
        NbtCompound nbt;
        if( itemStack.hasNbt() ){ nbt = itemStack.getNbt(); }
        else { nbt = new NbtCompound(); }

        assert nbt != null;
        if (nbt.contains("Uses"))
        {
            nbt.putInt("Uses", nbt.getInt("Uses") + 1);
        }
        else
        {
            nbt.putInt("Uses", 1);
        }

        itemStack.setNbt(nbt);
        
        
        
        return TypedActionResult.success(itemStack);
    }
    
    /*
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        // We do nothing
    }
    
    
    @Override
    public UseAction getUseAction(ItemStack stack) {


        NbtCompound nbt;
        if( stack.hasNbt() ){ nbt = stack.getNbt(); }
        else { nbt = new NbtCompound(); }
        
        assert nbt != null;
        if (nbt.contains("Uses"))
        {
            nbt.putInt("Uses", nbt.getInt("Uses") + 1);
        }
        else
        {
            nbt.putInt("Uses", 1);
        }

        stack.setNbt(nbt);
        
        return UseAction.BOW;
    }*/
    
    // Staff-specific function
    public ItemStack setFocus(ItemStack stack, World world, PlayerEntity player, int id) {
        NbtCompound nbt;
        if( stack.hasNbt() ){ nbt = stack.getNbt(); }
        else { nbt = new NbtCompound(); }
        
        /*
        
        In the future, this function will use an index instead of setting the focus directly.
        This will allow any foci in whatever order the player chooses to be assigned.
        
         */
        
        /*assert nbt != null;
        if( nbt.contains("Foci") ) {
            
        }*/


       return stack;
    }

    public void appendTooltip(
            ItemStack stack,
            World world,
            List<Text> tooltip,
            TooltipContext context
    ) {
        tooltip.add(new TranslatableText("Focus: Excavation").formatted(Formatting.DARK_PURPLE));
        
        if (stack.hasNbt()) {
            assert stack.getNbt() != null;
            tooltip.add(new TranslatableText("Uses: " + stack.getNbt().getInt("Uses")).formatted(Formatting.GRAY));
        }
        
        super.appendTooltip(stack, world, tooltip, context);
    }
    
}
