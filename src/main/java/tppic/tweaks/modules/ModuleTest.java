package tppic.tweaks.modules;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import tppic.tweaks.Module;
import tppic.tweaks.SimpleTweak;
import tppic.tweaks.Tweak;

import java.util.Collection;

/**
 * Created by McKeever on 26-Nov-16.
 */
public class ModuleTest extends Module {

    public Tweak TEST_TWEAK = new SimpleTweak(this, "TestTweak");

    @Override
    protected String setModuleID() {
        return "TestModule";
    }

    @Override
    protected String setTweakModID() {
        return "tppictweaks";
    }

    @Override
    public Collection<String> getDependencies() {
        return null;
       /* return new ArrayList<String>() {
            {
                add("dep1");
                add("dep2");
                add("dep3");
                add("dep4");
                add("etc.");
            }
        };*/
    }

    @Override
    public void preInit() {
        TEST_TWEAK.addTooltip(TextFormatting.RED + "hi", new ItemStack(Items.APPLE));
        TEST_TWEAK.addShapedRecipe(new ItemStack(Items.APPLE), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.ARROW));
        TEST_TWEAK.addShapelessRecipe(new ItemStack(Items.GOLDEN_APPLE), new ItemStack(Items.ARROW), "ingotGold", new ItemStack(Items.GOLD_NUGGET));
        TEST_TWEAK.removeRecipes(new ItemStack(Items.GOLDEN_CHESTPLATE));
        TEST_TWEAK.disableItem(new ItemStack(Items.ACACIA_BOAT));
        TEST_TWEAK.hideItem(new ItemStack(Items.DARK_OAK_DOOR));
        TEST_TWEAK.addOreDict(new ItemStack(Items.IRON_AXE), "axeIron");
        TEST_TWEAK.addOreDict(new ItemStack(Items.IRON_PICKAXE), "pickIron", "pickaxeIron");
    }

    @Override
    public void init() {
    }

    @Override
    public void postInit() {
    }
}
