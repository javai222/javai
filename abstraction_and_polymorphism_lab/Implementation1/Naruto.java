package Implementation1;

import abstraction.AnimeChar;
import interfacePkg.Fight;

public class Naruto extends AnimeChar implements Fight {
    
    public Naruto() {
        super("Naruto Uzumaki", "Naruto", 900);
    }

    //Overriding abstract method
    @Override
    public void usePower() {
        System.out.println(getName() + " uses Rasengan.");
    }

    //Overriding interface methods
    @Override
    public void attack() {
        System.out.println(getName() + " attacks with shadow clone jutsu!.");
    }

    @Override
    public void damage() {
        System.out.println(getName() + " heals using Kurama chakra.");
    }

    @Override
    public void train() {
        System.out.println(getName() + " trains hard with Kakashi.");
    }

    //Overloading
    public void attack(int clones) {
        System.out.println(getName() + " attacks with " + clones + " shadow clones!" );
    }
}