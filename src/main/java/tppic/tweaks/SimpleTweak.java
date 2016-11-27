package tppic.tweaks;

/**
 * Created by McKeever on 27-Nov-16.
 */
public class SimpleTweak extends Tweak {

    private Module module;
    private String id;

    public SimpleTweak(Module module, String id) {
        this.module = module;
        this.id = id;
    }

    @Override
    public String setTweakID() {
        return id;
    }

    @Override
    public Module setModule() {
        return module;
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }
}
