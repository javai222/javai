// Class created by Mance, John Roque R.

package demo;

import abstraction.Glass;
import interfacePkg.Breakable;
import implementation.WineGlass;
import implementation.WindVisorGlass;

public class AbstractionPolyDemo_Mance {
    public static void main(String[] args) {

        WineGlass drink = new WineGlass ("Drinkware", "Clear");
        WindVisorGlass visor = new WindVisorGlass ("Motor parts", "Tinted");

        // WineGlass
        // Runtime polymorphism (Overriding)
        drink.useGlass();
        drink.cleanGlass();
        drink.breakGlass();

        // Compile time Polymorphism (Overloading)
        drink.useGlass("Wine");
        drink.useGlass(100);

        // PhoneGlass
        //Runtime polymorphism
        visor.useGlass();
        visor.cleanGlass();
        visor.breakGlass();

        // Compile time polymorphism
        visor.breakScreen();
        visor.breakScreen(380);

        drink.displayGlassInfo();
        visor.displayGlassInfo();

    }
}