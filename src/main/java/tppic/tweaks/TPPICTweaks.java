package tppic.tweaks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by McKeever on 02-Nov-16.
 */
@Mod(modid = "tppictweaks", name = "TPPIC Tweaks", version = "1.10.2-1.0.0")
public class TPPICTweaks {

    @Mod.Instance("tppictweaks")
    public static TPPICTweaks instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModuleManager.registerModules();

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