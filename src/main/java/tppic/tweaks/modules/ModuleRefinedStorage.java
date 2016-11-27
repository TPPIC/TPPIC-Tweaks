package tppic.tweaks.modules;

import tppic.tweaks.Module;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by McKeever on 26-Nov-16.
 */
public class ModuleRefinedStorage extends Module {
    @Override
    public String setModuleID() {
        return "RefinedStorageTweaks";
    }

    @Override
    public String setTweakModID() {
        return "tppictweaks";
    }

    @Override
    public Collection<String> getDependencies() {
        return new ArrayList<String>() {
            {
                add("refinedstorage");
            }
        };
    }

    @Override
    public void preInit() {
        System.out.println("o shit waddup I loaded preinit");
    }

    @Override
    public void init() {
        System.out.println("DAMN SON I INITTED");
    }

    @Override
    public void postInit() {
        System.out.println("much post init many wow");
    }
}
