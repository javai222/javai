package Implementation1;

import abstraction.Devilfruit_Saan;
import interfacePkg.Attack;

public class OpeOpe extends Devilfruit_Saan implements Attack {

    public OpeOpe() {
        super("Ope Ope no Mi", "Paramecia", "Legendary", 20);
    }

    @Override
    public String getDescription() {
        return "Allows the user to control everything inside ROOM.";
    }

    @Override
    public String useAbility() {
        return "Performs Shambles on target";
    }

    @Override
    public String getWeakness() {
        return "Sea water and Haki.";
    }

    @Override
    public void attack() {
        System.out.println("Scalpel Slash!");
    }

    @Override
    public void defend() {
        System.out.println("ROOM Barrier!");
    }

    @Override
    public void damage() {
        System.out.println("Enemy receives internal damage.");
    }

    @Override
    public void train() {
        System.out.println("Training surgery skills.");
    }
}
