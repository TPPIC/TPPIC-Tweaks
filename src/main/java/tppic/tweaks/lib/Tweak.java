package tppic.tweaks.lib;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tppic.tweaks.TPPICTweaks;
import tppic.tweaks.registry.TPPICTooltipHandler;
import tppic.tweaks.registry.Tooltip;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.List;

/**
 * Created by McKeever on 27-Nov-16.
 */
public abstract class Tweak {

    public boolean isEnabled;
    public boolean enabledDefault;
    public Module module;
    public String id;
    public String desc;

    public Tweak(@Nonnull Module module, @Nonnull String id, boolean isEnabledByDefault, @Nonnull String desc) {
        enabledDefault = isEnabledByDefault;
        this.module = module;
        this.id = id;
        this.desc = desc;

    }

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

    public final String getName() {
        return module.getName() + "." + id.toLowerCase();
    }

    public final String getDesc() {
        return desc;
    }

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
