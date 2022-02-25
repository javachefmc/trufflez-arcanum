package com.trufflez.tsarcanum.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.trufflez.tsarcanum.TsArcanum;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AuricWorkbenchRecipeSerializer implements RecipeSerializer <AuricWorkbenchRecipe>{
    
    /*private AuricWorkbenchRecipeSerializer() {
        
    }
    */
    public static final AuricWorkbenchRecipeSerializer INSTANCE = new AuricWorkbenchRecipeSerializer();
    
    
     
    // "type" field in json
    public static final Identifier ID = new Identifier(TsArcanum.MOD_ID, "auric_workbench");
    
    @Override
    public AuricWorkbenchRecipe read(Identifier id, JsonObject json) { // turns json into Recipe
        AuricWorkbenchRecipeJsonFormat recipeJson =  new Gson().fromJson(json, AuricWorkbenchRecipeJsonFormat.class);
        
        // Ingredient turns correctly formatted JsonObjects into Ingredients (from documentation)
        Ingredient slot1 = Ingredient.fromJson(recipeJson.slot1);
        Ingredient slot2 = Ingredient.fromJson(recipeJson.slot2);
        
        // Retrieve item instance in registry based on json
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);
        
        return new AuricWorkbenchRecipe(slot1, slot2, output, id);
    }
    
    
    // turns Recipe into PacketByteBuf
    @Override
    public void write(PacketByteBuf packetData, AuricWorkbenchRecipe recipe) {
        recipe.getSlot1().write(packetData);
        recipe.getSlot2().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }
    
    
    // turns PacketByteBuf into Recipe
    @Override
    public AuricWorkbenchRecipe read(Identifier id, PacketByteBuf packetData) {
        // Read in the same order you write!
        Ingredient slot1 = Ingredient.fromPacket(packetData);
        Ingredient slot2 = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new AuricWorkbenchRecipe(slot1, slot2, output, id);
    }
}
