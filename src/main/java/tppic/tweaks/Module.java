package tppic.tweaks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by McKeever on 02-Nov-16.
 */
public abstract class Module {

    public boolean isEnabled;
    public List<Tweak> TWEAKS = new ArrayList<Tweak>();

    protected abstract String setModuleID();

    protected abstract String setTweakModID();

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

    public Tweak makeSimpleTweak(Module module, String id) {
        Tweak tweak = new SimpleTweak(module, id);
        return tweak;
    }

}
