package tppic.tweaks.lib;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Collection;

/**
 * Created by McKeever on 02-Nov-16.
 */
public abstract class Module {

    public Configuration config;
    public ModuleConfig moduleConfig = new ModuleConfig();
    public String id;
    public String tweakModID;

    public Module(@Nonnull String id, @Nonnull String tweakModID) {
        this.id = id;
        this.tweakModID = tweakModID;
    }

    public Collection<String> getDependencies() {
        return null;
    }

    public final String getName() {
        return tweakModID.toLowerCase() + ":" + id.toLowerCase();
    }

    public abstract void registerTweaks();

    public abstract void preInitModule(FMLPreInitializationEvent event);

    public abstract void initModule(FMLInitializationEvent event);

    public abstract void postInitModule(FMLPostInitializationEvent event);

    public final void preInit(FMLPreInitializationEvent event) {
        registerTweaks();

        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath() + "/TPPIC-Tweaks", tweakModID.toLowerCase() + "." + id.toLowerCase() + ".cfg"));
        moduleConfig.readConfig(config);

        for (Tweak i : moduleConfig.TWEAKS) {
            if (i.isEnabled) {
                i.preInit(event);
            }
        }

        preInitModule(event);
    }

    public final void init(FMLInitializationEvent event) {
        for (Tweak i : moduleConfig.TWEAKS) {
            if (i.isEnabled) {
                i.init(event);
            }
        }
        initModule(event);
    }

    public final void postInit(FMLPostInitializationEvent event) {
        postInitModule(event);
        for (Tweak i : moduleConfig.TWEAKS) {
            if (i.isEnabled) {
                i.postInit(event);
            }
        }
        if (config.hasChanged()) {
            config.save();
        }
    }
}
