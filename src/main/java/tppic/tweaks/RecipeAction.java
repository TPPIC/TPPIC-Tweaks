package tppic.tweaks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by McKeever on 02-Nov-16.
 */
public class RecipeAction {
    public static void addRecipe(ItemStack output, Object... params){
        GameRegistry.addRecipe(output, params);
    }
}
