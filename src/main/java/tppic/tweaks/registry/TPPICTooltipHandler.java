package tppic.tweaks.registry;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tppic.tweaks.TPPICTweaks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by McKeever on 27-Nov-16.
 */
public class TPPICTooltipHandler {

    public static List<Tooltip> REGISTRY = new ArrayList<Tooltip>();

    @SubscribeEvent
    public void itemTooltip(ItemTooltipEvent event) {
        for (Tooltip i : REGISTRY) {
            for (ItemStack j : i.stacks) {
                if (event.getItemStack().isItemEqual(j)) {
                    event.getToolTip().add(i.string);
                }
            }
        }

        for (ItemStack stack : TPPICTweaks.DISABLED_ITEMS) {
            if (event.getItemStack().isItemEqual(stack)) {
                event.getToolTip().clear();
                event.getToolTip().add(TextFormatting.RED + "This item has been disabled by " + TextFormatting.BLUE + TextFormatting.ITALIC + "TPPIC-Tweaks");
            }
        }
    }

}
