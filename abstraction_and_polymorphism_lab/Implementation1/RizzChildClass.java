/*
*Created by Javier, Charles Justin D.
*This class provides the child class of Rizz
*/

package Implementation1;

import abstraction.Rizz;
import interfacePkg.Sigma;

public class RizzChildClass extends Rizz implements Sigma {
     // Constructor
    public RizzChildClass(String name, int auraLevel) {
        super(name, auraLevel);
    }
    //  Method Overriding 
    @Override
    public void showRizz() {
        System.out.println(getName() + " shows unmatched sigma rizz 😎");
    }

    //  Method Overriding 
    @Override
    public void greet() {
        System.out.println(getName() + " says: Hey there 😉");
    }

    @Override
    public void compliment(String msg) {
        System.out.println(getName() + " says: " + msg);
    }

    //  Method Overloading 
    public void compliment() {
        System.out.println(getName() + " says: You're amazing ✨");
    }

    public void compliment(String msg, int repeat) {
        for (int i = 0; i < repeat; i++) {
            System.out.println(getName() + " says: " + msg);
        }
    }
}