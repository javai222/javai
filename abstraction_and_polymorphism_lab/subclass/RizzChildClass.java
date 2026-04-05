/*
*Created by Javier, Charles Justin D.
*This class provides the child class of Rizz
*/

public abstract class Aura extends Rizz implements Sigma {
     // Constructor
    public Aura(String name, int auraLevel) {
        super(name, auraLevel);
    }
}

    //  Method Overriding 
    @Override
    public asbtract void showRizz() {
        System.out.println(getName() + " shows unmatched sigma rizz 😎");
    }

    //  Method Overriding 
    @Override
    public abstract void greet() {
        System.out.println(getName() + " says: Hey there 😉");
    }

    @Override
    public abstract void compliment(String msg) {
        System.out.println(getName() + " says: " + msg);
    }

    //  Method Overloading 
    public abstract void compliment() {
        System.out.println(getName() + " says: You're amazing ✨");
    }

    public abstract void compliment(String msg, int repeat) {
        for (int i = 0; i < repeat; i++) {
            System.out.println(getName() + " says: " + msg);
        }
    }
