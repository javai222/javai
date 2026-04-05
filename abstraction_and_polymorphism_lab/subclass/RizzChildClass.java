/*
*Created by Javier, Charles Justin D.
*This class provides the child class of Rizz
*/

package subclass;

public class Aura extends Rizz implements Sigma {

    public Aura(String name, int auraLevel) {
        super(name, auraLevel);
    }

    // ✅ Overriding
    @Override
    public void showRizz() {
        System.out.println(getName() + " has elite aura 🔥");
    }

    @Override
    public void greet() {
        System.out.println(getName() + ": Yo 😎");
    }

    @Override
    public void flex(String msg) {
        System.out.println(getName() + " flexes: " + msg);
    }

    // ✅ Overloading
    public void flex() {
        System.out.println(getName() + " flexes silently 🗿");
    }

    public void flex(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(getName() + ": " + msg);
        }
    }
}