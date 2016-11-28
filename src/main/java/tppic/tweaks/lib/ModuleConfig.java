package tppic.tweaks.lib;

import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by McKeever on 27-Nov-16.
 */
public class ModuleConfig {

    private final String CATEGORY = "MODULE";
    public List<Tweak> TWEAKS = new ArrayList<Tweak>();

    public void readConfig(Configuration config) {
        Configuration cfg = config;
        try {
            cfg.load();
            for (Tweak i : TWEAKS) {
                i.isEnabled = cfg.getBoolean(i.getName(), CATEGORY, i.enabledDefault, i.getDesc());
            }
        } catch (Exception e1) {
            System.out.println("Error: Config file problems");
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
}
