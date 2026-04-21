package Implementation1;

import abstraction.AnimeChar;
import interfacePkg.Fight;

public class Gojo extends AnimeChar implements Fight{
    
    public Gojo() {
        super("Gojo Satoru", "Jujutsu Kaisen", 1000);
    }

    //Overriding abstract mehod
    @Override
    public void usePower() {
        System.out.println(getName() + " uses Limitless Technique!.");
    }

    //Overriding interface methods
    @Override
    public void attack() {
        System.out.println(getName() + " attacks with Infinity!.");
    }

    @Override
    public void damage() {
        System.out.println(getName() + " takes minimal damage due to Infinity.");
    }

    @Override
    public void train() {
        System.out.println(getName() + " meditates and improves cursed energy.");
    }

    //Overloading
    public void attack(String target) {
        System.out.println(getName() + " attacks " + target + " with Hollow Purple!" );
    }
}
