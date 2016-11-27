package tppic.tweaks.registry;


import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by McKeever on 27-Nov-16.
 */
public class Tooltip {

    public String string;
    public List<ItemStack> stacks = new ArrayList<ItemStack>();

    public Tooltip(String text, ItemStack... itemStacks) {
        string = text;
        for (ItemStack i : itemStacks) {
            stacks.add(i);
        }
    }
}
