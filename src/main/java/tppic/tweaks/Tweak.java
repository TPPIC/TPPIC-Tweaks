package tppic.tweaks;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tppic.tweaks.registry.TPPICTooltipHandler;
import tppic.tweaks.registry.Tooltip;

import java.util.Iterator;
import java.util.List;

/**
 * Created by McKeever on 27-Nov-16.
 */
public abstract class Tweak {

    public static void addShapedRecipe(ItemStack output, Object... params) {
        GameRegistry.addRecipe(new ShapedOreRecipe(output, params));
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, params));
    }

    public static void addOreDict(ItemStack stack, String... oreDictNames) {
        for (String i : oreDictNames) {
            OreDictionary.registerOre(i, stack);
        }
    }

    public static void hideItem(ItemStack stack) {
        TPPICTweaks.HIDDEN_ITEMS.add(stack);
    }

    public static void disableItem(ItemStack stack) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> it = recipes.iterator();
        while (it.hasNext()) {
            ItemStack is = it.next().getRecipeOutput();
            if (is != null && is.isItemEqual(stack))
                it.remove();
        }
        TPPICTweaks.DISABLED_ITEMS.add(stack);
    }

    public static void removeRecipes(ItemStack stack) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> it = recipes.iterator();
        while (it.hasNext()) {
            ItemStack is = it.next().getRecipeOutput();
            if (is != null && is.isItemEqual(stack))
                it.remove();
        }
    }

    public static void addTooltip(String tooltip, ItemStack... itemStacks) {
        TPPICTooltipHandler.REGISTRY.add(new Tooltip(tooltip, itemStacks));
    }

    public abstract String setTweakID();

    public abstract Module setModule();

    public final String getName() {
        if (setModule() == null || setTweakID() == null) {
            System.out.println("Warning: Tweak ID or Tweak Module is null");
            return null;
        }
        return setModule().getName() + "." + setTweakID().toLowerCase();
    }

    public abstract void preInit();

    public abstract void init();

    public abstract void postInit();
}
