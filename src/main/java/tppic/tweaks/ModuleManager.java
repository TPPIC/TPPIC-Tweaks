package tppic.tweaks;

import net.minecraftforge.fml.common.Loader;
import tppic.tweaks.modules.ModuleTest;

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

    public static void preInitModules() {
        for (Module i : REGISTRY) {
            i.preInit();
        }
    }

    public static void initModules() {
        for (Module i : REGISTRY) {
            i.init();
        }
    }

    public static void postInitModules() {
        for (Module i : REGISTRY) {
            i.postInit();
        }
    }

}
