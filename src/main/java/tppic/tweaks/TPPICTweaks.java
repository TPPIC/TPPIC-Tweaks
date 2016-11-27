package tppic.tweaks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tppic.tweaks.registry.TPPICTooltipHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by McKeever on 02-Nov-16.
 */
@Mod(modid = "tppictweaks", name = "TPPIC Tweaks", version = "1.10.2-1.0.0", dependencies = "required-after:JEI;after:*")
public class TPPICTweaks {

    @Mod.Instance("tppictweaks")
    public static TPPICTweaks instance;

    public static List<ItemStack> DISABLED_ITEMS = new ArrayList<ItemStack>();
    public static List<ItemStack> HIDDEN_ITEMS = new ArrayList<ItemStack>();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModuleManager.registerModules();
        MinecraftForge.EVENT_BUS.register(new TPPICTooltipHandler());

        ModuleManager.preInitModules();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModuleManager.initModules();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ModuleManager.postInitModules();
    }
}