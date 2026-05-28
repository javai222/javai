package Implementation1;

// made by Torrefranca :)))

import abstraction.Devilfruit_Saan;
import interfacePkg.Attack;

public class YamiYami extends Devilfruit_Saan implements Attack {

    public YamiYami() {
        super("Yami Yami no Mi", "Logia", "Legendary", 25);
    }

    @Override
    public String getDescription() {
        return "Controls darkness and absorbs attacks.";
    }

    @Override
    public String useAbility(String target) {
        return "Pulls " + target + " into darkness.";
    }

    @Override
    public String getWeakness() {
        return "Sea water and Haki.";
    }

    @Override
    public void attack() {
        System.out.println("Dark Vortex!");
    }

    @Override
    public void defend() {
        System.out.println("Dark Shield!");
    }

    @Override
    public void damage() {
        System.out.println("Enemy takes darkness damage.");
    }

    @Override
    public void train() {
        System.out.println("Mastering darkness powers.");
    }
}