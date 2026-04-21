package demo;

import abstraction.AnimeChar;
import interfacePkg.Fight;
import Implementation1.Gojo;
import Implementation1.Naruto;

public class AbstractionDemoMercado {

    public static void main(String[] args) {
        
        //Dynamic binding
        AnimeChar char1 = new Naruto();
        AnimeChar char2 = new Gojo();

        //Calls the overridden method in Naruto and Gojo classes
        char1.usePower();
        char2.usePower();
        
        System.out.println();

        //interface polymorphism
        Fight f1 = new Naruto();
        Fight f2 = new Gojo();

        f1.attack();
        f2.attack();

        System.out.println();

        //Default method from interface
        f1.standBarrage();

        System.out.println();

        //Concrete method from abstract class
        char1.showInfo();
        char2.showInfo();

        System.out.println();

        //Overloading
        Gojo g = new Gojo();
        Naruto n = new Naruto();

        g.attack("Enemy");
        n.attack(10);
    }
}