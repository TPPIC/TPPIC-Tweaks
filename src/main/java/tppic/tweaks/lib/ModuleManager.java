package tppic.tweaks.lib;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tppic.tweaks.modules.test.ModuleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by McKeever on 02-Nov-16.
 */
public class ModuleManager {

    private static List<Module> REGISTRY = new ArrayList<Module>();

    public static void registerModules() {
        register(new ModuleTest());
    }

    private static void register(Module module) {
        if (module.getName() == null) {
            System.out.println("Error: Module name is null; module will be disabled.");
            return;
        }
        if (module.getDependencies() != null) {
            for (String dep : module.getDependencies()) {
                if (!Loader.isModLoaded(dep)) {
                    System.out.println("Error: Module '" + module.getName() + "' is missing required depedency: '" + dep + "' and will be disabled.");
                    return;
                }
            }
        }

        REGISTRY.add(module);
    }

    public static void preInitModules(FMLPreInitializationEvent event) {
        for (Module i : REGISTRY) {
            i.preInit(event);
        }
    }

    public static void initModules(FMLInitializationEvent event) {
        for (Module i : REGISTRY) {
            i.init(event);
        }
    }

    public static void postInitModules(FMLPostInitializationEvent event) {
        for (Module i : REGISTRY) {
            i.postInit(event);
        }
    }

}
