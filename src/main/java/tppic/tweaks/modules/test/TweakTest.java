package tppic.tweaks.modules.test;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tppic.tweaks.lib.Module;
import tppic.tweaks.lib.Tweak;

/**
 * Created by McKeever on 27-Nov-16.
 */
public class TweakTest extends Tweak {
    public TweakTest(Module module) {
        super(module, "TestTweak", true, "This config is just a little test");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addTooltip(TextFormatting.RED + "hi", new ItemStack(Items.APPLE));
        addShapedRecipe(new ItemStack(Items.APPLE), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.ARROW));
        addShapelessRecipe(new ItemStack(Items.GOLDEN_APPLE), new ItemStack(Items.ARROW), "ingotGold", new ItemStack(Items.GOLD_NUGGET));
        removeRecipes(new ItemStack(Items.GOLDEN_CHESTPLATE));
        disableItem(new ItemStack(Items.ACACIA_BOAT));
        hideItem(new ItemStack(Items.DARK_OAK_DOOR));
        addOreDict(new ItemStack(Items.IRON_AXE), "axeIron");
        addOreDict(new ItemStack(Items.IRON_PICKAXE), "pickIron", "pickaxeIron");
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
