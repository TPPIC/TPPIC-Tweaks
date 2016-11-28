package tppic.tweaks.modules.test;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tppic.tweaks.lib.Module;
import tppic.tweaks.lib.Tweak;

import java.util.Collection;

/**
 * Created by McKeever on 26-Nov-16.
 */
public class ModuleTest extends Module {
    public Tweak TEST_TWEAK = new TweakTest(this);

    public ModuleTest() {
        super("testmodule", "tppictweaks");
    }

    @Override
    public Collection<String> getDependencies() {
        return null;
       /* return new ArrayList<String>() {
            {
                add("dep1");
                add("dep2");
                add("dep3");
                add("dep4");
                add("etc.");
            }
        };*/
    }

    @Override
    public void registerTweaks() {
        moduleConfig.TWEAKS.add(TEST_TWEAK);
    }

    @Override
    public void preInitModule(FMLPreInitializationEvent event) {

    }

    @Override
    public void initModule(FMLInitializationEvent event) {

    }

    @Override
    public void postInitModule(FMLPostInitializationEvent event) {

    }
}
