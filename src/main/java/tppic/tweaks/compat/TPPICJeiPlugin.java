package tppic.tweaks.compat;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import tppic.tweaks.TPPICTweaks;

import javax.annotation.Nonnull;

/**
 * Created by McKeever on 27-Nov-16.
 */

@mezz.jei.api.JEIPlugin
public class TPPICJeiPlugin extends BlankModPlugin {
    @Override
    public void register(
            @Nonnull
                    IModRegistry registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

        for (ItemStack stack : TPPICTweaks.DISABLED_ITEMS) {
            jeiHelpers.getItemBlacklist().addItemToBlacklist(stack);
        }

        for (ItemStack stack : TPPICTweaks.HIDDEN_ITEMS) {
            jeiHelpers.getItemBlacklist().addItemToBlacklist(stack);
        }
    }
}
