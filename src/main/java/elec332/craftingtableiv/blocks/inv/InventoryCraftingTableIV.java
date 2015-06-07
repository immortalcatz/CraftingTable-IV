package elec332.craftingtableiv.blocks.inv;

import com.google.common.collect.Lists;
import elec332.craftingtableiv.handler.CraftingHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.List;

/**
 * Created by Elec332 on 23-3-2015.
 */
public class InventoryCraftingTableIV {

    private List<IRecipe> recipes;

    public InventoryCraftingTableIV() {
        recipes = Lists.newArrayList();
    }

    public int getSize() {
        return recipes.size();
    }

    public boolean forceAddRecipe(IRecipe irecipe){
        return recipes.add(irecipe);
    }

    public boolean addRecipe(IRecipe irecipe) {
        return canAdd(irecipe) && recipes.add(irecipe);
    }

    public IRecipe getIRecipe(int i) {
        return recipes.get(i);
    }
    public boolean canAdd(IRecipe irecipe){
        return !recipes.contains(irecipe);
    }

    public ItemStack getRecipeOutput(int i) {
        return getIRecipe(i).getRecipeOutput().copy();
    }

    public void clearRecipes() {
        recipes.clear();
    }

    public void writeToNBT(NBTTagCompound tagCompound){
        NBTTagList list = new NBTTagList();
        NBTTagCompound tag;
        for (IRecipe recipe : recipes) {
            tag = new NBTTagCompound();
            tag.setInteger("index", CraftingHandler.recipeList.indexOf(recipe));
            list.appendTag(tag);
        }
        tagCompound.setTag("data", list);
    }

    public void readFromNBT(NBTTagCompound tagCompound){
        if (tagCompound == null)
            return;
        NBTTagList tagList = tagCompound.getTagList("data", 10);
        recipes.clear();
        for (int i = 0; i < tagList.tagCount(); i++) {
            recipes.add(CraftingHandler.recipeList.get(tagList.getCompoundTagAt(i).getInteger("index")));
        }
    }
}