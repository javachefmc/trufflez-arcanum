package com.trufflez.tsarcanum.recipe;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

// CHECK FOR USAGE OF "SimpleInventory" / "BasicInventory" / "CraftingInventory" CLASS WIDE

public class AuricWorkbenchRecipe implements Recipe<SimpleInventory> {

    private final Ingredient slot1;
    private final Ingredient slot2;
    private final ItemStack outputStack;
    private final Identifier id;
    
    
    public AuricWorkbenchRecipe(Ingredient slot1,
                                Ingredient slot2,
                                ItemStack result,
                                Identifier id){
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.outputStack = result;
        this.id = id;
    }
    
    public Ingredient getSlot1() { return slot1; }
    public Ingredient getSlot2() { return slot2; }
    
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (inventory.size() < 2) return false;
        return slot1.test(inventory.getStack(0)) && slot2.test(inventory.getStack(1));
    }
    
    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return outputStack;
    }

    @Override
    public Identifier getId() {
        return id;
    }
    
    public static class Type implements RecipeType<AuricWorkbenchRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "auric_workbench_recipe";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AuricWorkbenchRecipeSerializer.INSTANCE;
    }
}
