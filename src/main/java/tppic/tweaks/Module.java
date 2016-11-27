package tppic.tweaks;

import java.util.Collection;

/**
 * Created by McKeever on 02-Nov-16.
 */
public abstract class Module {

    public abstract String setModuleID();

    public abstract String setTweakModID();

    public Collection<String> getDependencies() {
        return null;
    }

    public final String getName() {
        if (setModuleID() == null || setTweakModID() == null) {
            System.out.println("Warning: Module ID or Tweak Mod ID is null");
            return null;
        }
        return setTweakModID().toLowerCase() + ":" + setModuleID().toLowerCase();
    }

    public abstract void preInit();

    public abstract void init();

    public abstract void postInit();

}
