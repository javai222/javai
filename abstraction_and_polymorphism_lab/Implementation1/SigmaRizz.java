/*
* Implementation created by Dolormente, Henry II S. Abstraction and Interface Class created by Silva, Vinz Joseph R.
*/

package Implementation1;

import abstraction.Rizz;
import interfacePkg.Mogger;

public class SigmaRizz extends Rizz implements Mogger {

    public SigmaRizz(String name, int auraLevel) {
        super(name, auraLevel);
    }

    // method overriding
    @Override
    public void showRizz() {
        System.out.println(getName() + " is silently dominating with sigma energy.");
    }

    @Override
    public void showcaseMog(int auraLevel) {
        System.out.println(getName() + " mogs everyone with aura level " + auraLevel);
    }

    // Overloading
    public void showcaseMog(String target) {
        System.out.println(getName() + " mogs " + target + " effortlessly.");
    }

    public void showcaseMog() {
        System.out.println(getName() + " is mogging the entire room.");
    }
}
